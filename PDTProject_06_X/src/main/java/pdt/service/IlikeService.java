package pdt.service;

import pdt.entity.Post;
import pdt.entity.User;

public interface IlikeService {

	boolean addLike(String userId, Post post);

	boolean checkLike(User userId, Post post);

	void deleteLike(User userId, Post post);

	//void deleteByUserId(User userId);
	
	void deleteByUserIdAndPostId(User userId, Post postId);

}
