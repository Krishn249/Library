package Project_1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class BookTittleMissMachException extends RuntimeException {

	@Override
	public String toString() {
		return getClass() + ": Book Tittle miss mach Exception..";
	}

}

class BookIdMissMachException extends RuntimeException {
	@Override
	public String toString() {
		return getClass() + ": Book id miss mach Exception..";
	}
}

class BookCostMissMachException extends RuntimeException {
	@Override
	public String toString() {
		return getClass() + ": Book cost miss mach Exception..";
	}
}

class BookNOOfPagesMissMachException extends RuntimeException {
	@Override
	public String toString() {
		return getClass() + ": Book NO of pages miss mach Exception..";
	}
}

class BookAuthorMissMachException extends RuntimeException {
	@Override
	public String toString() {
		return getClass() + ": Book Author miss mach Exception..";
	}
}

class Book {
	private String bookTittle;// java sql Python
	private int id;// id should me Even
	private int cost;// 300-3000
	private int noOfPages;// 500-3000
	private String author;// james scott alean

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String bookTittle, int id, int cost, int noOfPages, String author) {
		if (validTittle(bookTittle)) {
			this.bookTittle = bookTittle;
		} else {
			throw new BookTittleMissMachException();
		}
		if (validId(id)) {
			this.id = id;
		} else {
			throw new BookIdMissMachException();
		}
		if (validCost(cost)) {
			this.cost = cost;
		} else {
			throw new BookCostMissMachException();
		}
		if (validNoOfPages(noOfPages)) {
			this.noOfPages = noOfPages;
		} else {
			throw new BookNOOfPagesMissMachException();
		}
		if (validAuthor(author)) {
			this.author = author;
		} else {
			throw new BookAuthorMissMachException();
		}
	}

	public boolean validTittle(String bookTittle) {
		if (bookTittle.equals("java") || bookTittle.equals("sql") || bookTittle.equals("python")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validId(int id) {
		if (id % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validCost(int cost) {
		if (cost >= 300 && id < 2000) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validNoOfPages(int n) {
		if (n >= 500 && id < 3000) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validAuthor(String author) {
		if (author.equals("james") || bookTittle.equals("scott") || bookTittle.equals("alean")) {
			return true;
		} else {
			return false;
		}
	}

	public String getBookTittle() {
		return bookTittle;
	}

	public void setBookTittle(String bookTittle) {
		this.bookTittle = bookTittle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getNoOfPages() {
		return noOfPages;
	}

	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void display() {
		System.out.println(bookTittle);
		System.out.println(id);
		System.out.println(cost);
		System.out.println(noOfPages);
		System.out.println(author);
	}

	@Override
	public String toString() {
		return "Book [bookTittle=" + bookTittle + ", id=" + id + ", cost=" + cost + ", noOfPages=" + noOfPages
				+ ", author=" + author + "]";
	}
}

class Library {
	private int libId;
	private String location;
	Book b;
	Scanner sc = new Scanner(System.in);
	ArrayList<Book> book = new ArrayList<Book>();

	public void addBook(Book b) {
		book.add(b);

	}

	public void displayBooks() {
		if (book.isEmpty()) {
			System.out.println("Book's are  not filead yet....");
		} else {
			for (Book b : book) {
				b.display();
			}
		}
	}

	public void serchBookBrandOnId(int id) {
		boolean isFound = false;
		if (book.isEmpty()) {
			System.out.println("bookes are not added yet.....");
		} else {
			for (Book b : book) {
				if (b.getId() == id) {
					System.out.println(b.getBookTittle());
					isFound = true;
				}
			}
		}
		if (isFound == false) {
			throw new BookIdMissMachException();
		}

	}

	public void serchBookBrandOnAuthor(String num) {
		boolean found = false;
		if (book.isEmpty()) {
			System.out.println(" books are not added...");

		} else {
			for (Book b : book) {
				if (b.getAuthor().equals(num)) {
					System.out.println(b.getBookTittle());
					;
					found = true;
				}
			}
		}
		if (found == false) {
			throw new BookAuthorMissMachException();
		}

	}

	public void updateBookCostBasedOnTittle(String tittle) {
		boolean found = false;
		if (book.isEmpty()) {
			System.out.println(" books are not added...");
		} else {
			for (Book b : book) {
				if (b.getBookTittle().equals(tittle)) {
					b.setCost(10000);
					found = true;
				}
			}
		}
		if (found == false) {
			throw new BookTittleMissMachException();
		}
	}

	public void removeBookBasedOnId(int id) {
		boolean found = false;
		Iterator<Book> it = book.iterator();
		if (book.isEmpty()) {
			System.out.println(" books are not added...");
		} else {
			while (it.hasNext()) {
				Book b = it.next();
				if (b.getId() == id) {
					it.remove();
					found = true;
				}
			}
		}
		if (found == false) {
			throw new BookIdMissMachException();
		}
	}

}

public class mainapp {
	public static void main(String[] args) {
		String bookTittle;
		int id;
		int cost;
		int noOfPages;
		String author;
		Library l = new Library();
		Scanner sc = new Scanner(System.in);
		boolean con = true;
		while (con) {
			System.out.println(
					"Enter the choice ...\n 1.add the book \n 2.display the bookes \n 3.serch the book based on id \n 4.serch the book based on author \n 5.update the cost of book based on tittle\n 6.Remove the book based on id");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				while (true) {
					try {
						System.out.println("Enter the tittle of the book...");
						bookTittle = sc.next();
						System.out.println("Enter the id ..");
						id = sc.nextInt();
						System.out.println("Enter the cost ");
						cost = sc.nextInt();
						System.out.println("Enter the noof Pages");
						noOfPages = sc.nextInt();
						System.out.println("Enter the auther name ");
						author = sc.next();
						l.addBook(new Book(bookTittle, id, cost, noOfPages, author));
						break;
					} catch (BookTittleMissMachException e) {
						System.out.println("Enter the valid Tittle....");
						bookTittle = sc.next();
					} catch (BookIdMissMachException e) {
						System.out.println("Enter the valid id....");
						id = sc.nextInt();
					} catch (BookCostMissMachException e) {
						System.out.println("Enter the valid Tittle....");
						cost = sc.nextInt();
					} catch (BookNOOfPagesMissMachException e) {
						System.out.println("Enter the valid Tittle....");
						noOfPages = sc.nextInt();
					} catch (BookAuthorMissMachException e) {
						System.out.println("Enter the valid Tittle....");
						author = sc.next();
					}
				}
			}
			case 2: {
				l.displayBooks();
				break;
			}
			case 3: {
				System.out.println("enter the id ");
				int g = sc.nextInt();
				l.serchBookBrandOnId(g);
				break;
			}
			case 4: {
				System.out.println("Enter the other name ..");
				String s = sc.next();
				l.serchBookBrandOnAuthor(s);
				break;
			}
			case 5: {
				System.out.println("Enter book Tittle.");
				String a = sc.next();
				l.updateBookCostBasedOnTittle(a);
				break;
			}
			case 6: {
				System.out.println("ENter the the id");
				int i = sc.nextInt();
				l.removeBookBasedOnId(i);
				break;
			}
			case 7: {
				con = false;
				break;
			}
			default:
				System.out.println("enter valid choice......");

			}
		}
	}
}
