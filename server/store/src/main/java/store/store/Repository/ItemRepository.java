package store.store.Repository;


import org.springframework.stereotype.Repository;
import store.store.model.Item;

@Repository
public interface ItemRepository {
    Item findOne(String id);
    Object search(String str);

}
