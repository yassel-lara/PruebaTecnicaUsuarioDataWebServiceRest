package root.dto.entity;

import java.util.UUID;


public class UserPhoneDTO {

    private UUID id;
    private String phone;
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