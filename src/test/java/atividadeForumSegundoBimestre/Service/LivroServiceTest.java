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
import static org.mockito.Mockito.*;

public class LivroServiceTest {

    @Test
    void reservarLivroTest() {
        ArgumentCaptor.forClass(Livro.class);
        ArgumentCaptor.forClass(Biblioteca.class);
//        Given
        LivroRepository livroRepository = Mockito.mock(LivroRepository.class);
        BibliotecaRepository bibliotecaRepository = Mockito.mock(BibliotecaRepository.class);
        LivroService livroService = new LivroService(livroRepository);
        BibliotecaService bibliotecaService = new BibliotecaService(livroService, bibliotecaRepository);
        Livro lordOfTheRings = new Livro(
                "1",
                "O Senhor dos Anéis: A Sociedade do Anel",
                "J. R. R. Tolkien",
                423,
                "1954",
                "Literatura Fantástica",
                false,
                20);
//        When
        when(livroService.findById("12"))
                .thenReturn(lordOfTheRings);
        bibliotecaService
                .reservarLivroPorTitulo("O Senhor dos Anéis: A Sociedade do Anel");
//        Then
        assertThat(livroService.findById("1")
                .getTitulo())
                .contains("A Sociedade do Anel");
        assertThat(livroService.findLivroByTitulo("O Senhor dos Anéis: A Sociedade do Anel")
                .getReservado())
                .isTrue();
    }
}
