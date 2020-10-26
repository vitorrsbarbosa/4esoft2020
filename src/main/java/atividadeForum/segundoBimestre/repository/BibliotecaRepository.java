package atividadeForum.segundoBimestre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import atividadeForum.segundoBimestre.entity.Livro;

@Repository
public interface BibliotecaRepository extends JpaRepository<Livro, String> {
}
