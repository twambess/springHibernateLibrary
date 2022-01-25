package com.zaurtregulov.spring.mvc_hibernate_aop.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name="books")
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="author")
    private String author;
    @Column(name="shifr")
    private String shifr;
    @ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="reader_id")
    private Reader reader;

    public Book() {
    }

    public Book(int id, String name, String author, String shifr) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.shifr = shifr;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getShifr() {
        return shifr;
    }

    public void setShifr(String shifr) {
        this.shifr = shifr;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

}
