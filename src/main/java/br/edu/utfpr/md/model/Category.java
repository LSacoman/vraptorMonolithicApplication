package br.edu.utfpr.md.model;

import javax.validation.constraints.NotNull;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class Category {

    @Id
    private ObjectId id;
    @NotNull
    private String name;

    public Category() {
    }

    public Category(ObjectId id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

}
