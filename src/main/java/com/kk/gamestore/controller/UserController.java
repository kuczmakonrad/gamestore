package com.kk.gamestore.controller;

import com.kk.gamestore.domain.User;
import com.kk.gamestore.domain.UserRole;
import com.kk.gamestore.service.UserRoleService;
import com.kk.gamestore.service.UserService;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRoleService userRoleService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String userList(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("users", userService.userList());
		return "user";
	}

	@RequestMapping(value = "user/add", method = RequestMethod.GET)
	public String addUser1(Model model) {
		User newUser = new User();
		model.addAttribute("newUser", newUser);
		return "addUser";
	}

	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") @Valid User newUser, BindingResult result) {
		if (result.hasErrors()) {
			return "user";
		}

		UserRole userRole = new UserRole();
		userRole.setUserLogin(newUser.getUserLogin());
		userRole.setUserRole("ROLE_CLIENT");

		userService.addUser(newUser);
		userRoleService.addUserRole(userRole);
		return "redirect:/login";

	}

	@RequestMapping(value = "/users/list/delete/user")
	public String deleteUserById(@RequestParam("id") String userId) {
		int id = Integer.valueOf(userId);
		userRoleService.deleteUserRole(userRoleService.getUserRoleByUserId(userId));
		userService.deleteUser(userService.getUserById(id));
		return "redirect:/users/list";
	}

	@RequestMapping("/edit/{id}")
	public String editUser(@PathVariable("id") int id, Model model) {
		model.addAttribute("user", this.userService.getUserById(id));
		model.addAttribute("userList", this.userService.userList());
		return "user";
	}

	@RequestMapping(value = "/users/list")
	public String getAllUsers(Model model) {
		model.addAttribute("user", userService.userList());
		return "list";
	}

}
