package pdt.service;

import java.util.List;
import java.util.Map;

import pdt.dto.PostDTO;
import pdt.entity.Post;
import pdt.entity.User;

public interface PostService {

	void insertPost(Post post);

	PostDTO getPost(PostDTO post);

	void updatePost(Post post);

	void deletePost(PostDTO post);

	public List<PostDTO> getPostList();

	public List<PostDTO> getPostListWithUserId(User user);

	public void countLike(Long postId);

	public Long returnLike(Long postId);

	public List<Map<String, Object>> countKeyword();

	public List<PostDTO> searchKeyword(String keyword);

}
