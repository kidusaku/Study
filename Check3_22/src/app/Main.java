package app;

import constants.Constants;
import model.Book;
import model.Item;

public class Main {
    private String firstName = "川端";
    private String lastName = "大輔";  
  
    private void printName(String firstName,String LastName){
        System.out.println(firstName + LastName);
    };
    public static void main(String[] args) {
    Main main = new Main();
    main.printName(main.firstName, main.lastName);
    
    Item item = new Item(Constants.ITEM_NAME, Constants.ITEM_PRICE);
    item.showInfo();
    
    Book book = new Book(    Constants.BOOK_NAME,Constants.BOOK_PRICE,Constants.BOOK_AUTHOR);
    book.showInfo();
    }
}