package org.phstudy.sample.dao;

import java.util.List;

import org.phstudy.sample.model.BookService;

public interface BookVechicleServiceDAO {

	public void addBookService(BookService p);

	public void updateBookService(BookService p);

	public List<BookService> listBookServices();

	public BookService getBookServiceById(int id);

	public void removeBookService(int id);
}
