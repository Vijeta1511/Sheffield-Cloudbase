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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.paymentMicroservice.service.Peanut_accountService;


/**
 * @author vijetaagrawal
 *
 */
@RestController
public class Peanut_accountController {
	@Autowired 
	private Peanut_accountService peanut_accountService;
	
	@RequestMapping(value = {"/viewAccount"}, method = RequestMethod.GET)
	public ModelAndView viewTransactions(Model m) {
		ModelAndView mav = new ModelAndView("/viewAccount");
		return mav;
	}
	
}



