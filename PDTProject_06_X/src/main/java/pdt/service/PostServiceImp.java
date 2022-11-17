package pdt.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pdt.dao.PostRepository;
import pdt.dto.PostDTO;
import pdt.entity.Post;
import pdt.entity.User;

@DynamicInsert
@DynamicUpdate
@Service
public class PostServiceImp implements PostService {

	ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private PostRepository postRepo;

	public List<PostDTO> getPostList() {

		List<Post> postList = (List<Post>) postRepo.findAll();

		List<PostDTO> postListDTO = postList.stream().map(post -> modelMapper.map(post, PostDTO.class))
				.collect(Collectors.toList());

		return postListDTO;
	}

	public void insertPost(Post post) {


		postRepo.save(post);

	}

	public PostDTO getPost(PostDTO post) {
		Post postEntity = modelMapper.map(post, Post.class);

		Post findPost = postRepo.findById(postEntity.getPostId()).get();
		PostDTO findPostDTO = modelMapper.map(findPost, PostDTO.class);

		return findPostDTO;
	}

	public void updatePost(Post post) {
		/*
		 * Board 객체는 영속성 context 영역에 저장 영속성 영역의 객체 데이터 저장 후 save - 새로운 데이터 갱신 확인 후에
		 * update
		 * 
		 */
		Post findPost = postRepo.findById(post.getPostId()).get();

		findPost.setText(post.getText());
		findPost.setKeyword(post.getKeyword());
		findPost.setKeyword1(post.getKeyword1());
		findPost.setKeyword2(post.getKeyword2());
		findPost.setKeyword3(post.getKeyword3());
		postRepo.save(findPost);
	}

	@Transactional
	public void deletePost(PostDTO post) {

		Post postEntity = modelMapper.map(post, Post.class);
		postRepo.deleteById(postEntity.getPostId());
	}

	public List<PostDTO> getPostList2() {

		List<Post> postList = postRepo.getPostList();
		List<PostDTO> postListDTO = postList.stream().map(post -> modelMapper.map(post, PostDTO.class))
				.collect(Collectors.toList());

		

		return postListDTO;
	}

	public List<PostDTO> getPostListWithUserId(User user) {

		List<Post> postList = postRepo.getPostListWithUserId(user);
		List<PostDTO> postListDTO = postList.stream().map(post -> modelMapper.map(post, PostDTO.class))
				.collect(Collectors.toList());

		return postListDTO;

	}

	public void countLike(Long postId) {

		postRepo.countLike(postId);
	}

	public Long returnLike(Long postId) {

		Long value = postRepo.returnLike(postId);

		return value;
	}

	public List<Map<String, Object>> countKeyword() {

		List<Map<String, Object>> countList = postRepo.countKeyword();

		return countList;

	}

	public List<PostDTO> searchKeyword(String keyword) {
		List<Post> postList = postRepo.searchKeyword(keyword);
		List<PostDTO> postListDTO = postList.stream().map(post -> modelMapper.map(post, PostDTO.class))
				.collect(Collectors.toList());

		return postListDTO;

	}

}