package br.edu.utfpr.md.webapp.dao;

import br.edu.utfpr.md.model.Category;
import com.mongodb.MongoClient;
import javax.inject.Inject;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

public class CategoryDAO extends BasicDAO<Category, ObjectId>{
    @Inject
    public CategoryDAO(MongoClient mongoClient) {
        super(Category.class, mongoClient, new Morphia(), MongoClientProvider.DATABASE);
    }
    
    public Category getByName(String name) {
        return this.getDatastore().find(Category.class).field("name").equal(name).get();
    }
    
    public void updateCategory(Category category){
        //this.getDatastore().up
          //this.createQuery()
        //this.up
    }
}
