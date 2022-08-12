package root.util;




import root.dto.MessageDTO;

public class MessageUtil {
	
	public static final String MESSAGE_ERROR_INTERN  = "Ha ocurrido un error interno. Inténtelo nuevamente.";
	
	
	public static MessageDTO messageDTOByMessage(String message) {
		
		return new MessageDTO(message);
		
	}

	
	

}
