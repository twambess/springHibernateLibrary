package com.zaurtregulov.spring.mvc_hibernate_aop.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="readers")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="number_phone")
    private String number_phone;
    @OneToMany(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}
    , mappedBy = "reader")
    private List<Book> bks;

    public Reader() {
    }

    public Reader(int id, String name, String surname, String number_phone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.number_phone = number_phone;
    }

    public void addBookToReader(Book book){
        if(bks == null){
            bks = new ArrayList<>();
        }
        bks.add(book);
        book.setReader(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumber_phone() {
        return number_phone;
    }

    public void setNumber_phone(String number_phone) {
        this.number_phone = number_phone;
    }

    public List<Book> getBooks() {
        return bks;
    }

    public void setBks(List<Book> bks) {
        this.bks = bks;
    }
}
