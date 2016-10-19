package seo.dale.commerce.core;

import seo.dale.commerce.member.Member;
import seo.dale.commerce.product.Product;

public class ModelFactory {

    public static Member newMember(String username, String password, String email) {
        Member member = new Member();
        member.setUsername(username);
        member.setPassword(password);
        member.setEmail(email);
        return member;
    }

    public static Product newProduct(String name, String description, Double price, Integer stock) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setStock(stock);
        return product;
    }

}
