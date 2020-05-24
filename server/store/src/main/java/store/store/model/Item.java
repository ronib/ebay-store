package store.store.model;

public class Item {
    private String itemId;
    private String title;
    private Image image;
    private Price price;

    public Item() {
    }

    public Item(String itemId, String title){
        this.itemId = itemId;
        this.title = title;
    }

    public String getItemId(){
        return itemId;
    }

    public String getTitle(){
        return title;
    }

    public String getPrice(){
        System.out.println(price.toString());
        return price.value + " " + price.currency;
    }

    public String getImageUrl(){
        if (image != null) return image.imageUrl;
        return "";
    }
}

class Image {
    String imageUrl;
}

class Price {
    String value;
    String currency;
}