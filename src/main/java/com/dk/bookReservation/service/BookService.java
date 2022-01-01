package com.dk.bookReservation.service;

import com.dk.bookReservation.dto.BookDto;
import com.dk.bookReservation.entity.Author;
import com.dk.bookReservation.entity.Book;
import com.dk.bookReservation.repository.AuthorRepository;
import com.dk.bookReservation.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    // 도서 목록 조회(전체)
    public List<Book> readBooks(){
        return bookRepository.findAll();
    }

    // 도서 목록 조회(id)
    public Book readBook(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            return book.get();
        }
        throw new EntityNotFoundException("Can't find any book under given ID");
    }

    // 도서 목록 조회(일련번호)
    public Book readBook(String isbn) {
        Optional<Book> book = bookRepository.findByIsbn(isbn);
        if (book.isPresent()) {
            return book.get();
        }

        throw new EntityNotFoundException("Can't find any book under given ISBN");
    }

    // 도서 목록 추가
    public Book createBook(BookDto bookDto) {
        Optional<Author> author = authorRepository.findById(bookDto.getAuthorId());
        if (!author.isPresent()){
            throw new EntityNotFoundException("Author Not Found");
        }

        Book bookToCreate = new Book();
        BeanUtils.copyProperties(bookDto, bookToCreate);
        bookToCreate.setAuthor(author.get());
        return bookRepository.save(bookToCreate);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
