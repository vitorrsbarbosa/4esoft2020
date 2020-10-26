package atividadeForum.segundoBimestre.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import atividadeForum.segundoBimestre.repository.BibliotecaRepository;
import atividadeForum.segundoBimestre.repository.LivroRepository;
import atividadeForum.segundoBimestre.entity.Livro;
import atividadeForum.segundoBimestre.exception.LivroReservadoException;

@Service
public class BibliotecaService {
    private BibliotecaRepository bibliotecaRepository;
    private LivroRepository livroRepository;

    @Autowired
    public BibliotecaService(BibliotecaRepository bibliotecaRepository, LivroRepository livroRepository) {
        this.bibliotecaRepository = bibliotecaRepository;
        this.livroRepository = livroRepository;
    }

	public BibliotecaService(LivroService livroService, BibliotecaRepository bibliotecaRepository) {

	}

	public boolean reservarLivroPorTitulo(String titulo) {
        Livro livroAReservar = this.livroRepository.findByTitulo(titulo);
        if (livroAReservar.getReserva() == true) {
            throw new LivroReservadoException();
        }
        return livroAReservar.getReserva();
    }

    public Livro findLivroByTitulo(String titulo) {
        return this.livroRepository.findByTitulo(titulo);
	}

}
