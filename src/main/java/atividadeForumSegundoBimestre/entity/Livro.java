package atividadeForumSegundoBimestre.entity;

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
    private Boolean isReservado;
    private Integer numeroDeCopias;

    public Livro() {
    }
    public Livro(
            String id,
            String titulo,
            String autor,
            Integer numeroDePaginas,
            String dataDeLancamento,
            String genero,
            Boolean isReservado, Integer numeroDeCopias) {
        this.id = id;
        this.numeroDePaginas = numeroDePaginas;
        this.titulo = titulo;
        this.autor = autor;
        this.dataDeLancamento = dataDeLancamento;
        this.genero = genero;
        this.isReservado = isReservado;
        this.numeroDeCopias = numeroDeCopias;
    }

    public Livro(
            String titulo,
            String autor,
            Integer numeroDePaginas,
            String dataDeLancamento,
            String genero,
            Boolean isReservado, Integer numeroDeCopias) {
        this.numeroDePaginas = numeroDePaginas;
        this.titulo = titulo;
        this.autor = autor;
        this.dataDeLancamento = dataDeLancamento;
        this.genero = genero;
        this.isReservado = isReservado;
        this.numeroDeCopias = numeroDeCopias;
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

    public Boolean getReservado() {
        return isReservado;
    }

    public void setReservado(Boolean reservado) {
        isReservado = reservado;
    }

    public Integer getNumeroDeCopias() {
        return numeroDeCopias;
    }

    public void setNumeroDeCopias(Integer numeroDeCopias) {
        this.numeroDeCopias = numeroDeCopias;
    }
}
