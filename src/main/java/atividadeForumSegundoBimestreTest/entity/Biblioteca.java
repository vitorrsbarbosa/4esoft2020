package atividadeForumSegundoBimestreTest.entity;

import atividadeForumSegundoBimestreTest.access.Livro;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public abstract class Biblioteca implements Livro {
    @Id
    Long id;


    public Biblioteca() {

    }
}
