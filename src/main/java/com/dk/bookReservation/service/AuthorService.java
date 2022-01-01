package com.dk.bookReservation.service;

import com.dk.bookReservation.dto.AuthorDto;
import com.dk.bookReservation.entity.Author;
import com.dk.bookReservation.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public Author authorCreate(AuthorDto authorDto) {
        Author author = new Author();
        BeanUtils.copyProperties(authorDto, author);
        return authorRepository.save(author);
    }
}
