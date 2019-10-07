package br.com.selenium.java.automation.step.definition;

import br.com.selenium.java.automation.action.UsefulFunctions;
import cucumber.api.java.pt.Dado;

public class BoasVindasSD extends UsefulFunctions {

	@Dado("^que eu envio a mensagem de boas-vindas ao console$")
	public void que_eu_envio_a_mensagem_de_boas_vindas_ao_console() {
		sendMessageConsole("./resources/arquivos/mensagem_automacao.txt");
	}
}