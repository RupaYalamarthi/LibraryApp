package perscholascs.mylibrary.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "checkout")
public class Checkout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "checkout_date")
    private Date checkoutDate;

    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "status")
    private String status;

    @Override
    public String toString() {
        return "Checkout{" +
                "id=" + id +
                ", user=" + user +
                ", checkoutDate=" + checkoutDate +
                ", dueDate=" + dueDate +
                ", status='" + status + '\'' +
                '}';
    }
}
