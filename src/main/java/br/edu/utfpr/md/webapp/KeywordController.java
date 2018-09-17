package br.edu.utfpr.md.webapp;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.utfpr.md.model.Keyword;
import br.edu.utfpr.md.webapp.dao.KeywordDAO;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
@Path("/keyword")
public class KeywordController {

    @Inject
    private Result result;
    @Inject
    private Validator validator;
    @Inject
    private KeywordDAO keywordDAO;

    @Path("/new")
    @Get
    public void form() {
    }

    @Path(value = {"", "/"})
    @Get
    public List<Keyword> list() {
        result.include("mensagem", "esta é uma mensagem");
        result.include("data", new Date());
        return keywordDAO.find().asList();
    }

    @Post
    public void save(@Valid @NotNull Keyword keyword) {
        validator.onErrorForwardTo(this).form();
        try {
            this.keywordDAO.save(keyword);
        } catch (Exception e) {
            e.printStackTrace();
            validator.add(new SimpleMessage("dao", "Falha ao Inserir keyword!"));
        }
        result.redirectTo(this).list();
    }

    // ADICIONAR PATH /UPDATE/ ID
    public void update(String id) {
        System.out.println("btn editar clicado " + id);
        // ENVIAR OBJETO COM O ID ENVIADO PARA A PAGINA DE UPDATE
        // result.include("objeto", OBJ);
    }

    // ADICIONAR PATH /DELETE/ ID
    public void delete(String id) {
        // DELETAR O OBJETO COM ID ENVIADO
        // REDIRECIONAR PARA PAGINA DE LISTAGEM 
    }
}
