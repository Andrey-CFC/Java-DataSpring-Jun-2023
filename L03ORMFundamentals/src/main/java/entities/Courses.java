package entities;

import orm.annotations.Column;
import orm.annotations.Entity;
import orm.annotations.Id;

@Entity(name = "courses")
public class Courses {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "length_in_weeks")
    private int weeksLength;

    public Courses(){}

    public Courses(String name, int weeksLength) {
        this.name = name;
        this.weeksLength = weeksLength;
    }
}
