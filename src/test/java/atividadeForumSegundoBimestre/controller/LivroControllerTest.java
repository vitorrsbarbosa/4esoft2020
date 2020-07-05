package atividadeForumSegundoBimestre.controller;

import atividadeForumSegundoBimestre.entity.Livro;
import atividadeForumSegundoBimestre.exception.LivroInvalidoException;
import atividadeForumSegundoBimestre.exception.LivroNotFoundException;
import atividadeForumSegundoBimestre.service.LivroService;
import lombok.var;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultMatcher;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = LivroController.class)
@AutoConfigureMockMvc
public class LivroControllerTest {

    @Autowired
    private final LivroService service;
    @Autowired
    private final MockMvc mockMvc;
    @Autowired
    private final ObjectMapper objectMapper;

    @Autowired
    public LivroControllerTest(LivroService service, MockMvc mockMvc, ObjectMapper objectMapper) {
        this.service = service;
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
    }

    @Test
    public void test_findAll() throws Exception {
//        Given
        List<Livro> livros = new ArrayList<Livro>(){{
            add(new Livro("A sociedade do anel", 423, "JRRT"));
            add(new Livro("As duas torres", 30, "JRRT"));
            add(new Livro("O retorno do rei", 90, "JRRT"));
        }};
//        When
        when(service.findAllLivros()).thenReturn(livros);
//        Then
        mockMvc.perform(get("/api/livros"))
                .andExpect((ResultMatcher) jsonPath("$").isArray())
                .andExpect((ResultMatcher) jsonPath("$", hasSize(3)))
                .andExpect((ResultMatcher) jsonPath("$.[0].id").isNotEmpty())
                .andExpect((ResultMatcher) jsonPath("$.[1].id").isNotEmpty())
                .andExpect((ResultMatcher) jsonPath("$.[2].id").isNotEmpty())
                .andExpect((ResultMatcher) jsonPath("$.[0].title").value("Teste1"))
                .andExpect((ResultMatcher) jsonPath("$.[1].title").value("Teste2"))
                .andExpect((ResultMatcher) jsonPath("$.[2].title").value("Teste3"))
                .andExpect((ResultMatcher) jsonPath("$.[0].author").value("Autor1"))
                .andExpect((ResultMatcher) jsonPath("$.[1].author").value("Autor2"))
                .andExpect((ResultMatcher) jsonPath("$.[2].author").value("Autor1"))
                .andExpect(status().isOk());
    }
    @Test
    public void teste_findById_dadoExistente() throws Exception {
//        Given
        Livro existente = new Livro("Teste1", 10, "Autor1");
//        When
        when(service.findById(anyString())).thenReturn(existente);
//        Then
        mockMvc.perform(get("/api/livros/afe5fddd-f774-4b9d-8914-e3d795c71895"))
                .andExpect((ResultMatcher) jsonPath("$.title").value("Teste1"))
                .andExpect((ResultMatcher) jsonPath("$.pageNumber").value(10))
                .andExpect((ResultMatcher) jsonPath("$.author").value("Autor1"))
                .andExpect(status().isOk());
    }

    @Test
    public void teste_get_vazio() throws Exception{
//        When
        when(service.findById(anyString())).thenThrow(LivroNotFoundException.class);
//        Then
        mockMvc.perform(get("/api/livros/123123"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void teste_post_dadosValidos() throws Exception{
//        Given
        UUID uuid = UUID.randomUUID();
        String number = String.valueOf(uuid);
        Livro novo = new Livro("Teste1", 10, "Autor1");
        var object = objectMapper.writeValueAsString(novo);
//        When
        when(service.createLivro(novo)).thenReturn(novo);
//        Then
        mockMvc.perform(post("/api/livros")
                .contentType(MediaType.APPLICATION_JSON)
                .content(object))
                .andExpect(status().isCreated())
                .andExpect((ResultMatcher) jsonPath("$").value(number));
    }

    @Test
    public void teste_post_dadosInvalidos() throws Exception{
//        Given
        Livro novo = new Livro("Teste1", 0, "Autor1");
        var object = objectMapper.writeValueAsString(novo);
//        When
        when(service.createLivro(any())).thenThrow(LivroInvalidoException.class);
//        Then
        mockMvc.perform(post("/api/livros")
                .contentType(MediaType.APPLICATION_JSON)
                .content(object))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void teste_put_dadosInvalidos() throws Exception{
//        Given
        UUID uuid = UUID.randomUUID();
        String livroId = String.valueOf(uuid);
        Livro novo = new Livro("Teste1", 0, "Autor1");
        novo.setId(livroId);
        var object = objectMapper.writeValueAsString(novo);
//        When
        when(service.updateLivro(any())).thenThrow(LivroInvalidoException.class);
//        Then
        mockMvc.perform(put("/api/livros/" + livroId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(object))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void teste_put_idsDiferentes() throws Exception{
//        Given
        UUID uuid1 = UUID.randomUUID();
        UUID uuid2 = UUID.randomUUID();
        String id1 = String.valueOf(uuid1);
        String id2 = String.valueOf(uuid2);
        Livro novo = new Livro("Abublé", 0, "Taz");
        novo.setId(id1);
        var object = objectMapper.writeValueAsString(novo);
//        When
        when(service.updateLivro(any())).thenThrow(LivroInvalidoException.class);
//        Then
        mockMvc.perform(put("/api/livros/" + id2)
                .contentType(MediaType.APPLICATION_JSON)
                .content(object))
                .andExpect(status().isPreconditionFailed());
    }

    @Test
    public void teste_put_dadosValidos() throws Exception{
//        Given
        UUID uuid = UUID.randomUUID();
        String id = String.valueOf(uuid);
        Livro novo = new Livro("Teste1", 10, "Autor1");
        novo.setId(id);
        var object = objectMapper.writeValueAsString(novo);
//        When
        when(service.updateLivro(any())).thenReturn(novo);
//        Then
        mockMvc.perform(put("/api/livros/" + id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(object))
                .andExpect(status().isAccepted())
                .andExpect((ResultMatcher) jsonPath("$").value(id));
    }

    @Test
    public void teste_delete_objetoValido() throws Exception{
//        Given
        UUID uuid = UUID.randomUUID();
        String id = String.valueOf(uuid);
//        Then
        mockMvc.perform(delete("/api/livros/" + id))
                .andExpect(status().isAccepted());
    }

    @Test
    public void teste_delete_objetoInvalido() throws Exception{
//        Given
        UUID uuid = UUID.randomUUID();
        String id = String.valueOf(uuid);
//        When
        when(service.deleteLivroById(any())).thenThrow(LivroNotFoundException.class);
//        Then
        mockMvc.perform(delete("/api/livros/" + id))
                .andExpect(status().isNotFound());
    }

}