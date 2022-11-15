package com.example.demo.persistence;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.hibernate.search.mapper.orm.Search;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final EntityManager entityManager;

    //https://docs.jboss.org/hibernate/stable/search/reference/en-US/html_single/#getting-started-searching
    public List<BookEntity> searchBookEntities(String isbn) {
        var session = Search.session(entityManager);

        return session.search(BookEntity.class)
                .where(f -> f.match()
                        .field("isbn")
                        .matching(isbn))
                .fetchAllHits();
    }

    @SneakyThrows
    public void triggerInitialIndexing() {
        var session = Search.session(entityManager);
        var massIndexer = session.massIndexer(BookEntity.class);
        massIndexer.startAndWait();
    }
}
