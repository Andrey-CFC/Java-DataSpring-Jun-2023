package bg.softuni.gamestore.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class ManyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    @ManyToMany
    @JoinTable(name = "many_entity_friends",
    joinColumns = @JoinColumn(name = "many_entity_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id",referencedColumnName = "id"))
    private Set<ManyEntity> friends;

    public ManyEntity() {
        this.friends = new HashSet<>();
    }

    public ManyEntity(String name, Integer age) {
        this();
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<ManyEntity> getFriends() {
        return friends;
    }

    public void setFriends(Set<ManyEntity> friends) {
        this.friends = friends;
    }
}
