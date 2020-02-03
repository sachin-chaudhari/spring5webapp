package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;


@Component
public class BootStrapData implements CommandLineRunner{

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}



	@Override
	public void run(String... args) throws Exception {
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain driven design", "123123");
		
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development without EJB", "456789");
		
		noEJB.getAuthors().add(rod);
		rod.getBooks().add(noEJB);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		
		Publisher oreily = new Publisher("Oreilly", "43 Privet Drive, Pune");
		publisherRepository.save(oreily);
		
		System.out.println("Started in BootStrap");
		System.out.println("Number of books: " + bookRepository.count());
		System.out.println("Number of publishers: " + publisherRepository.count());
		
	}

}
