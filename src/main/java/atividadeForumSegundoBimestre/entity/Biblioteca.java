package atividadeForumSegundoBimestre.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public abstract class Biblioteca {
    @Id
    Long id;

    public Biblioteca() {

    }
}
