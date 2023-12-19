package ma.sdia.customerfrontthymeleafapplication.model;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder @ToString
public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;
}
