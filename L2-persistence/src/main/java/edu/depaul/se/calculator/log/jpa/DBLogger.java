package edu.depaul.se.calculator.log.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="DBLogs")
public class DBLogger implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String message;
    
    @Temporal(TemporalType.TIMESTAMP)
    private final Date msg_created_time;

    public DBLogger() {
        id = System.currentTimeMillis();
        msg_created_time = new Date(System.currentTimeMillis());
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DBLogger)) {
            return false;
        }
        DBLogger other = (DBLogger) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }
    
}
