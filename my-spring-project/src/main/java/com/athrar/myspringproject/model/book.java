package com.athrar.myspringproject.model;

public class book {
	private int bookId;
	private String bookName;
	private String authorName;
	private double price;
	
	public book(){}
	
		public book(int bookId, String bookName, String authorName, double price) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.price = price;
	}

		public int getBookId() {
			return bookId;
		}

		public void setBookId(int bookId) {
			this.bookId = bookId;
		}

		public String getBookName() {
			return bookName;
		}

		public void setBookName(String bookName) {
			this.bookName = bookName;
		}

		public String getAuthorName() {
			return authorName;
		}

		public void setAuthorName(String authorName) {
			this.authorName = authorName;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		@Override
		public String toString() {
			return "book [bookId=" + bookId + ", bookName=" + bookName + ", authorName=" + authorName + ", price="
					+ price + "]";
		}	
	
}
