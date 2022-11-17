package pdt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import pdt.entity.User;
import pdt.service.UserServiceImp;

@SessionAttributes("user")
@Controller
public class LoginController {

	@Autowired
	private UserServiceImp userService;

	@RequestMapping(value = "/logIn", method = RequestMethod.POST)
	public String login(User user, Model model) {
		User findUser = userService.getUser(user.getUserId());

		if (findUser != null) {
			model.addAttribute("user", findUser);
			return "forward:gohome";
		} else {
			return "redirect:login.html";
		}
	}

	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:index.html";
	}

}
