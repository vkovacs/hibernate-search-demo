package com.example.demo.persistence;

import lombok.Data;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.KeywordField;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Indexed
public class BookEntity {
    @Id
    @KeywordField
    private String isbn;
    @FullTextField
    private String title;
}
