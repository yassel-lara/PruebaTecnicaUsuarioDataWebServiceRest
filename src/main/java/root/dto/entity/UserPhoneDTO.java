package root.dto.entity;

import java.util.UUID;


public class UserPhoneDTO {

    private UUID id;
    private String number;
    private String citycode;
    private String contrycode;
    
    private UserDTO user;
    
    
    public UserPhoneDTO() {
    }    
    
    public UserPhoneDTO(UUID id) {
        this.id = id;
    }

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getContrycode() {
		return contrycode;
	}

	public void setContrycode(String contrycode) {
		this.contrycode = contrycode;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserPhoneDTO [id=" + id + ", number=" + number + ", citycode=" + citycode + ", contrycode=" + contrycode
				+ ", user=" + user + "]";
	}

    

}