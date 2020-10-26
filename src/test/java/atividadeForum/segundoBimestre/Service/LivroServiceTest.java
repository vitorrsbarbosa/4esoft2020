package atividadeForum.segundoBimestre.Service;

import atividadeForum.segundoBimestre.entity.Biblioteca;
import atividadeForum.segundoBimestre.entity.Livro;
import atividadeForum.segundoBimestre.service.LivroService;
import atividadeForum.segundoBimestre.service.BibliotecaService;
import atividadeForum.segundoBimestre.repository.BibliotecaRepository;
import atividadeForum.segundoBimestre.repository.LivroRepository;
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
                "O Senhor dos Anéis: A Sociedade do Anel",
                "J. R. R. Tolkien",
                423,
                "1954",
                "Literatura Fantástica",
                false,
                20);
//        When
        when(bibliotecaService.findLivroByTitulo("O Senhor dos Anéis: A Sociedade do Anel"))
                .thenReturn(lordOfTheRings);
        when(bibliotecaService
                .reservarLivroPorTitulo("O Senhor dos Anéis: A Sociedade do Anel")).thenReturn(true);
//        Then
        assertThat(livroService.findById("1")
                .getTitulo())
                .contains("A Sociedade do Anel");
        assertThat(bibliotecaService.findLivroByTitulo("O Senhor dos Anéis: A Sociedade do Anel")
                .getReserva())
                .isTrue();
    }
}
