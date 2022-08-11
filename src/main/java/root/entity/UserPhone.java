package root.entity;

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
public class UserPhone {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private UUID id;
    
    @Column(name = "phone", nullable = false)
    private String phone;
    
    @ManyToOne
    @JoinColumn(name = "user", nullable = false, updatable = false)
    private User user;
    
    
    public UserPhone() {
    }    
    
    public UserPhone(UUID id) {
        this.id = id;
    }

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserPhone [id=" + id + ", phone=" + phone + ", user=" + user + "]";
	}
    

	

}