Aplica��o monolitica com: 
	- vRaptor
	- Tomcat
	- bootstrap
	- JSTL
	
	TO DO List:
	
	Aplica��o monol�tica

		Objetivo: Criar a aplica��o Web monol�tica em tr�s camadas (MVC) utilizando o framework VRaptor para controlar a navega��o e a estrutura da aplica��o.

		Tema: Portf�lio pessoal. Deseja-se criar um sistema que permita organizar documentos e ofere�a as seguintes funcionalidades:

			Cadastrar a atualizar documentos;																CADASTRO REALIZADO CRIAR METODOS DE UPDATE;
			Categorizar o documento (a n�vel de sistema);													CATEGORIAS CRIADAS BASTA ALTERAR O LAYOUT PARA REALIZAR CONSULTAS COM BASE NAS CATEGORIAS
			Definir tags para o documento (a n�vel de usu�rio).												TAGS CRIADAS -> CRIAR FUN��O DE BUSCA DE DOCUMENTOS BASEADO NAS TAGS
			
		Seguran�a:
			Permitir a autentica��o;																		CONCLUIDO
			Criar n�veis de acesso dentro da aplica��o, como (Administrador e Usu�rio);						CONCLUIDO
			
		Model:
			Implementar as classes do modelo da aplica��o:													CONCLUIDO
			Aplicar conceitos da orienta��o a objetos (atributos privados, m�todos getters e setters);		CONCLUIDO
			Fazer valida��es dos atributos com anota��es do Bean Validator;									CONCLUIDO
			
		Controller:
			Utilizar o framework VRaptor para controlar a aplica��o;										CONCLUIDO
			Configurar os controladores para atuar com URLs em estilo REST;									CONCLUIDO
			Configurar o m�todo de acesso HTTP nos m�todos do controlador (@Get, @Post...) 					CONCLUIDO
			Utilizar validadores ao gravar dados de formul�rios;											CONCLUIDO
			
		View:
			JSP, JSTL.																						CONCLUIDO
			
		Navega��o:
			Utilizar URLs de navega��o amig�veis;															UTILIZANDO PARA FINALIZAR NECESSARIO FERIFICAR COMO FAZER UPDATE E DELETE
			
		Exemplos;
			/carro (GET) -> Abre a lista de carros cadastrados;												CONCLUIDO
			/carro/novo (GET) -> Abre o formul�rio de cadastro dos carros;									CONCLUIDO
			/carro/2 (GET) -> Abre o formul�rio de edi��o do carro com ID 2;								VERIFICAR COMO REALIZAR
			/carro/save (POST) -> Salva o carro.															CONCLUIDO