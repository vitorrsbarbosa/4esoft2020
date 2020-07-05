package atividadeForumSegundoBimestre.controller;

import atividadeForumSegundoBimestre.entity.Livro;
import atividadeForumSegundoBimestre.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/livros")
public class LivroController {
    private LivroService service;

    @Autowired
    public LivroController(LivroService service) {
        this.service = service;
    }

    @GetMapping
    public List<Livro> getAllLivros() {
        return service.findAllLivros();
    }

    @GetMapping("{livroId}")
    @ResponseStatus(HttpStatus.OK)
    public Livro getOneById(@PathVariable("livroId") String livroId) {
        return service.findById(livroId);
    }

    @PutMapping("livros/{livroId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Livro putLivro(
            @PathVariable("livroId") String livroId,
            @RequestBody Livro livroAlterado) {
        return service.updateLivro(livroAlterado);
    }

    @PostMapping("livros")
    @ResponseStatus(HttpStatus.CREATED)
    public Livro postLivro(@RequestBody Livro livro) {
        return service.createLivro(livro);
    }

    @DeleteMapping("livros/{livroId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Livro deleteLivro(@PathVariable("livroId") String livroId) throws Throwable {
        return service.deleteLivroById(livroId);
    }
}
