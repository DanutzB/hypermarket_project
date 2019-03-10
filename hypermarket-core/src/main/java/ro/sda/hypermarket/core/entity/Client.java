package ro.sda.hypermarket.core.entity;

import javax.persistence.*;

@Entity
@Table(name = "clients", schema = "hypermarket")

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

}
