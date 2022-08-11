/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.dto.entity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



/**
 *
 * @author User
 */
@Entity
@Table(name = "users")
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;
    @Column(name = "name")
    private String name;   
    @Column(name = "email")
    private String email;      
    @Column(name = "password")
    private String password; 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserPhoneDTO> userPhoneList;    
    
    
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

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", userPhoneList="
				+ userPhoneList + "]";
	}
	

}
