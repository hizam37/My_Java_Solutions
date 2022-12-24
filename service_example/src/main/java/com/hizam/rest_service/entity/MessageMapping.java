package com.hizam.rest_service.entity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;


@Entity
@XmlRootElement
@Getter
@Setter
@Table(name="massengermap")
public class MessageMapping implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name = "to_id")
    private User to_id;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name = "from_id")
    private User from_id;

    @ManyToOne(targetEntity = Message.class, fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name = "message_id")
    private Message message_id;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageMapping that = (MessageMapping) o;
        return id == that.id && Objects.equals(to_id, that.to_id) && Objects.equals(from_id, that.from_id) && Objects.equals(message_id, that.message_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, to_id, from_id, message_id);
    }

    @Override
    public String toString() {
        return "MessageMapping{" +
                "id=" + id +
                ", to_id=" + to_id +
                ", from_id=" + from_id +
                ", message_id=" + message_id +
                '}';
    }
}
