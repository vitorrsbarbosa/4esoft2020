package atividadeForum.segundoBimestre.repository;

import atividadeForum.segundoBimestre.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, String> {
}
