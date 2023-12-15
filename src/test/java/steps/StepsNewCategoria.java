package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

import java.time.Duration;
import java.util.List;


public class StepsNewCategoria {
	
	
	String url = "https://portaldeservicos.budibase.app/embed/portaldeservicos";
	WebDriver driver = new ChromeDriver(); 
	
	public void before() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		Duration duration = Duration.ofSeconds(15);
		driver.manage().timeouts().implicitlyWait(duration);
	}


    @Dado("que estou na página de administração do portal {string}")
    public void que_estou_na_página_de_administração_do_portal(String url) {
        driver.get(url);
        
    }

    @Quando("eu clico no botão para criar uma nova categoria")
    public void eu_clico_no_botão_para_criar_uma_nova_categoria() {
        WebElement botaoNovaCategoria = driver.findElement(By.xpath("//button[@class='spectrum-Button spectrum-Button--sizeM spectrum-Button--cta svelte-1gv5n3y c496226559d5248bcaeace31fd2432ed4-dw6ErsKxeV-dom']"));
        botaoNovaCategoria.click();
    }

    @Quando("eu preencho o nome da nova categoria como {string}")
    public void eu_preencho_o_nome_da_nova_categoria_como(String nomeCategoria) {
        WebElement campoNomeCategoria = driver.findElement(By.id("id-ca67f609421034cde97d0a716c237b2f3"));
        campoNomeCategoria.sendKeys(nomeCategoria);
    }

    @Quando("eu clico no botão para salvar a nova categoria")
    public void eu_clico_no_botão_para_salvar_a_nova_categoria() {
        WebElement botaoSalvarCategoria = driver.findElement(By.xpath("//button[@class='spectrum-Button spectrum-Button--sizeM spectrum-Button--cta svelte-1gv5n3y c496226559d5248bcaeace31fd2432ed4-B49RyVJe9-1izHXPJa9r-dom']"));
        botaoSalvarCategoria.click();
    }

    @Então("a nova categoria é criada com sucesso")
    public void a_nova_categoria_é_criada_com_sucesso() {
               
        List<WebElement> listaCategorias = driver.findElements(By.cssSelector("div[class='spectrum-Table-headCell svelte-rzhjll is-sortable'] div[class='title svelte-rzhjll']"));
        assertTrue("A nova categoria não está na lista de categorias",
                listaCategorias.stream().anyMatch(categoria -> categoria.getText().equals("Nova Categoria")));
    }
}
