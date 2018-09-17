package br.edu.utfpr.md.webapp;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.utfpr.md.model.Category;
import br.edu.utfpr.md.webapp.dao.CategoryDAO;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
@Path("/category")
public class CategoryController {

    @Inject
    private Result result;
    @Inject
    private Validator validator;
    @Inject
    private CategoryDAO categoryDAO;

    @Path("/new")
    @Get
    public void form() {
    }

    @Path(value = {"", "/"})
    @Get
    public List<Category> list() {
        result.include("mensagem", "esta é uma mensagem");
        result.include("data", new Date());
        return categoryDAO.find().asList();
    }

    @Post
    public void save(@Valid @NotNull Category category) {
        validator.onErrorForwardTo(this).form();
        try {
            this.categoryDAO.save(category);
        } catch (Exception e) {
            e.printStackTrace();
            validator.add(new SimpleMessage("dao", "Falha ao Inserir Categoria!"));
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
