package tn.coconsultbackend.TrainingManagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.coconsultbackend.TrainingManagement.Entities.Quiz;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    Quiz findByName(String name);

    List<Quiz> findByCreatedAt(LocalDateTime createdAt);

    List<Quiz> findByUpdatedAt(LocalDateTime updatedAt);

    List<Quiz> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);

    List<Quiz> findByUpdatedAtBetween(LocalDateTime start, LocalDateTime end);

    @Query("SELECT q FROM Quiz q WHERE q.createdAt = :createdAt ORDER BY q.id ASC")
    List<Quiz> findQuizzesByCreatedAt(LocalDateTime createdAt);

    @Query("SELECT q FROM Quiz q WHERE q.updatedAt = :updatedAt ORDER BY q.id ASC")
    List<Quiz> findQuizzesByUpdatedAt(LocalDateTime updatedAt);

    @Query("SELECT q FROM Quiz q WHERE q.createdAt BETWEEN :start AND :end ORDER BY q.id ASC")
    List<Quiz> findQuizzesByCreatedAtBetween(LocalDateTime start, LocalDateTime end);

    @Query("SELECT q FROM Quiz q WHERE q.updatedAt BETWEEN :start AND :end ORDER BY q.id ASC")
    List<Quiz> findQuizzesByUpdatedAtBetween(LocalDateTime start, LocalDateTime end);
}
