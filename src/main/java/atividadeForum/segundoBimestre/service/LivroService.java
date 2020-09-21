package atividadeForum.segundoBimestre.service;

import atividadeForum.segundoBimestre.entity.Livro;
import atividadeForum.segundoBimestre.exception.LivroInvalidoException;
import atividadeForum.segundoBimestre.exception.LivroNotFoundException;
import atividadeForum.segundoBimestre.exception.LivroRepetidoException;
import atividadeForum.segundoBimestre.repository.LivroRepository;
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
        return this.repository.findAll();
    }

    public Livro findById(String livroId) {
        return this.repository.findById(livroId).orElseThrow(LivroNotFoundException::new);
    }

    public Livro updateLivro(Livro livroAlterado) {
        validateLivro(livroAlterado);
        this.repository.save(livroAlterado);
        return livroAlterado;
    }

    public Livro deleteLivroById(String livroId) {
        var livroDeletado = this.repository.findById(livroId).orElseThrow(LivroNotFoundException::new);
        this.repository.deleteById(livroId);
        return livroDeletado;
    }

    public Livro createLivro(Livro livroACriar) {
        validateLivro(livroACriar);
        return this.repository.save(livroACriar);
    }

    private void validateLivro(Livro livroACriar) {
        if(this.repository.findById(livroACriar.getId()).isPresent()) {
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
