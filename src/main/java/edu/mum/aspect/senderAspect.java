
package edu.mum.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import edu.mum.controller.EmailSendingAPI;
import edu.mum.domain.Customer;

@Aspect
public class senderAspect {

	@AfterReturning(pointcut = "execution(public String edu.mum.controller.CustomerController.processForm(..))", returning = "returnValue")
	public void readyToSendEmail(JoinPoint joinPoint, String returnValue) {
		Customer customer = (Customer) joinPoint.getArgs()[0];

		EmailSendingAPI sendEmail = new EmailSendingAPI();
		if (returnValue.equals("redirect:/product/showProducts"))
		{
			String body = "Welcome to EAShoppingStore. Your account is created successfully. You can login with username: " + 
					customer.getCredentials().getUsername();
			sendEmail.send(customer.getEmail(), "eashoppingstore@gmail.com", "Registration Successful", body);
		}
	}
}
