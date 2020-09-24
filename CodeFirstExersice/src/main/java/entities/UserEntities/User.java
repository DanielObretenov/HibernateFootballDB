package entities.UserEntities;

import entities.betEntities.Bet;
import com.sun.istack.NotNull;
import entities.BaseEntity;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String username;
    private String password;
    private String email;
    private String fullName;
    private BigDecimal balance;
    private Set<Bet> bets;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Column(name = "username",nullable = false)
    @NotNull
    @Length.List({
            @Length(min = 3, message = "The field must be at least 5 characters"),
            @Length(max = 50, message = "The field must be less than 50 characters")
    })
    @NotEmpty(message = "First Name is required.")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Length.List({
            @Length(min = 5, message = "The field must be at least 5 characters"),
            @Length(max = 50, message = "The field must be less than 50 characters")
    })
    @NotEmpty(message = "Password is required.")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Email(regexp = "[A-Za-z0-9._%-+]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}")
    @NotNull
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column
    @NotNull
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @OneToMany(mappedBy = "user")
    public Set<Bet> getBets() {
        return bets;
    }

    public void setBets(Set<Bet> bets) {
        this.bets = bets;
    }
}
