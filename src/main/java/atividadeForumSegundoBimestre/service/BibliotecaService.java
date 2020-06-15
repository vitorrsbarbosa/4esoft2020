package atividadeForumSegundoBimestre.service;


import atividadeForumSegundoBimestre.entity.Livro;
import atividadeForumSegundoBimestre.repository.BibliotecaRepository;

public class BibliotecaService {
    private BibliotecaRepository bibliotecaRepository;
    private LivroService livroService;
    public BibliotecaService(LivroService livroService, BibliotecaRepository bibliotecaRepository) {
        this.livroService = livroService;
        this.bibliotecaRepository = bibliotecaRepository;
    }

    public void reservarLivroPorTitulo(String titulo) {
        Livro livroEncontrado = livroService.findLivroByTitulo(titulo);
        livroService.reservarLivro(livroEncontrado);
    }
}
