package atividadeForumSegundoBimestreTest.service;

import atividadeForumSegundoBimestreTest.entity.Livro;
import atividadeForumSegundoBimestreTest.exception.LivroNotFoundException;
import atividadeForumSegundoBimestreTest.repository.LivroRepository;
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

    public Livro findById(String livroId) throws Throwable {
        Livro livroEcontrado = (Livro) repository
                .findById(livroId).orElseThrow(LivroNotFoundException::new);
        return livroEcontrado;
    }

    public Livro updateLivro(Livro livroAlterado) {
        repository.save(livroAlterado);
        return livroAlterado;
    }

    public void deleteLivroById(String livroId) {
        repository.deleteById(livroId);
    }


    public void createLivro(Livro livroACriar) {
        if (repository.findById(livroACriar.getId()) == null) {
            repository.save(livroACriar);
        }
        return;
    }
}
