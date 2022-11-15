package com.example.demo.persistence;

import lombok.RequiredArgsConstructor;
import org.hibernate.search.mapper.orm.Search;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final EntityManager entityManager;

    public List<BookEntity> searchBookEntities(String isbn) {
        var session = Search.session(entityManager);

        return session.search(BookEntity.class)
                .where(f -> f.match()
                        .field("isbn")
                        .matching(isbn))
                .fetchAllHits();
    }
}
