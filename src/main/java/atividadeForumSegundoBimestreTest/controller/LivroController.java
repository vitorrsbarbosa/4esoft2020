package atividadeForumSegundoBimestreTest.controller;

import atividadeForumSegundoBimestreTest.basedto.BaseResponseDto;
import atividadeForumSegundoBimestreTest.entity.Livro;
import atividadeForumSegundoBimestreTest.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/biblioteca")
public class LivroController {
    private LivroService service;

    @Autowired
    public LivroController(LivroService service) {
        this.service = service;
    }


    @GetMapping
    public BaseResponseDto<List<Livro>> getAllLivros() {
        return new BaseResponseDto<>(service.findAllLivros());
    }

    @GetMapping("livros/{livroId}")
    public BaseResponseDto<Livro> getOneById(@PathVariable("livroId") String livroId) throws Throwable {
        return new BaseResponseDto<>(service.findById(livroId));
    }

    @PutMapping("livros/{livroId}")
    public BaseResponseDto<Livro> putLivro(
            @PathVariable("livroId") String livroId,
            @RequestBody Livro livroAlterado) {
        if (livroId.equals(livroAlterado.getId())) {
            return new BaseResponseDto<>(service.updateLivro(livroAlterado));
        }
        return null;
    }
    @PostMapping("livros")
    public BaseResponseDto<Livro> postLivro(@RequestBody Livro livro) {
        service.createLivro(livro);
        return new BaseResponseDto<>();

    }

    @DeleteMapping("livros/{livroId}")
    public BaseResponseDto<Livro> deleteLivro(@PathVariable("livroId") String livroId) throws Throwable {
        if (service.findById(livroId).getId().equals(livroId)) {
            service.deleteLivroById(livroId);
            return new BaseResponseDto<>();
        }
        return null;
    }


}
