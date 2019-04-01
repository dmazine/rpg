package br.com.dmazine.rpg;

import java.io.Serializable;
import java.util.Objects;

public class Entity implements Serializable {

    private String id;

    public Entity(String id) {
        setId(id);
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Entity)) {
            return false;
        }

        final Entity other = (Entity) obj;
        return Objects.equals(id, other.id);
    }

}
