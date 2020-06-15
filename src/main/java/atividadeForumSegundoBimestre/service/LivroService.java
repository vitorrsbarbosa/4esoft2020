package atividadeForumSegundoBimestre.service;

import atividadeForumSegundoBimestre.entity.Livro;
import atividadeForumSegundoBimestre.exception.LivroNotFoundException;
import atividadeForumSegundoBimestre.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    private LivroRepository repository;
    @Autowired
    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public List<Livro> findAllLivros() {
        return repository.findAll();
    }

    public Livro findById(String livroId) {
        return (Livro) repository
                .findById(livroId).orElseThrow(LivroNotFoundException::new);
    }

    public Livro updateLivro(Livro livroAlterado) {
        repository.save(livroAlterado);
        return livroAlterado;
    }

    public void deleteLivroById(String livroId) {
        repository.deleteById(livroId);
    }


    public void createLivro(Livro livroACriar) {
        if (repository.findById(livroACriar.getId()).isPresent()) {
            return;
        }
        repository.save(livroACriar);
    }

    public Livro findLivroByTitulo(String titulo) {
        return repository.findByTitulo(titulo);
    }

    public void reservarLivro(Livro livroEncontrado) {
        if(livroEncontrado.getReservado().equals(true))
            return;
        livroEncontrado.setReservado(true);
    }
}
