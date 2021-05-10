package ShallWe.Refactoring.domain.order.service;

import ShallWe.Refactoring.domain.order.domain.Order;
import ShallWe.Refactoring.domain.order.domain.Tag;
import ShallWe.Refactoring.repository.tag.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    public void createTags(Order order, List<String> tags){
        for(String name : tags) {
            Tag tag = new Tag(name);
            tag.setOrder(order);
            tagRepository.save(tag);
        }
    }
}
