package root.dto.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_phones")
public class UserPhoneDTO {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private UUID id;
    
    @Column(name = "phone", nullable = false)
    private String phone;
    
    @ManyToOne
    @JoinColumn(name = "user", nullable = false, updatable = false)
    private UserDTO user;
    
    
    public UserPhoneDTO() {
    }    
    
    public UserPhoneDTO(UUID id) {
        this.id = id;
    }

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserPhone [id=" + id + ", phone=" + phone + ", user=" + user + "]";
	}
    

	

}