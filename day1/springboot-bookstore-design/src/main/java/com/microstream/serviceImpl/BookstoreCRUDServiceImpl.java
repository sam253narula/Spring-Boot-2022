package com.microstream.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microstream.entity.Bookstore;
import com.microstream.exceptions.BookstoreNotFoundRuntimeException;
import com.microstream.repository.BookstoreRepository;

@Service
public class BookstoreCRUDServiceImpl {

	@Autowired
	BookstoreRepository bookstoreRepository;

	public Bookstore createBookStore(Bookstore bookstore) {
		return bookstoreRepository.saveAndFlush(bookstore);
	}

	public List<Bookstore> getBookStores() {
		return bookstoreRepository.findAll();
	}

	public Bookstore getBookStoreById(Long id) {
		Optional<Bookstore> optionalBookStore = bookstoreRepository.findById(id);
		if (optionalBookStore.isPresent()) {
			return optionalBookStore.get();
		} else {
			throw new RuntimeException("There is no Bookstore with id: " + id);
		}
	}

	public List<Bookstore> getBookStoreWhichHasParticularBooks(String books) {
		Bookstore bookstoreWithTheseBooks = Bookstore.builder().books(books).build();
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("books", ExampleMatcher.GenericPropertyMatchers.contains()).withIgnorePaths("id", "name");

		Example<Bookstore> example = Example.of(bookstoreWithTheseBooks, exampleMatcher);
		return bookstoreRepository.findAll(example);
	}

	public Page<Bookstore> getBookStoresInPagedFormat() {
		Pageable pageable = PageRequest.of(0, 2);
		return bookstoreRepository.findAll(pageable);
	}

	public long countBookStores() {
		return bookstoreRepository.count();
	}

	public List<Bookstore> getBookStoresSortedByName() {
		return bookstoreRepository.findAll(Sort.by(Direction.ASC, "name"));
	}

	public boolean bookstoreExistById(Long id) {
		return bookstoreRepository.existsById(id);
	}

	@Transactional
	public Bookstore updateBookStoreName(Long id, String newName) /* throws Exception */  {
		boolean existsById = bookstoreRepository.existsById(id);
		if (existsById) {
			Bookstore bookstore = bookstoreRepository.getById(id);
			bookstore.setName(newName);
			return bookstoreRepository.saveAndFlush(bookstore);
		} else {
			//throw new RuntimeException("There is no Bookstore with the provided id: " + id);
			//throw new Exception("There is no Bookstore with the provided id: " + id);
			//throw new BookstoreNotFoundException("There is no Bookstore with the provided id: " + id);
			throw new BookstoreNotFoundRuntimeException("There is no Bookstore with the provided id: " + id);
		}
	}

	public String deleteBookStoreById(Long id) {
		boolean existsById = bookstoreRepository.existsById(id);
		if (existsById) {
			bookstoreRepository.deleteById(id);
			return "Deleted";
		} else {
			throw new RuntimeException("There is no bookstore with the provided Id: " + id);
		}
	}

	public String truncateBookStore() {
		bookstoreRepository.deleteAll();
		return "Bookstore table truncated";
	}

}
