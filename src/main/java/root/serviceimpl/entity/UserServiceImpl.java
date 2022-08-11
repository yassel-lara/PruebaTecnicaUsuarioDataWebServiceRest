package root.serviceimpl.entity;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import raiz.dto.entidad.administracion.AdministracionUsuarioLoginDTO;
import raiz.entidad.administracion.AdministracionUsuarioLogin;
import raiz.repositorio.entidad.administracion.IAdministracionUsuarioLoginRepositorio;
import raiz.repositorioextendido.entidad.administracion.AdministracionUsuarioLoginRepositorioExtendido;
import raiz.servicio.entidad.administracion.IAdministracionUsuarioLoginServicio;
import raiz.util.entidad.administracion.AdministracionUsuarioLoginUtil;
import root.dto.entity.UserDTO;
import root.repository.entity.IUserRepository;
import root.service.entity.IUserService;

@Service
@Qualifier("user_service_impl_qualifier")
@Transactional(readOnly = true)
public class UserServiceImpl implements IUserService {

	@Autowired
    private IUserRepository iUserRepository;

	@Override
	@Transactional
	public UserDTO saveDTO(
			UserDTO userDTO) {
		
		
		   
		
		   if(administracionUsuarioLoginDTO == null) {
			   return null;
		   }
		   
		   AdministracionUsuarioLogin administracionUsuarioLoginAGuardar = AdministracionUsuarioLoginUtil.convertirAdministracionUsuarioLoginDTOAAdministracionUsuarioLogin(administracionUsuarioLoginDTO);
		   AdministracionUsuarioLogin administracionUsuarioLoginGuardado = iAdministracionUsuarioLoginRepositorio.save(administracionUsuarioLoginAGuardar);
		   
		   if(administracionUsuarioLoginGuardado == null) {
			   
			   return null;
		   }
		   
		   AdministracionUsuarioLoginDTO administracionUsuarioLoginDTOADevolver = AdministracionUsuarioLoginUtil.convertirAdministracionUsuarioLoginAAdministracionUsuarioLoginDTO(administracionUsuarioLoginGuardado);
		   System.out.println("Guardado: "+administracionUsuarioLoginGuardado);

		return administracionUsuarioLoginDTOADevolver;
	}

	


}
