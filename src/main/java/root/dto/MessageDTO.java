/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.dto;

import java.io.Serializable;


public class MessageDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String mensaje;   
    
    
    public MessageDTO() {
    }

    
	public MessageDTO(String mensaje) {
		super();
		this.mensaje = mensaje;
	}


	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	@Override
	public String toString() {
		return "MessageDTO [mensaje=" + mensaje + "]";
	}

   

}
