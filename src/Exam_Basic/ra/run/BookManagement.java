package Exam_Basic.ra.run;

import Exam_Basic.ra.bussinessImp.Book;

import java.util.*;

public class BookManagement {
    static List<Book> books = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("**************** JAVA-HACKATHON-05-BASIC-MENU *************** \n" +
                    "Chọn 1_ Nhập số sách và nhập thông tin sách \n" +
                    "Chọn 2_ Hiển thị thông tin các sách \n" +
                    "Chọn 3_ Sắp xếp sách theo lợi nhuận giảm dần \n" +
                    "Chọn 4_ Xóa sách theo mã sách \n" +
                    "Chọn 5_ Tìm kiếm sách theo tên sách \n" +
                    "Chọn 6_ Thay đổi trạng thái của sách theo mã sách \n" +
                    "Chọn 7_ Thoát");
            int choice = Integer.parseInt(scanner.nextLine());
            handleMenu(choice);
        }
    }

    private static void handleMenu(int choise) {
        switch (choise) {
            case 1:
                addBook();
                break;
            case 2:
                showBook();
                break;
            case 3:
                subBook();
                break;
            case 4:
                deleteBook();
                break;
            case 5:
                searchBook();
                break;
            case 6:
                editStatusBook();
                break;
            case 7:
                System.exit(0);
                break;
            default:
                System.err.println("___ Sai định dạng, mời nhập lại ___");
                break;
        }
    }


    private static void addBook() {
        System.out.println("nhập số lượng sách cần thêm: ");
        try {
            int count = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < count; i++) {
                Book book = new Book();
                book.inputData();
                books.add(book);
            }
        } catch (Exception e) {
            System.err.println("nhập sai định dạng, mời nhập lại");
        }
    }

    private static void showBook() {
        System.out.println("kho thư viện sách: ");
        for (int i = 0; i < books.size(); i++) {
            books.get(i).displayData();
        }
    }

    private static void subBook() {
        Collections.sort(books);
        System.out.println("danh sách sau khi đã sắp xếp interest giảm dần:");
        for (Book book : books) {
            book.displayData();
        }
        System.out.println("___ sắp xếp lợi nhuận theo thứ tự giảm dần thành công ___");
    }

    private static void deleteBook() {
        System.out.println("nhập id cuốn sách cần xoá");
        int bookCode = Integer.parseInt(scanner.nextLine());
        Iterator<Book> iterator = books.iterator();
        boolean check = false;
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getBookId() == bookCode) {
                iterator.remove();
                book.displayData();
                check = true;
                break;
            }
        }
        if (check) {
            System.out.println("___ xoá sách thành công ___");
        } else {
            System.err.println("không tìm thấy cuốn sách có id: " + bookCode);
        }
    }

    private static void searchBook() {
        System.out.println("nhập tên cuốn sách cần tìm: ");
        String bookName = scanner.nextLine();
        boolean check = false;
        for (Book book : books) {
            if (book.getBookName().equals(bookName)) {
                book.displayData();
                check = true;
            }
        }
        if (!check) {
            System.err.println("không tìm thấy cuốn sách có tên: " + bookName);
        }
    }

    private static void editStatusBook() {
        System.out.println("nhập id cuốn sách cần thay đổi trạng thái");
        String bookStatus = scanner.nextLine();
        boolean check = false;
        for (Book book : books) {
            if (String.valueOf(book.getBookId()).equals(bookStatus)) {
                book.setBookStatus(!book.isBookStatus());
                book.displayData();
                check = true;
                break;
            }
        }
        if (check) {
            System.out.println("___ thay đổi trạng thái sách thành công ___");
        } else {
            System.err.println("không tìm thấy cuốn sách có id: " + bookStatus);
        }
    }
}
