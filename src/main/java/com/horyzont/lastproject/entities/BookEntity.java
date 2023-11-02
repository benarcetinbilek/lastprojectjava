package com.horyzont.lastproject.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(name= "title")
    private  String title;

    @Column(name = "available", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean available;

    public Integer getId() {return id;}

    public String getTitle() {return title;}

    public Boolean getAvailable() {return available;}

    public void setId(Integer id) {this.id = id;}

    public  void setTitle(String title) {this.title= title;}

    public  void  setAvailable(Boolean available) {this.available = available;}


    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", available=" + available +
                '}';
    }
}
