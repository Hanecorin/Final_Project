package pdt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import pdt.dao.IlikeRepository;
import pdt.dao.PostRepository;
import pdt.dao.ReplyRepository;
import pdt.dao.UserRepository;
import pdt.entity.Post;
import pdt.entity.Reply;
import pdt.entity.User;
import pdt.service.IlikeServiceImp;
import pdt.service.PostServiceImp;
import pdt.service.ReplyService;
import pdt.service.UserService;

@SessionAttributes("postList")
@Controller
public class Cont {

	@Autowired
	PostServiceImp postService;

	@Autowired
	PostRepository postRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	IlikeRepository ilikeRepository;

	@Autowired
	IlikeServiceImp ilikeService;

	@Autowired
	UserService userService;

	@Autowired
	ReplyService replyService;

	@Autowired
	ReplyRepository replyRepository;

//	@RequestMapping("/gohome")
//	public String goHome(@ModelAttribute("user") User user, Model model) {
//		// User findUser = userService.getUser(user);
//		List<Post> postList = postRepository.getPostList();
//		model.addAttribute("postList", postList);
//		return "home";
//	}
//
//	@RequestMapping("/write")
//	public String write(@ModelAttribute("user") User user, Model model, @ModelAttribute("post") Post post) {
////		System.out.println(model.getAttribute("user"));
////		User user1 = (User) model.getAttribute("user");
////		System.out.println(user1.getUserId());
////		System.out.println(user1.getImgUrl());
////		System.out.println(user.getUserId());
////		System.out.println(post.getUserId().getImgUrl());
////		System.out.println(post.getText());
////		System.out.println(post);
//		String[] arr = post.getKeyword().split(", ");
//		
//		System.out.println(arr[0]);
//		System.out.println(arr[1]);
//		System.out.println(arr[2]);
//		post.setKeyword1(arr[0]);
//		post.setKeyword2(arr[1]);
//		post.setKeyword3(arr[2]);
//		
//		postService.insertPost(post);
//		List<Post> postList = postRepository.getPostList();
//		model.addAttribute("postList", postList);
//		return "home";
//	}
//
//	@RequestMapping("/gowrite")
//	public String gowrite(@ModelAttribute("user") User user, Model model) {
//		// System.out.println(model.getAttribute("user"));
//		return "write";
//	}
//
//	@RequestMapping("/ilike")
//	public String addLike(@RequestParam("userId") User user, Model model, @RequestParam("postId") Post post) {
//		boolean a = ilikeService.addLike(user.getUserId(), post);
//		System.out.println(a);
//		if (a) {
//			postRepository.countLike(post.getPostId());
//			return "home";
//		} else {
//			ilikeService.deleteByUserIdAndPostId(user, post);
//			postRepository.countLike(post.getPostId());
//		}
//
//		return "home";
//
//	}
//
//	@RequestMapping("/goreply")
//	public String goReply(@RequestParam("postId") Post post, Model model) {
//		Post findPost = postService.getPost(post);
//		model.addAttribute("postId", findPost.getPostId());
//		List<Reply> replyList = replyRepository.findByPostId(findPost);
//		model.addAttribute("replyList", replyList);
//		return "reply";
//	}
//
//	@RequestMapping("/reply")
//	public String reply(Model model, Reply reply) {
////		System.out.println(model.getAttribute("user"));
////		System.out.println(reply.getUserId());
////		System.out.println(reply.getPostId());
////		System.out.println(reply.getText());
////		System.out.println(reply);
//		replyService.insertReply(reply);
//		List<Post> postList = postRepository.getPostList();
//		model.addAttribute("postList", postList);
//		return "home";
//	}
//
//	@RequestMapping("/goreplywrite")
//	public String goReplyWrite(@ModelAttribute("postId") Post post, Model model) {
//
//		return "replywrite";
//	}
//
//	@RequestMapping("/getuser")
//	public String getUser(@RequestParam("user") User user, Model model) {
//		User findUser = userService.getUser(user);
//		model.addAttribute("user", findUser);
//		List<Post> postList = postRepository.getPostListWithUserId(findUser);
//		model.addAttribute("postList", postList);
//		return "profile";
//	}
//
//	@RequestMapping("/goprofile")
//	public String goProfile(@RequestParam("user") User user, Model model) {
//		User findUser = userService.getUser(user);
//		model.addAttribute("user", findUser);
//		List<Post> postList = postRepository.getPostListWithUserId(findUser);
//		model.addAttribute("postList", postList);
//		return "profile";
//	}
//
//	@RequestMapping("/updateprofile")
//	public String updateProfile(User user, Model model) {
//		System.out.println(user);
//		userService.updateUser(user);
//		model.addAttribute("user", userService.getUser(user));
//		return "profile";
//	}
//
//	@RequestMapping("/goupdatepost")
//	public String goUpdatePost(@RequestParam("postId") Post post, Model model) {
//		Post findPost = postService.getPost(post);
//		model.addAttribute("post", findPost);
//		return "postupdate";
//	}
//
//	@RequestMapping("/updatepost")
//	public String updatePost(Post post, Model model) {
//		System.out.println(post);
//		postService.updatePost(post);
//		User findUser = userService.getUser(post.getUserId());
//		System.out.println(findUser);
//		List<Post> postList = postRepository.getPostListWithUserId(findUser);
//		model.addAttribute("postList", postList);
//		return "profile";
//	}
//	
//	@RequestMapping("/deletepost")
//	public String deletePost(Post post, Model model, User user) {
//		System.out.println(post);
//		postService.deletePost(post);
//		System.out.println(user);
//		List<Post> postList = postRepository.getPostListWithUserId(user);
//		model.addAttribute("postList", postList);
//		return "profile";
//	}

}
