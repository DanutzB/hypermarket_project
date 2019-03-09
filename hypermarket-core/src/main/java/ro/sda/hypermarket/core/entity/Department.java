package ro.sda.hypermarket.core.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "departments", schema = "hypermarket")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 40, nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;


}
