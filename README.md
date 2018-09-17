Aplicação monolitica com: 
	- vRaptor
	- Tomcat
	- bootstrap
	- JSTL
	
	TO DO List:
	
	Aplicação monolítica

		Objetivo: Criar a aplicação Web monolítica em três camadas (MVC) utilizando o framework VRaptor para controlar a navegação e a estrutura da aplicação.

		Tema: Portfólio pessoal. Deseja-se criar um sistema que permita organizar documentos e ofereça as seguintes funcionalidades:

			Cadastrar a atualizar documentos;																CADASTRO REALIZADO CRIAR METODOS DE UPDATE;
			Categorizar o documento (a nível de sistema);													CATEGORIAS CRIADAS BASTA ALTERAR O LAYOUT PARA REALIZAR CONSULTAS COM BASE NAS CATEGORIAS
			Definir tags para o documento (a nível de usuário).												TAGS CRIADAS -> CRIAR FUNÇÃO DE BUSCA DE DOCUMENTOS BASEADO NAS TAGS
			
		Segurança:
			Permitir a autenticação;																		CONCLUIDO
			Criar níveis de acesso dentro da aplicação, como (Administrador e Usuário);						CONCLUIDO
			
		Model:
			Implementar as classes do modelo da aplicação:													CONCLUIDO
			Aplicar conceitos da orientação a objetos (atributos privados, métodos getters e setters);		CONCLUIDO
			Fazer validações dos atributos com anotações do Bean Validator;									CONCLUIDO
			
		Controller:
			Utilizar o framework VRaptor para controlar a aplicação;										CONCLUIDO
			Configurar os controladores para atuar com URLs em estilo REST;									CONCLUIDO
			Configurar o método de acesso HTTP nos métodos do controlador (@Get, @Post...) 					CONCLUIDO
			Utilizar validadores ao gravar dados de formulários;											CONCLUIDO
			
		View:
			JSP, JSTL.																						CONCLUIDO
			
		Navegação:
			Utilizar URLs de navegação amigáveis;															UTILIZANDO PARA FINALIZAR NECESSARIO FERIFICAR COMO FAZER UPDATE E DELETE
			
		Exemplos;
			/carro (GET) -> Abre a lista de carros cadastrados;												CONCLUIDO
			/carro/novo (GET) -> Abre o formulário de cadastro dos carros;									CONCLUIDO
			/carro/2 (GET) -> Abre o formulário de edição do carro com ID 2;								VERIFICAR COMO REALIZAR
			/carro/save (POST) -> Salva o carro.															CONCLUIDO