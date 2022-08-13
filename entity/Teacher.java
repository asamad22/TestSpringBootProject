package bd.com.dipti.testspring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "teachers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String images;
    @Column(nullable = false, length = 30)
    private String name;
    @Column(nullable = false, length = 40, unique = true)
    private String email;
    @Column(nullable = false, length = 15)
    private String cell;
    @Column(nullable = false, length = 10)
    private String gender;
    private String subject;
    private String address;
}
