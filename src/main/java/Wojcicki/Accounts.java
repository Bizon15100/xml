package Wojcicki;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@XmlRootElement
public class Accounts {

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Account> account;

    public Accounts() {
        account = new ArrayList<>();
    }

    public Accounts(List<Account> account) {
        this.account = account;
    }
}
