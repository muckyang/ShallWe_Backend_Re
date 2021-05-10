package ShallWe.Refactoring.repository.tag;

import ShallWe.Refactoring.domain.order.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TagRepository extends JpaRepository<Tag, Long> {
    List<Tag> findByName(String name);
}
