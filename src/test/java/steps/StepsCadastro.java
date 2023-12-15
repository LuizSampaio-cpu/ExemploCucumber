package steps;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.DataTableType;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class StepsCadastro {
	WebDriver driver = new ChromeDriver();
	
	@DataTableType
    public UsuarioConjunto definirUsuario(Map<String, String> entry) {
        return new UsuarioConjunto(entry.get("Nome"), entry.get("Email"), entry.get("Senha"), entry.get("Telefone"), entry.get("Tipo"));
    }

    public static class UsuarioConjunto {
        private String nome;
        private String email;
        private String senha;
        private String telefone;
        private String tipo;

        public UsuarioConjunto(String nome, String email, String senha, String telefone, String tipo) {
            this.nome = nome;
            this.email = email;
            this.senha = senha;
            this.telefone = telefone;
            this.tipo = tipo;
        }

        
        public String getNome() {
            return nome;
        }

        public String getEmail() {
            return email;
        }

        public String getSenha() {
            return senha;
        }

        public String getTelefone() {
            return telefone;
        }
        
        public String getTipo() {
            return tipo;
        }
    }
	
	@Dado("que estou na página de cadastro {string}")
	public void que_estou_na_página_de_cadastro(String url) {
		driver.get(url);
	}

	@Quando("eu clico no botão {string}")
	public void eu_clico_no_botão_criauser(String string) {
		 WebElement btnSalvar = driver.findElement(By.xpath("//button[@class='spectrum-Button spectrum-Button--sizeM spectrum-Button--cta svelte-1gv5n3y cbb5a0088c01948e09e845bb3a44baed2-UNwIgTgJmM-dom']"));

		    if (btnSalvar != null) {
		        btnSalvar.click();
		    } else {
		        System.out.println("Botão 'Salvar' não encontrado.");
		    }
		}	
	
	@Quando("eu preencho o formulário com as seguintes informações:")
	public void eu_preencho_o_formulário_com_as_seguintes_informações(UsuarioConjunto usuario) {
		driver.findElement(By.name("nome")).sendKeys(usuario.getNome());
        driver.findElement(By.name("email")).sendKeys(usuario.getEmail());
        driver.findElement(By.name("senha")).sendKeys(usuario.getSenha());
        driver.findElement(By.name("telefone")).sendKeys(usuario.getTelefone());
        driver.findElement(By.name("tipo")).sendKeys(usuario.getTipo());
	}

	@Quando("eu clico no botão categoria {string}")
	public void eu_clico_no_botão(String string) {
		 WebElement btnSalvar = driver.findElement(By.xpath("//button[@class='spectrum-Button spectrum-Button--sizeM spectrum-Button--cta svelte-1gv5n3y cbb5a0088c01948e09e845bb3a44baed2-jblCfr4zf-F701UaVaob-dom']"));

		    if (btnSalvar != null) {
		        btnSalvar.click();
		    } else {
		        System.out.println("Botão 'Salvar' não encontrado.");
		    }
		}	

	@Então("eu devo ser redirecionado para a página inicial logado")
	public void eu_devo_ser_redirecionado_para_a_página_inicial_logado() {
	    
		 
	    String urlAtual = driver.getCurrentUrl();
	    
	    assertEquals("Não foi redirecionado para a página inicial logado",
	            "https://portaldeservicos.budibase.app/", urlAtual);
	}
}
