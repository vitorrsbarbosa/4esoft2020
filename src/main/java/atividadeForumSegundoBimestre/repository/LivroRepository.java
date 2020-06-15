package atividadeForumSegundoBimestre.repository;

import atividadeForumSegundoBimestre.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, String> {

    Livro findByTitulo(String titulo);
}
