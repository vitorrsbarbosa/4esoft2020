package atividadeForumSegundoBimestre.service;

import atividadeForumSegundoBimestre.entity.Livro;
import atividadeForumSegundoBimestre.exception.LivroInvalidoException;
import atividadeForumSegundoBimestre.exception.LivroNotFoundException;
import atividadeForumSegundoBimestre.exception.LivroRepetidoException;
import atividadeForumSegundoBimestre.repository.LivroRepository;
import lombok.var;
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
        return repository.findById(livroId).orElseThrow(LivroNotFoundException::new);
    }

    public Livro updateLivro(Livro livroAlterado) {
        validateLivro(livroAlterado);
        repository.save(livroAlterado);
        return livroAlterado;
    }

    public Livro deleteLivroById(String livroId) {
        var livroDeletado = repository.findById(livroId).orElseThrow(LivroNotFoundException::new);
        repository.deleteById(livroId);
        return livroDeletado;
    }

    public Livro createLivro(Livro livroACriar) {
        validateLivro(livroACriar);
        return repository.save(livroACriar);
    }

    private void validateLivro(Livro livroACriar) {
        if(repository.findById(livroACriar.getId()).isPresent()) {
            throw new LivroRepetidoException();
        }
        if (livroACriar.getTitulo().isEmpty()) {
            throw new LivroInvalidoException();
        }
        if(livroACriar.getAutor().isEmpty()) {
            throw new LivroInvalidoException();
        }
        if (livroACriar.getNumeroDePaginas().equals(0)) {
            throw new LivroInvalidoException();
        }
    }
}
