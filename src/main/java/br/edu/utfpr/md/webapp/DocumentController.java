package br.edu.utfpr.md.webapp;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.utfpr.md.model.Category;
import br.edu.utfpr.md.model.Document;
import br.edu.utfpr.md.model.Keyword;
import br.edu.utfpr.md.webapp.auth.LoggedUser;
import br.edu.utfpr.md.webapp.dao.CategoryDAO;
import br.edu.utfpr.md.webapp.dao.DocumentDAO;
import br.edu.utfpr.md.webapp.dao.KeywordDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

@Controller
@Path("/document")
public class DocumentController {

    @Inject
    private Result result;
    @Inject
    private Validator validator;
    @Inject
    private DocumentDAO documentDAO;
    @Inject
    private KeywordDAO keywordDAO;
    @Inject
    private CategoryDAO categoryDAO;
    @Inject
    private LoggedUser loggedUser;

    @Path("/new")
    @Get
    public void form() {
        result.include("categorias", categoryDAO.find().asList());
        result.include("keywords", keywordDAO.find().asList());
    }

    @Path(value = {"", "/"})
    @Get
    public List<Document> list() {
        result.include("mensagem", "esta é uma mensagem");
        result.include("data", new Date());
        return documentDAO.find().asList();
    }

    @Post
    public void save(String description, String fileName, String date, String lastUpdate, String selectedCategoryName, String[] keywords) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        List<Keyword> keywordList = new ArrayList<>();
        Category categoriaSelecionada = this.categoryDAO.getByName(selectedCategoryName);
        
        for (String keyword : keywords) {
            Keyword key = this.keywordDAO.getByName(keyword);
            if (key != null) {
                keywordList.add(key);
            }
        }
        Document document = new Document(description, sdf.parse(date), sdf.parse(lastUpdate), fileName, loggedUser.getUsuario(), categoriaSelecionada, keywordList);

        validator.onErrorForwardTo(this).form();
        try {
            this.documentDAO.save(document);
        } catch (Exception e) {
            e.printStackTrace();
            validator.add(new SimpleMessage("dao", "Falha ao Inserir Documento!"));
        }
        result.redirectTo(this).list();
    }
    // ADICIONAR PATH /UPDATE/ ID
    @Path("/update/{id}")
    public void update(String fileName){
        System.out.println("btn editar clicado " + fileName);
        this.documentDAO.getByName(fileName);
        result.include("documento", fileName);
        result.forwardTo(this).form();
        // ENVIAR OBJETO COM O ID ENVIADO PARA A PAGINA DE UPDATE
        // result.include("objeto", OBJ);
    }
    // ADICIONAR PATH /DELETE/ ID
    public void delete(String id){
        // DELETAR O OBJETO COM ID ENVIADO
        // REDIRECIONAR PARA PAGINA DE LISTAGEM 
    }
}
