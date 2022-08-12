package root.util;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


public class Util {
	
	public static final String REGULAR_EXPRESSION_PASSWORD = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{5,25}$";
	
    public static Boolean passwordIsValid(String password) {
        
    	Boolean isValid = true;
    	if(password == null) {
    		isValid = false;
    		return isValid;
    	}
    	

        Pattern pattern = Pattern
                .compile(REGULAR_EXPRESSION_PASSWORD);
 

        Matcher mather = pattern.matcher(password);
 
        if (!mather.find() == true) {
        	isValid = false; 
        } 
        
        return isValid;
    }	
	

	public static String getJWTToken(String email, String secretKey) {
	
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(email)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return token;
	}	
	
	
    public static Boolean emailIsValid(String email) {
        
    	Boolean isValid = true;
    	if(email == null) {
    		isValid = false;
    		return isValid;
    	}
    	

        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 

        Matcher mather = pattern.matcher(email.trim());
 
        if (!mather.find() == true) {
        	isValid = false; 
        } 
        
        return isValid;
    }	
	
	

}
