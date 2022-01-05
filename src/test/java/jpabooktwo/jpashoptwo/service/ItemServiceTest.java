package jpabooktwo.jpashoptwo.service;

import jpabooktwo.jpashoptwo.domain.item.Book;
import jpabooktwo.jpashoptwo.domain.item.Item;
import jpabooktwo.jpashoptwo.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ItemServiceTest {
    
    @Autowired ItemService itemService;
    @Autowired
    ItemRepository itemRepository;
    
    @Test
    public void 아이템_등록() throws Exception
    {
        //given
        Book book = new Book();
        book.setAuthor("kimsungsu");

        //when
        Long itemSavedId = itemService.saveItem(book);

        //then
        assertEquals(book,itemRepository.findOne(itemSavedId));

    }
    


}