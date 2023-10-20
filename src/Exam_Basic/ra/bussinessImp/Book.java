package Exam_Basic.ra.bussinessImp;

import Exam_Basic.ra.bussiness.IBook;

import java.util.Scanner;

public class Book implements IBook, Comparable<Book> {
    private static int idCount = 1;
    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPages;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private boolean bookStatus;

    public Book() {
        this.bookId = idCount++;
        this.bookStatus = true;
    }

    public Book(int bookId, String bookName, String title, int numberOfPages, float importPrice, float exportPrice, float interest, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("______ Nhập thông tin sách ______");

        System.out.println("mời nhập tên sách: ");
        this.bookName = scanner.nextLine();

        System.out.println("mời nhập tiêu đề sách: ");
        this.title = scanner.nextLine();

        System.out.println("mời nhập số trang sách: ");
        this.numberOfPages = Integer.parseInt(scanner.nextLine());

        System.out.print("mời nhập giá nhập sách: ");
        this.importPrice = Float.parseFloat(scanner.nextLine());

        System.out.print("mời nhập giá bán sách: ");
        this.exportPrice = Float.parseFloat(scanner.nextLine());

        System.out.println("""
                mời nhập trạng thái cuốn sách:
                1_true    2_false
                """);
        this.bookStatus = Integer.parseInt(scanner.nextLine()) == 1;

        this.interest = this.exportPrice - this.importPrice;
    }

    @Override
    public void displayData() {
        System.out.println(
                "Book{" +
                        ", bookId=" + bookId +
                        ", bookName='" + bookName + '\'' +
                        ", title='" + title + '\'' +
                        ", numberOfPages=" + numberOfPages +
                        ", importPrice=" + importPrice +
                        ", exportPrice=" + exportPrice +
                        ", interest=" + interest +
                        ", bookStatus=" + bookStatus +
                        '}'
        );
    }

    @Override
    public int compareTo(Book b) {
        return (int) -(this.getInterest() - (b.getInterest()));
    }
}
