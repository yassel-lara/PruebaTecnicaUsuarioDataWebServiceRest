package root.controller.entity;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import root.dto.entity.UserDTO;
import root.service.entity.IUserService;
import root.util.MessageUtil;
import root.util.Util;


@RestController
@RequestMapping("/entity/user")
public class UserController {
	
	@Value("${jwt.secret}")
	private String secret;

	@Autowired
    @Qualifier("user_service_impl_qualifier")
	private IUserService iUserService;	

//	private String messageErrorIntern = "Ha ocurrido un error interno. Inténtelo nuevamente. ";
	
	@GetMapping("/login")
	public Object login(@RequestParam("email") String email,@RequestParam("password") String password) {

		if(email == null || email.trim().equals("") || password == null || password.trim().equals("")) {
			
			return MessageUtil.messageDTOByMessage("Debe digitar el email y la contraseña. ");
		}
		

		UserDTO userDTOByEmail = iUserService.userByEmail(email);
		if(userDTOByEmail == null) {

			return MessageUtil.messageDTOByMessage(MessageUtil.MESSAGE_ERROR_INTERN);					
			
		}
		
		if(userDTOByEmail.getId() == null) {
			
			return MessageUtil.messageDTOByMessage("El email indicado no existe. ");				
			
		}
		
		if(!userDTOByEmail.getPassword().equals(password)) {
			
			return MessageUtil.messageDTOByMessage("La contraseña es incorrecta. ");				
			
		}
		
		userDTOByEmail.setLastLogin(new Date());
        UserDTO userDTOSaved = iUserService.saveUser(userDTOByEmail);
        if(userDTOSaved == null) {

			return MessageUtil.messageDTOByMessage(MessageUtil.MESSAGE_ERROR_INTERN);	        	
        	
        }	
        
		
		return MessageUtil.messageDTOByMessage("Ha iniciado sesión correctamente. Bienvenido a su cuenta. ");	        
		
		
	}	    

	@PostMapping("/saved")
	public Object saved(@RequestBody UserDTO userDTO) {

	
		if(userDTO == null) {			
			
			return MessageUtil.messageDTOByMessage("Datos de envío inválidos.");
			
		}
		
		Boolean emailIsValid = Util.emailIsValid(userDTO.getEmail());
		
		if(!emailIsValid) {
			
			return MessageUtil.messageDTOByMessage("Email inválido.");			
			
		}
		
		
		Boolean passwordIsValid = Util.passwordIsValid(userDTO.getPassword());
		
		if(!passwordIsValid) {
			
			return MessageUtil.messageDTOByMessage("La Contraseña de 5-25 caracteres que requiere números y letras mayúsculas y minúsculas. ");			
			
		}		
		
		Boolean emailExists;
		
		if(userDTO.getId() == null) {

			emailExists = iUserService.emailExists(userDTO.getEmail());
		}else {
			emailExists = iUserService.emailExistsWithOtherId(userDTO.getEmail(), userDTO.getId());

		}
		
		if(emailExists == null) {

			return MessageUtil.messageDTOByMessage(MessageUtil.MESSAGE_ERROR_INTERN);					
			
		}
		
		if(emailExists) {
			
			return MessageUtil.messageDTOByMessage("El email se encuentra registrado. ");				
		}
		

		if(userDTO.getId() == null) {
			userDTO.setCreate(new Date());	
			userDTO.setIsactive(true);
			userDTO.setLastLogin(new Date());
			userDTO.setToken(Util.getJWTToken(userDTO.getEmail(), secret));
			
		}else {
			
			userDTO.setModified(new Date())	;
		}
		
		
		

	    
        UserDTO userDTOSaved = iUserService.saveUser(userDTO);
        if(userDTOSaved == null) {
			return MessageUtil.messageDTOByMessage(MessageUtil.MESSAGE_ERROR_INTERN);	        	
        	
        }

		return userDTOSaved;
		
		
	}		
	
		

}
