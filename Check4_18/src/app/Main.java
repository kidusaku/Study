package app;

import constants.Constants;
import model.Book;
import model.Item;

public class Main {
    private String firstName = "川端";
    private String lastName = "大輔";
    
    private void printName(String firstName,String lastName) {
        System.out.println("氏名：" + firstName + lastName);
    }
    
    public static void main(String[] args) {
        Item item = new Item(Constants.ITEM_NAME,Constants.ITEM_PRICE);
        Book book = new Book(Constants.BOOK_NAME,Constants.BOOK_PRICE,Constants.BOOK_AUTHOR);
                
        item.showInfo();
        book.showInfo();
        
        System.out.println("割引後の書籍価格：" + (int)(book.getPricePublic()  - 200)+ "円");
    }
}
