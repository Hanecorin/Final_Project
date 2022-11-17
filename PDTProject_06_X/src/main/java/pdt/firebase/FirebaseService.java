package pdt.firebase;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.cloud.FirestoreClient;

import pdt.entity.User;

@Service
public class FirebaseService {

	public String saveUserDetails(User user) throws InterruptedException, ExecutionException {

		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<com.google.cloud.firestore.WriteResult> collectionApiFuture = dbFirestore.collection("user")
				.document(user.getUserId()).set(user);
		return collectionApiFuture.get().getUpdateTime().toString();
	}

//	public User getUserDetails(String userId) throws InterruptedException, ExecutionException {
//
//		Firestore dbFirestore = FirestoreClient.getFirestore();
//		DocumentReference documentReference = dbFirestore.collection("user").document(userId);
//		ApiFuture<DocumentSnapshot> future = documentReference.get();
//
//		DocumentSnapshot document = future.get();
//
//		User user = null;
//
//		if (document.exists()) {
//			user = document.toObject(User.class);
//			return user;
//		} else {
//			return null;
//		}
//
//	}
	@Lazy
	public User getUserDetails(String userId) throws InterruptedException, ExecutionException, FirebaseAuthException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = dbFirestore.collection("users").document(userId);
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		DocumentSnapshot document = future.get();
		User user = null;
		if (document.exists()) {
			user = document.toObject(User.class);
			
			FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(user.getIdToken());
			String uid = decodedToken.getUid();
			System.out.println(uid);
			FirebaseAuth auth = FirebaseAuth.getInstance();
			ApiFuture<UserRecord> fuser = auth.getUserByEmailAsync(userId);
			System.out.println(fuser.toString());
			return user;
		} else {
			return null;
		}
	}

	public void getAllUser() throws InterruptedException, ExecutionException {

		Firestore dbFirestore = FirestoreClient.getFirestore();
		// DocumentReference documentReference = dbFirestore.collection("user").get();
		ApiFuture<QuerySnapshot> future = dbFirestore.collection("user").get();

		List<QueryDocumentSnapshot> documents = future.get().getDocuments();

		for (QueryDocumentSnapshot document : documents) {
			System.out.println(document.getId() + " => " + document.toObject(User.class).toString());
		}
	}

}
