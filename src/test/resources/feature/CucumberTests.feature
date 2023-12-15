#language:pt

Funcionalidade: Testes CI
Cenario: Criar uma nova categoria
    Dado que estou na página de administração do portal "https://portaldeservicos.budibase.app/embed/portaldeservicos#/categoria"
    Quando eu clico no botão para criar uma nova categoria
    E eu preencho o nome da nova categoria como "Nova Categoria"
    E eu clico no botão para salvar a nova categoria
    Então a nova categoria é criada com sucesso   
    
    
Cenario: Visualizar serviços por categoria

Dado que eu estou na página inicial do portal "https://portaldeservicos.budibase.app/embed/portaldeservicos"
Quando buscar por "//a[@class='link svelte-1pkxpi2 active']"
Então eu devo ver uma lista de "categorias disponíveis"

Cenario: Preencher formulário de cadastro com informações válidas
    Dado que estou na página de cadastro "https://portaldeservicos.budibase.app/embed/portaldeservicos#/pessoa"
    Quando eu preencho o formulário com as seguintes informações:
      | Nome           | João Silva        |
      | Email          | joao@email.com    |
      | Senha          | senha123          |
      | Telefone			 | 987654321         |
    E eu clico no botão "Salvar"
    Então eu devo ser redirecionado para a página inicial logado
    


