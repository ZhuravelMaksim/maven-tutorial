package com.intexsoft;

import java.util.function.Consumer;

/**
 * Hello world!
 */
public class TestModel {
    public static void print(String value) {
        Consumer<String> consumer = System.out::println;
        consumer.accept(value);
    }
}