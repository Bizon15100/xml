package Wojcicki;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class Account {


    private String iban;
    private String currency;
    private String name;
    private double balance;
    private String closingDate;


}

