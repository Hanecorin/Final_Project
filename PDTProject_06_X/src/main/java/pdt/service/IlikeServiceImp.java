package pdt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pdt.dao.IlikeRepository;
import pdt.dao.PostRepository;
import pdt.dao.UserRepository;
import pdt.entity.Ilike;
import pdt.entity.Post;
import pdt.entity.User;

@Service
public class IlikeServiceImp implements IlikeService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	IlikeRepository ilikeRepository;

	@Autowired
	PostRepository postRepository;

	public boolean checkLike(User userId, Post postId) {

		return ilikeRepository.findByUserIdAndPostId(userId, postId).isEmpty();

	}

	@Transactional
	public void deleteLike(User userId, Post postId) {

		ilikeRepository.deleteByUserIdAndPostId(userId, postId);
	}

	@Transactional
	public boolean addLike(String userId, Post postId) {

		User user = userRepository.findById(userId).get();

		if (checkLike(user, postId)) {

			ilikeRepository.save(new Ilike(user, postId));

			return true;
		}

		return false;

	}

	@Transactional
	public void deleteByUserIdAndPostId(User userId, Post postId) {

		ilikeRepository.deleteByUserIdAndPostId(userId, postId);

	}

}
