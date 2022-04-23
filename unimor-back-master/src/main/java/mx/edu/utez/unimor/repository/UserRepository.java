package mx.edu.utez.unimor.repository;

import mx.edu.utez.unimor.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM user", nativeQuery = true)
    Page<User> findAllPaginatedNoStatus(Pageable pageable);

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
}
