package seo.dale.commerce.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 서대영(DAEYOUNG SEO)/Onestore/SKP
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody String handleStorePlatformError(Exception exception, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("#EXCEPTION\n", exception);
		logger.debug("#REQUEST\n", request);
		logger.debug("#RESPONSE\n", response);
		return exception.toString();
	}

}
