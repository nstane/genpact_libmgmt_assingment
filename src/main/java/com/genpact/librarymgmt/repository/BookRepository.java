package com.genpact.librarymgmt.repository;

import com.genpact.librarymgmt.dto.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("select b from Book b where b.library.id = ?1")
    public List<Book> findBookByLibrary_Id(Long id);
}


