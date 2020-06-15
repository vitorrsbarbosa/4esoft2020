package atividadeForumSegundoBimestreTest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Livro {
    @Id
    private String id;
    private Integer numeroDePaginas;
    private String titulo;
    private String autor;
    private String dataDeLancamento;
    private String genero;

    public Livro() {
    }

    public Livro(String titulo, String autor, Integer numeroDePaginas, String dataDeLancamento, String genero) {
        this.numeroDePaginas = numeroDePaginas;
        this.titulo = titulo;
        this.autor = autor;
        this.dataDeLancamento = dataDeLancamento;
        this.genero = genero;
    }

    public String getDataDeLancamento() {
        return dataDeLancamento;
    }

    public void setDataDeLancamento(String dataDeLancamento) {
        this.dataDeLancamento = dataDeLancamento;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(Integer numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
