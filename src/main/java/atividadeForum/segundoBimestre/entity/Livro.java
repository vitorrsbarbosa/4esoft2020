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
    private Boolean reserva = false;
    private String anoLancamento;
    private String generoLiterario;
    private int quantidadeDisponivel;

    public Livro() {}

    public Livro(String titulo, Integer numeroDePaginas, String autor) {
        this.titulo = titulo;
        this.numeroDePaginas = numeroDePaginas;
        this.autor = autor;
    }

	public Livro(String titulo, String autor, int numeroDePaginas, String anoLancamento, String generoLiterario, Boolean reservado,
			int quantidadeDisponivel) {
                this.titulo = titulo;
                this.autor = autor;
                this.numeroDePaginas = numeroDePaginas;
                this.anoLancamento = anoLancamento;
                this.generoLiterario = generoLiterario;
                this.reserva = reservado;
                this.quantidadeDisponivel = quantidadeDisponivel;
    }
}
