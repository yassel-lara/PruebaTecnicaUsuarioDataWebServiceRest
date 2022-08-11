package root.controller.entity;

import java.math.BigDecimal;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import raiz.dto.entidad.administracion.AdministracionUsuarioLoginDTO;
import raiz.dto.entidad.administracion.AdministracionUsuarioLoginPermisoUsuarioLoginDTO;
import raiz.servicio.entidad.administracion.IAdministracionUsuarioLoginServicio;
import root.dto.entity.UserDTO;
import root.service.entity.IUserService;


@RestController
@RequestMapping("/entity/user")
public class UserController {
	


	@Autowired
    @Qualifier("user_service_impl_qualifier")
	private IUserService iUserService;	

	@PostMapping("/saved")
	public Object saved(@RequestBody UserDTO userDTO) {

	//	Boolean successfulSave = true;
		String errorMessage = "";
	
		if(userDTO == null) {
			
			errorMessage = errorMessage+"Datos de envío inválidos.\n ";
			

			
			
			return errorMessage;
			
		}

        AdministracionUsuarioLoginDTO administracionUsuarioLoginDTOGuardado = iAdministracionUsuarioLoginServicio.guardarAdministracionUsuarioLoginDTO(administracionUsuarioLoginDTO);

    //    System.out.println("Guardado: "+administracionUsuarioLoginDTOGuardado);
		return administracionUsuarioLoginDTOGuardado;
		
		
	}		
	
	
	

}
