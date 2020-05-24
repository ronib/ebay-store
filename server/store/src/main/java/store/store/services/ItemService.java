package store.store.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import store.store.model.Item;

@Service
public interface ItemService {

    public ResponseEntity<Item> getSingleItemResponse(String id);
    public ResponseEntity<Object> searchItemsResponse(String str);

}