package com.wandou.demo;

import com.wandou.model.dto.Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liming
 */
public class ListDemo {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("g钢铁", "b", 1L));
        books.add(new Book("你好李", "a", 12L));
        books.add(new Book("s水浒传", "b", 15L));
        System.out.println("books = " + books);
        books = books.stream()
                .sorted(Comparator.comparing(Book::getType).thenComparing(Book::getName))
                .collect(Collectors.toList());
        System.out.println("books = " + books);

    }

}
