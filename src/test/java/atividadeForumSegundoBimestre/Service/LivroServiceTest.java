package atividadeForumSegundoBimestre.Service;

import atividadeForumSegundoBimestre.service.BibliotecaService;
import atividadeForumSegundoBimestre.entity.Biblioteca;
import atividadeForumSegundoBimestre.entity.Livro;
import atividadeForumSegundoBimestre.repository.BibliotecaRepository;
import atividadeForumSegundoBimestre.repository.LivroRepository;
import atividadeForumSegundoBimestre.service.LivroService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class LivroServiceTest {

    @Test
    void alterarTituloDoLivroTest() throws Throwable {
        ArgumentCaptor<Livro> livroArgumentCaptor = ArgumentCaptor.forClass(Livro.class);
        ArgumentCaptor<Biblioteca> bibliotecaArgumentCaptor = ArgumentCaptor.forClass(Biblioteca.class);
        LivroRepository livroRepository = Mockito.mock(LivroRepository.class);
        BibliotecaRepository bibliotecaRepository = Mockito.mock(BibliotecaRepository.class);
        LivroService livroService = new LivroService(livroRepository);
        BibliotecaService bibliotecaService = new BibliotecaService(bibliotecaRepository);

        when(livroService.findById("1"))
                .thenReturn(
                        new Livro(
                                "O Senhor dos Anéis: A Sociedade do Anel",
                                "J. R. R. Tolkien",
                                423,
                                "1954",
                                "Literatura fantástica"));

        bibliotecaService.reservarLivroPorTitulo("O Senhor dos Anéis: A Sociedade do Anel");

        assertThat(livroRepository.findById("1")).contains("A Sociedade do Anel");
    }
}
