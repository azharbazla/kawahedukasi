package id.kawahedukasi.tugas6.model;

import java.time.LocalDateTime;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
@Entity
@Table(name = "item")
public class Item extends PanacheEntityBase{
    @Id
    @SequenceGenerator(name = "pesertaSequence", sequenceName = "peserta_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "pesertaSequence", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    public Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "count")
    public String count;

    @Column(name = "price")
    public String price;

    @Column(name = "type")
    public String type;

    @Column(name = "description")
    public String description;

    @Column(name = "createdAt")
    public LocalDateTime createdAt;

    @Column(name = "updateAt")
    public LocalDateTime updatedAt;
}
