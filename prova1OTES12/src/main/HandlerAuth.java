package main;
import Biblioteca.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;

public class HandlerAuth implements Handler {
	 	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/yyyy");  
	LocalDateTime today =  LocalDateTime.now();

	public String HandlerVerifyDate (LocalDateTime Date) {
		LocalDateTime now = LocalDateTime.now();  
		System.out.println(dtf.format(now));
		
		if (today.isBefore(Date)) {
			 return "Status Code 200";
		}
		else {
			return "Status Code 401";
		}		
	}
}

