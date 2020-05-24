package store.store.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Summaries {
    public String href;
    public Item[] itemSummaries;
    public ArrayList<Item> getData(){
        return new ArrayList<Item>(Arrays.asList(itemSummaries));
    }

}


 
 