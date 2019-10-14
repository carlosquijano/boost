package io.github.cq.boost.entity;


import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="object_type", discriminatorType=DiscriminatorType.STRING, length = 32)
public abstract class AbstractBaseEntity<PK, T extends Serializable> implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private PK id;

    public PK getId() {
        return id;
    }

    public void setId(PK id) {
        this.id = id;
    }
}
