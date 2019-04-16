package com.singlesignin.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.singlesignin.command.LoginCommand;
import com.singlesignin.command.UserCommand;
import com.singlesignin.domain.User;
import com.singlesignin.exception.UserBlockedException;
import com.singlesignin.service.UserService;

/**
 * This class provides mapping to HTTP requests.
 * @author sanika
 */

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;  // userService is injected in UserController
	
	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	public ModelAndView dashboard(Model m) {
		ModelAndView mav = new ModelAndView("/index");
		return mav;
	}
	
	@RequestMapping(value = {"/index_login"}, method = RequestMethod.GET)
	public ModelAndView index(Model m) {
		m.addAttribute("command", new LoginCommand());
		ModelAndView mav = new ModelAndView("/index_login");
		return mav;
	}
	
	/*
	 * handleLogin() method is called by dispatcher servlet(front controller). This controller will receive the request from user,
	 * read the data from the request parameter(Login details). And then will bind loginName and password to LoginCommand object.
	 * Then LoginCommand object will be given to controller method.
	 */
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView handleLogin(@ModelAttribute("command") LoginCommand cmd, Model m, HttpSession session) {
		
		try {
			User loggedInUser = userService.login(cmd.getLoginName(),cmd.getPassword());
			/*
			 * add error message and go back to login form
			 */
			if(loggedInUser == null) {
				
				m.addAttribute("err", "Login Failed! Enter valid credentials");
				ModelAndView mav = new ModelAndView("/index_login");
				return mav ; 	
			}
			/*
			 * On Successful login, check the role (authorization), add the user in session and redirect to appropriate dashboard.
			 * The redirecting to the correct dashboard is handled in index.jsp
			 */
			else {			
				addUserInSession(loggedInUser, session);
				ModelAndView mav = new ModelAndView("redirect:index");
				return mav ; 
				}
		} catch (UserBlockedException e) {
			m.addAttribute("err", e.getMessage()); // add error message and go back to login form
			ModelAndView mav = new ModelAndView("/index");
			return mav ; 
		}
		
	}

	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpSession session) {
		session.setAttribute("role", null);
		session.invalidate();
		ModelAndView mav = new ModelAndView("redirect:index?act=lo");
		return mav;
	}
	
	/*
	 * Add the logged in user in session
	 */
	private void addUserInSession(User u, HttpSession session) {
		
		session.setAttribute("user", u);
		session.setAttribute("userId", u.getUserId());
		session.setAttribute("role", u.getRole());
		session.setAttribute("loginName", u.getLoginName());
	}
	
	@RequestMapping(value = "/reg_form", method = RequestMethod.GET)
	public ModelAndView registrationForm(Model m) {
		UserCommand cmd = new UserCommand();
		m.addAttribute("command", cmd);
		ModelAndView mav = new ModelAndView("/reg_form");
		return mav;
	}
	
	/*
	 * registerUser() method is called by dispatcher servlet(front controller). This controller will receive the request from user,
	 * read the data from the request parameter(Registration details). And then will bind user details to User object.
	 */
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("command") User user, Model m) {
		try {	
			/*
			 * Check the length of password used for registration, to have proper encryption.
			 * After successful registration, the user is redirected to login.
			 */
			
			if(user.getPassword().length()<8) {
				m.addAttribute("err", "Registration Failed! Enter password with 8 characters");
				ModelAndView mav = new ModelAndView("/reg_form");
				return mav;
        	}
        	else if(user.getPassword().length()>8) {
        		m.addAttribute("err", "Registration Failed! Enter password with 8 characters");
        		ModelAndView mav = new ModelAndView("/reg_form");
        		return mav;
        	}
        	else {	
        		user.setLoginStatus(userService.LOGIN_STATUS_ACTIVE);
        		//System.out.println(user.getLoginName());
        		userService.register(user);}
				ModelAndView mav = new ModelAndView("redirect:index_login?act=reg");
				return mav;
		}catch(DuplicateKeyException e) {
			e.printStackTrace();
			m.addAttribute("err", "Username already exist. Please select different username."); // it takes care that the username is unique.
			ModelAndView mav = new ModelAndView("/reg_form");
			return mav;
		}
			
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public ModelAndView upload(Model m) {
		ModelAndView mav = new ModelAndView("/upload");
		return mav;
	}
	
	/*
	 * uploadFiles() method is called when users(ISV and ADMIN) are uploading the file on server.
	 * It firstly stores the file temporarily.
	 */
	
//	@RequestMapping(value = "/uploadFiles", method = RequestMethod.POST)
//	public @ResponseBody
//	String uploadFiles(@RequestParam("file") MultipartFile[] files) {
//
//		String message = "";
//		for (int i = 0; i < files.length; i++) {
//			MultipartFile file = files[i];
//			System.out.println(file.getOriginalFilename());
//			System.out.println(file);
//	
//			try {
//				byte[] bytes = file.getBytes();
//
//				// Creating the directory to store file
//				String rootPath = System.getProperty("catalina.base");
//				System.out.println(rootPath);
//				File dir = new File(rootPath + File.separator + "tmpFiles");
//				System.out.println(dir);
//				if (!dir.exists()) { // check if directory already exist
//					dir.mkdirs();
//					System.out.println("Directory has been created successfully");
//				}
//
//				// Create the file on server
//				File serverFile = new File(dir.getAbsolutePath()
//						+ File.separator + file.getOriginalFilename());
//				BufferedOutputStream stream = new BufferedOutputStream(
//						new FileOutputStream(serverFile));
//				stream.write(bytes);
//				stream.close();
//
//
//				message = message + "You successfully uploaded file=" + file.getOriginalFilename()
//						+ "<br />";
//			} catch (Exception e) {
//				return "You failed to upload " + file.getOriginalFilename() + " => " + e.getMessage();
//			}
//		}
//		return message;
//	}
//	
	@RequestMapping(value = "/uploadSuccessful", method = RequestMethod.GET)
	public ModelAndView uploadSucess(Model m) {
		ModelAndView mav = new ModelAndView("/uploadSuccessful");
		return mav;
	}
	@RequestMapping(value = "/uploadFailed", method = RequestMethod.GET)
	public ModelAndView uploadFail(Model m) {
		ModelAndView mav = new ModelAndView("/uploadFailed");
		return mav;
	}
	
	@RequestMapping(value = "/uploadFiles", method = RequestMethod.POST)
	public ModelAndView uploadFiles(@RequestParam("file") MultipartFile[] files)
	{
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];
			System.out.println(file.getOriginalFilename());
			System.out.println(file);
	
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.base");
				System.out.println(rootPath);
				File dir = new File(rootPath + File.separator + "tmpFiles");
				System.out.println(dir);
				if (!dir.exists()) { // check if directory already exist
					dir.mkdirs();
					System.out.println("Directory has been created successfully");
				}

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + file.getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				
			} catch (Exception e) {
				ModelAndView mav = new ModelAndView("redirect:uploadFailed");
				return mav;
			}
		}
		ModelAndView mav = new ModelAndView("redirect:uploadSuccessful");
		return mav;
		
	}


}
