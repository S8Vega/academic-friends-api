package co.com.ufps.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
@Table(name = "file")
public class FileEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String name;
    @Column(length = 1000000)
    private String base64;
}
