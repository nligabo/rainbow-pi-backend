package br.com.rainbow_pi.service;

import org.springframework.stereotype.Component;

import br.com.rainbow_pi.domain.entity.StatusAtendimento;

@Component
public class AtualizaStatusService implements IAtualizaStatus{

	private void setStatusAtendimento(StatusAtendimento espera) {
	}
	@Override
	public String atualizarStatus(StatusAtendimento status) {
		if(status.equalsIgnoreCase("ESPERA"))
			setStatusAtendimento(StatusAtendimento.ESPERA);
		return null;
	}

}
 