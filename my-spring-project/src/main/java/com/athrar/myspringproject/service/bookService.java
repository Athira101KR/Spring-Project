package com.athrar.myspringproject.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.athrar.myspringproject.model.book;

@Service
public class bookService {


	
	//private static final Logger LOGGER= LogManager.getLogger(BooksController.class);
	
		public  Map<Integer,book> bookdb;
		private  int counter;
		
		public bookService()
		{
			counter=0;
			bookdb=new HashMap<>();
			counter++;
			book bookOne=new book(counter,"Bookone","Abc",500);
			bookdb.put(bookOne.getBookId(), bookOne);
			counter++;
			book bookTwo=new book(counter,"BookTwo","Efg",200);
			bookdb.put(bookTwo.getBookId(), bookTwo);
		}
		
		public book getBookByID(Integer bookId) {
			// TODO Auto-generated method stub
			if(bookdb.containsKey(bookId))
			{
				return bookdb.get(bookId);
			}
			return null;
		}
		
		public book addNewBooktoDB(book newBookRequest)
		{
			counter++;
			newBookRequest.setBookId(counter);
			bookdb.put(newBookRequest.getBookId(), newBookRequest);
			return newBookRequest;
		}
		public book updateBooktoDB(int bookId,book updateBookRequest)
		{
			if(bookdb.containsKey(bookId))
			{
				bookdb.put(bookId, updateBookRequest);
				return bookdb.get(bookId);
			}
			else
				return null;
		}
		public boolean deleteBookFromDB(int bookId)
		{
			if(bookdb.containsKey(bookId))
			{
				bookdb.remove(bookId);
				return true;
			}
			else return false;
		}

		
}
