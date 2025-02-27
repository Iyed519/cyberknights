package tn.coconsultbackend.HumanRessourcesProcess.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.coconsultbackend.Model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
