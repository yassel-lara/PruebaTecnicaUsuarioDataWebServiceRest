/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;



/**
 *
 * @author User
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "id")
    @Type(type = "uuid-char")
    private UUID id;
    @Column(name = "name")
    private String name;   
    @Column(name = "email")
    private String email;      
    @Column(name = "password")
    private String password; 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserPhone> phones;    
    
    
    @Column(name = "create")
    private Date create;
    
    @Column(name = "modified")
    private Date modified;    
    
    @Column(name = "last_login")
    private Date lastLogin;      
    
    @Column(name = "token")
    private String token;     
    
    @Column(name = "isactive")
    private Boolean isactive;         
    
    
    public User() {
    }

    public User(UUID id) {
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

	public List<UserPhone> getPhones() {
		return phones;
	}

	public void setPhones(List<UserPhone> phones) {
		this.phones = phones;
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

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date last_login) {
		this.lastLogin = last_login;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
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
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", phones="
				+ phones + ", create=" + create + ", modified=" + modified + ", last_login=" + lastLogin
				+ ", token=" + token + ", isactive=" + isactive + "]";
	}

    
	

}
