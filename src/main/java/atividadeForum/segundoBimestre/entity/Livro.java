package atividadeForum.segundoBimestre.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Livro {
    @Id
    private String id;
    private Integer numeroDePaginas;
    private String titulo;
    private String autor;

    public Livro() {}

    public Livro(String titulo, Integer numeroDePaginas, String autor) {
        this.titulo = titulo;
        this.numeroDePaginas = numeroDePaginas;
        this.autor = autor;
    }
}
