package businessLogic;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Order implements Serializable   {
    private int id;
    private int clientId;
    private LocalDateTime time;

    public Order(int id, int clientId) {
        this.id = id;
        this.clientId = clientId;
        time= LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public int getClientId() {
        return clientId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", time=" + time +
                '}';
    }
}
