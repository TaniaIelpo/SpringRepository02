package co.develhope.SpringRepositories02.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table (name="programming_language")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false,updatable = false)
    private Long id;

    @Column(nullable = false,updatable = false)
    private String name;

    private String year;

    @Column(nullable = false,updatable = false)
    private String inventor;
}
