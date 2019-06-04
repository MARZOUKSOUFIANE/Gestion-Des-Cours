package org.glsid.security;

import javax.validation.Valid;

import org.glsid.dao.UserRepository;
import org.glsid.entities.Departement;
import org.glsid.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecurityController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder PasswordEncoder;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/account")
	public String account() {
		return "account";
	}

	@RequestMapping("/403")
	public String accessDenied() {
		return "403";
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(Model model, String username, String password_confirm, String password) {
		if (!password.equals(password_confirm)) {
			model.addAttribute("failedConfirmPasswd", "ERROR, confirmation of password is uncorrect");
			return "account";
		}
		User user = new User(username, PasswordEncoder.encode(password));
		userRepository.save(user);
		return "redirect:/login";

	}
}
