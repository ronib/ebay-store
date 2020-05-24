package store.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import store.store.model.Item;
import store.store.services.ItemService;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class ItemController {
    @Autowired
    private ItemService itemService;

    // List One Item
    @RequestMapping(value = "items/{id}", method = RequestMethod.GET)
    public ResponseEntity<Item> getSingleItem(@PathVariable String id) throws Throwable {
        return itemService.getSingleItemResponse(id);
    }

    // Search in items
    @RequestMapping(value = "items/search/{str}", method = RequestMethod.GET)
    public ResponseEntity<Object> searchItems(@PathVariable String str) throws Throwable {
        return itemService.searchItemsResponse(str);
    }
}