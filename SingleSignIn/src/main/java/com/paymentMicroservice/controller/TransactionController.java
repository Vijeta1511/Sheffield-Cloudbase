/**
 * 
 */
package com.paymentMicroservice.controller;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.paymentMicroservice.command.applicationCommand;
import com.paymentMicroservice.command.transactionCommand;

/**
 * @author vijetaagrawal
 *
 */

@RestController
public class TransactionController {
	
	@RequestMapping(value = {"/checkout"}, method = RequestMethod.GET)
	public ModelAndView checkout(Model m) {
		m.addAttribute("command", new transactionCommand());
		ModelAndView mav = new ModelAndView("/checkout");
		return mav;
	}

	@RequestMapping(value = {"/paymentSuccessful"}, method = RequestMethod.POST)
	public ModelAndView paymentSuccessful(@ModelAttribute("command") transactionCommand cmd, Model m,  HttpSession session) {
		ModelAndView mav = new ModelAndView("/paymentSuccessful");
		return mav;
	}
	
	@RequestMapping(value = {"/paymentFailed"}, method = RequestMethod.GET)
	public ModelAndView paymentFailed(Model m) {
		ModelAndView mav = new ModelAndView("/paymentFailed");
		return mav;
	}

}
