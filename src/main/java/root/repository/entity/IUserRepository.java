package root.repository.entity;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import root.entity.User;




@Repository
public interface IUserRepository extends JpaRepository<User, UUID> {
	
	

}
