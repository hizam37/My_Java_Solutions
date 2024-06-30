import lombok.*;

import java.util.concurrent.atomic.AtomicLong;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Account {

    private long money;
    private String accNumber;
    private boolean isBlocked;


    public Account(long money, String accNumber) {
        this.money = money;
        this.accNumber = accNumber;
        this.isBlocked = false;
    }
}




