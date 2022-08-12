package root.repositoryextended.entity;


import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import root.entity.User;



@Repository
public class UserRepositoryExtended {

	@PersistenceContext
    private EntityManager entityManager;
	  
	   public User userByEmailWithOtherId(String email,UUID id) {
	    	
		   if(email == null || id == null) {
			   return null;
		   }		   
		   
		   User user;
	       try {
	           
	            String consulta = "Select u from User u where lower(trim(u.email)) = :email and u.id <> :id";
	            
	            Query query = entityManager.createQuery(consulta);
	            query.setParameter("email", email.trim().toLowerCase());
	            query.setParameter("id", id);
	            
	            List<User> userList = query.getResultList();
	            if(!userList.isEmpty()) {
	            	 
	            	user = userList.get(0); 
	            	 
	            }else user = new User();	
	            

	        } catch (Exception e) {
	        	user = null;
	            e.printStackTrace();
	        }
	        
	        return user;
	    }	
	
	
	   public User userByEmail(String email) {
	    	
		   if(email == null) {
			   return null;
		   }		   
		   
		   User user;
	       try {
	           
	            String consulta = "Select u from User u where lower(trim(u.email)) = :email";
	            
	            Query query = entityManager.createQuery(consulta);
	            query.setParameter("email", email.trim().toLowerCase());
	            
	            List<User> userList = query.getResultList();
	            if(!userList.isEmpty()) {
	            	 
	            	user = userList.get(0); 
	            	 
	            }else user = new User();	
	            

	        } catch (Exception e) {
	        	user = null;
	            e.printStackTrace();
	        }
	        
	        return user;
	    }	
	   
	    
	
	
}
