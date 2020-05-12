package ecommerce.controller;

import org.apache.commons.fileupload.FileUploadException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(FileUploadException.class)
	public String handleFileUploadError() {
		return "fileupload-exception";
	}
}
