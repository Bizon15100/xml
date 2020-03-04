import lombok.*;

import java.time.LocalDate;

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

