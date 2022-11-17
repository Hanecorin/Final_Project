package pdt.controller;

import java.util.List;

import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.firebase.auth.FirebaseAuthException;

import pdt.dao.IlikeRepository;
import pdt.dao.PostRepository;
import pdt.dao.ReplyRepository;
import pdt.dao.UserRepository;
import pdt.dto.CreatePostDTO;
import pdt.dto.GoprofileDTO;
import pdt.dto.PostDTO;
import pdt.dto.UserDTO;

import pdt.entity.Post;
import pdt.entity.User;
import pdt.firebase.FirebaseService;
import pdt.service.IlikeServiceImp;
import pdt.service.PostServiceImp;
import pdt.service.ReplyService;
import pdt.service.UserServiceImp;

@CrossOrigin(origins = "http://localhost:3000")
@SessionAttributes("user")
@RestController
public class RestCont {

	@Autowired
	PostServiceImp postService;

	@Autowired
	PostRepository postRepository;

	@Autowired
	UserServiceImp userService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	IlikeRepository ilikeRepository;

	@Autowired
	IlikeServiceImp ilikeService;

	@Autowired
	ReplyService replyService;

	@Autowired
	ReplyRepository replyRepository;

	@Autowired
	FirebaseService firebaseService;

	ModelMapper modelMapper = new ModelMapper();

	@GetMapping("/gohome")
	public List<PostDTO> goHome() {// @ModelAttribute("user") User user, Model model) {

		postRepository.getPostList();

		List<PostDTO> postListDTO = postService.getPostList2();
		return postListDTO;
	}

	@GetMapping("/goprofile/{userId}")
	public GoprofileDTO goProfile(@PathVariable String userId) {
		System.out.println(userId);
		User user = userService.getUser(userId);
		UserDTO userDTO = modelMapper.map(user, UserDTO.class);

		List<PostDTO> postListDTO = postService.getPostListWithUserId(user);
		GoprofileDTO goProfile = new GoprofileDTO(postListDTO, userDTO);

		return goProfile;
	}

	@PostMapping("/write")
	public void write(@RequestBody CreatePostDTO createPostDTO) {

		PostDTO postDTO = createPostDTO.getPost();
		String userId = createPostDTO.getUserId();

		Post post = modelMapper.map(postDTO, Post.class);
		post.setUserId(userRepository.findById(userId).get());
		if (post.getKeyword().length() != 0) {
			String[] arr = post.getKeyword().split(",");
			int a = arr.length;
			if (a == 1) {
				arr[0] = arr[0].replace("#", "");
				post.setKeyword1(arr[0]);

			} else if (a == 2) {

				arr[0] = arr[0].replace("#", "");
				arr[1] = arr[1].replace("#", "");
				post.setKeyword1(arr[0]);
				post.setKeyword2(arr[1]);

			} else {

				arr[0] = arr[0].replace("#", "");
				arr[1] = arr[1].replace("#", "");
				arr[2] = arr[2].replace("#", "");
				post.setKeyword1(arr[0]);
				post.setKeyword2(arr[1]);
				post.setKeyword3(arr[2]);
			}
		}
		postService.insertPost(post);

	}

	@GetMapping("/getting/{postId}")
	public PostDTO getOnePost(@PathVariable Long postId) {
		Post post = postRepository.findById(postId).get();
		PostDTO postDTO = modelMapper.map(post, PostDTO.class);
		return postDTO;
	}

	@PutMapping("/posting/{postId}")
	public void updatePost(@PathVariable Long postId, @RequestBody CreatePostDTO createPostDTO) {
		PostDTO postDTO = createPostDTO.getPost();
		Post post = modelMapper.map(postDTO, Post.class);

		if (post.getKeyword().length() != 0) {
			String[] arr = post.getKeyword().split(",");
			int a = arr.length;
			if (a == 1) {
				arr[0] = arr[0].replace("#", "");
				post.setKeyword1(arr[0]);

			} else if (a == 2) {

				arr[0] = arr[0].replace("#", "");
				arr[1] = arr[1].replace("#", "");
				post.setKeyword1(arr[0]);
				post.setKeyword2(arr[1]);

			} else {

				arr[0] = arr[0].replace("#", "");
				arr[1] = arr[1].replace("#", "");
				arr[2] = arr[2].replace("#", "");
				post.setKeyword1(arr[0]);
				post.setKeyword2(arr[1]);
				post.setKeyword3(arr[2]);
			}
		}
		postService.updatePost(post);
	}

	@PutMapping("/ilike")
	public Long addLike(@RequestBody CreatePostDTO createPostDTO) {
		PostDTO postDTO = createPostDTO.getPost();
		Post post = modelMapper.map(postDTO, Post.class);

		String userId = createPostDTO.getUserId();

		User user = userRepository.findById(userId).get();

		boolean a = ilikeService.addLike(userId, post);
		System.out.println(a);
		if (a) {
			postService.countLike(post.getPostId());
			return postService.returnLike(post.getPostId());
		} else {
			ilikeService.deleteByUserIdAndPostId(user, post);
			postService.countLike(post.getPostId());
		}
		return postService.returnLike(post.getPostId());

	}

	@PutMapping("/updateuser")
	public void updateUser(@RequestBody UserDTO userDTO) {
		userService.updateUser(userDTO);
	}

	@DeleteMapping("/deletepost/{postId}")
	public void deletePost(@PathVariable Long postId) {

		postRepository.deleteById(postId);
	}

	@GetMapping("/countkeyword")
	public List<Map<String, Object>> countKeyword() {

		List<Map<String, Object>> keywordList = postRepository.countKeyword();

		return keywordList;
	}

	@GetMapping("/searchkeyword/{keyword}")
	public List<PostDTO> searcKeyword(@PathVariable String keyword) {

		List<PostDTO> searchList = postService.searchKeyword(keyword);

		return searchList;
	}

	@PostMapping("/getuserinform/{userId}")
	public void getUser(@PathVariable String userId)
			throws InterruptedException, ExecutionException, FirebaseAuthException {
		Thread.sleep(2500);
		User a = firebaseService.getUserDetails(userId);

		userService.insertUser(a);

	}

}
