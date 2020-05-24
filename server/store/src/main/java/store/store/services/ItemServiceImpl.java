package store.store.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import store.store.Repository.ItemRepository;
import store.store.exceptions.ItemNotFoundException;
import store.store.model.Item;

@Service
public class ItemServiceImpl implements ItemService {
    private ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        Assert.notNull(itemRepository, "ItemRepository must not be null!");
        this.itemRepository = itemRepository;
    }

    @Override
    public ResponseEntity<Object> searchItemsResponse(String str) {
        Object allItems = itemRepository.search(str);

        return new ResponseEntity<Object>(allItems, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Item> getSingleItemResponse(String id) {
        Item getItem = findItemIfExists(id);
        return new ResponseEntity<Item>(getItem, HttpStatus.OK);
    }

    private Item findItemIfExists(String id) {
        Item existingItem = itemRepository.findOne(id);

        if (null != existingItem) {
            return existingItem;
        } else {
            throw new ItemNotFoundException();
        }
    }
}