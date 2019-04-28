/**
 * 
 */
package com.paymentMicroservice.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.paymentMicroservice.command.applicationCommand;
import com.paymentMicroservice.domain.Application;
import com.paymentMicroservice.service.ApplicationService;

/**
 * @author vijetaagrawal
 *
 */
@RestController
public class ApplicationController {
	@Autowired
	private ApplicationService applicationService;
	
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public ModelAndView upload(Model m) {
		m.addAttribute("command", new applicationCommand());
		ModelAndView mav = new ModelAndView("/upload");
		return mav;
	}
	
	/*
	 * uploadFiles() method is called when users(ISV and ADMIN) are uploading the file on server.
	 * It firstly stores the file temporarily.
	 */
	
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
	
//	@RequestMapping(value = "/uploadFiles", method = RequestMethod.POST)
//	public ModelAndView uploadFiles(@ModelAttribute("command") applicationCommand cmd, Model m,  HttpSession session)  {
//		Application a=null;
//		try {
//			Application newApp = applicationService.registerApplication(a, cmd.getName(), session.getAttribute("userId"));
//		} catch (Exception e) {
//			
//			m.addAttribute("err", "Upload Unsuccessful");
//			ModelAndView mav = new ModelAndView("uploadSuccessful");
//			return mav;
//		}
//		ModelAndView mav = new ModelAndView("uploadSuccessful");
//		return mav;
//	}
	
	@RequestMapping(value = "/uploadFiles", method = RequestMethod.POST)
	public ModelAndView uploadFiles(@ModelAttribute("command") applicationCommand cmd, Model m,  HttpSession session, @RequestParam("file") MultipartFile[] files)
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
				File TempServerFile = new File(dir.getAbsolutePath()
						+ File.separator + file.getOriginalFilename());
				BufferedOutputStream bos = new BufferedOutputStream(
						new FileOutputStream(TempServerFile));
				bos.write(bytes);
				bos.close();

				
			} catch (Exception e) {
				ModelAndView mav = new ModelAndView("redirect:uploadFailed");
				return mav;
			}
		}
		//Registering a new application
				Application a=null;
				try {
					Application newApp = applicationService.registerApplication(a, cmd.getName(), session.getAttribute("userId"));
				} catch (Exception e) {
					
					ModelAndView mav = new ModelAndView("uploadFailed");
					return mav;
			
				}
		ModelAndView mav = new ModelAndView("redirect:uploadSuccessful");
		return mav;
		
	}

}
