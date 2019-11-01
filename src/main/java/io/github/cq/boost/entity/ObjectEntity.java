package io.github.cq.boost.entity;

import io.github.cq.boost.client.ClientDTO;
import io.github.cq.boost.client.ObjectType;
import io.github.cq.boost.util.BoostConstants;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalTime;

import static io.github.cq.boost.util.BoostConstants.COLUMN_MEDIUMTEXT_LENGTH;
import static io.github.cq.boost.util.BoostConstants.COLUMN_SMALLTEXT_LENGTH;

@Entity
@Table(name = BoostConstants.OBJECT_ENTITY_NAME)
@DiscriminatorValue(BoostConstants.OBJECT_ENTITY_NAME)
public class ObjectEntity extends AbstractBaseEntity<Long, ClientDTO> {

    @Column(name = "object_type", nullable = false)
    private ObjectType objectType;

    @Column(length = COLUMN_SMALLTEXT_LENGTH)
    private String title;

    @Column(length = COLUMN_MEDIUMTEXT_LENGTH)
    private String summary;

    @CreatedBy
    @Column(name = "created_by", length = COLUMN_SMALLTEXT_LENGTH)
    private String createdBy;

    @Column(name = "created_on", nullable = false, updatable = false)
    @CreatedDate
    private LocalTime createdOn;

    @Version
    private Integer version;

    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalTime createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
