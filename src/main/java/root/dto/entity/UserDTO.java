/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.dto.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;





/**
 *
 * @author User
 */

public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID id;
    private String name;   
    private String email;      
    private String password; 
    private List<UserPhoneDTO> userPhoneList;    
    

    private Date create;
    private Date modified;    
    private Date last_login;      
    private Date token;     
    private Boolean isactive;     
    
    
    public UserDTO() {
    }

    public UserDTO(UUID id) {
        this.id = id;
    }

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserPhoneDTO> getUserPhoneList() {
		return userPhoneList;
	}

	public void setUserPhoneList(List<UserPhoneDTO> userPhoneList) {
		this.userPhoneList = userPhoneList;
	}

	public Date getCreate() {
		return create;
	}

	public void setCreate(Date create) {
		this.create = create;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Date getLast_login() {
		return last_login;
	}

	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}

	public Date getToken() {
		return token;
	}

	public void setToken(Date token) {
		this.token = token;
	}

	public Boolean getIsactive() {
		return isactive;
	}

	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", userPhoneList=" + userPhoneList + ", create=" + create + ", modified=" + modified + ", last_login="
				+ last_login + ", token=" + token + ", isactive=" + isactive + "]";
	}


    
	


}
