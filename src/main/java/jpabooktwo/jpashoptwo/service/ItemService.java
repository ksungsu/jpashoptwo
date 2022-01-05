package jpabooktwo.jpashoptwo.service;

import jpabooktwo.jpashoptwo.domain.item.Item;
import jpabooktwo.jpashoptwo.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public Long saveItem(Item item){
        itemRepository.save(item);
        return item.getId();
    }

    public Item findOne(Long itemId){
        return itemRepository.findOne(itemId);
    }

    public List<Item> findItems(){
        return itemRepository.findAll();

    }

}
