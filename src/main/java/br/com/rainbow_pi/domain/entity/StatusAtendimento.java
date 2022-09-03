package br.com.rainbow_pi.domain.entity;

public enum StatusAtendimento {
	
	FINALIZADO, 	INICIADO, CANCELADO, ESPERA;

	public boolean equalsIgnoreCase(String string) {
		
		return false;
	}

}
