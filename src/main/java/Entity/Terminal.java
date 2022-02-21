package Entity;

import javax.persistence.Entity;

@Entity(name = "terminals")
public class Terminal {
    private String gate;
    private String name;

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}