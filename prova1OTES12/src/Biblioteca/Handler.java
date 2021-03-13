package Biblioteca;

public interface Handler {
	
	public default String HandlerAuthorization (String token) {
		if (token == "1A2B3C") {
			 return "Status Code 200";
		}
		else {
			return "Status Code 401";
		}
	}

}
