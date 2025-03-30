CREATE DATABASE appLibrary;
USE appLibrary;

-- Bảng Users

CREATE TABLE Users (
    UserID INT IDENTITY(1,1) PRIMARY KEY,
    Username VARCHAR(50) UNIQUE NOT NULL, -- Dùng làm thông tin đăng nhập
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    PhoneNumber VARCHAR(15),
    Password VARCHAR(255) -- Lưu mật khẩu đã mã hóa
);

-- Bảng Librarian 
CREATE TABLE Librarian (
    LibrarianID INT PRIMARY KEY,
    Username VARCHAR(50) UNIQUE NOT NULL, -- Dùng làm thông tin đăng nhập
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    PhoneNumber VARCHAR(15),
    Password VARCHAR(255) -- Lưu mật khẩu đã mã hóa
);

-- Bảng Category
CREATE TABLE Category (
    CategoryID INT PRIMARY KEY,
    CategoryName VARCHAR(100)
);

-- Bảng Author
CREATE TABLE Author (
    AuthorID INT PRIMARY KEY,
    AuthorName VARCHAR(100)
);

-- Bảng Book
CREATE TABLE Book (
    BookID INT PRIMARY KEY,
    Title VARCHAR(255),
    AuthorID INT,
    CategoryID INT,
    Quantity INT CHECK (Quantity >= 0),
    Status VARCHAR(50) CHECK (Status IN ('Available', 'Borrowed', 'Reserved')),
    FOREIGN KEY (AuthorID) REFERENCES Author(AuthorID),
    FOREIGN KEY (CategoryID) REFERENCES Category(CategoryID)
);

-- Bảng Reserve_Return
CREATE TABLE Reserve_Return (
    ReserveID INT PRIMARY KEY,
    UserID INT,
    BookID INT,
    LibrarianID INT,
    ReserveDate DATE,
    DueDate DATE,
    FOREIGN KEY (UserID) REFERENCES Users(UserID),
    FOREIGN KEY (BookID) REFERENCES Book(BookID),
    FOREIGN KEY (LibrarianID) REFERENCES Librarian(LibrarianID)
);

-- Bảng Rate
CREATE TABLE Rate (
    RateID INT PRIMARY KEY,
    UserID INT,
    BookID INT,
    RateStar INT CHECK (RateStar BETWEEN 1 AND 5),
    Comment TEXT,
    FOREIGN KEY (UserID) REFERENCES Users(UserID),
    FOREIGN KEY (BookID) REFERENCES Book(BookID)
);


-- Thêm dữ liệu vào bảng Users
INSERT INTO Users (Username, FirstName, LastName, PhoneNumber, Password) VALUES
('an', 'Nguyen', 'An', '0987654321', '1'),
('binh', 'Tran', 'Binh', '0977123456', '2'),
('chau', 'Le', 'Chau', '0967234567', '3');

-- Thêm dữ liệu vào bảng Librarian
INSERT INTO Librarian (LibrarianID, Username, FirstName, LastName, PhoneNumber, Password) VALUES
(1,'admin' ,'Pham', 'Dung', '0956123456', 'pass'),
(2,'admin1' ,'Hoang', 'Hanh', '0945123456', 'pass1');

-- Thêm dữ liệu vào bảng Category
INSERT INTO Category (CategoryID, CategoryName) VALUES
(1, 'Science Fiction'),
(2, 'History'),
(3, 'Programming'),
(4, 'Philosophy');

-- Thêm dữ liệu vào bảng Author
INSERT INTO Author (AuthorID, AuthorName) VALUES
(1, 'Isaac Asimov'),
(2, 'Stephen Hawking'),
(3, 'Dan Brown'),
(4, 'Yuval Noah Harari');

-- Thêm dữ liệu vào bảng Book
INSERT INTO Book (BookID, Title, AuthorID, CategoryID, Quantity, Status) VALUES
(1, 'Foundation', 1, 1, 5, 'Available'),
(2, 'A Brief History of Time', 2, 2, 3, 'Available'),
(3, 'Inferno', 3, 3, 4, 'Borrowed'),
(4, 'Sapiens', 4, 4, 2, 'Reserved');

-- Thêm dữ liệu vào bảng Reserve_Return
INSERT INTO Reserve_Return (ReserveID, UserID, BookID, LibrarianID, ReserveDate, DueDate) VALUES
(1, 1, 3, 1, '2024-03-01', '2024-03-15'),
(2, 2, 4, 2, '2024-03-05', '2024-03-20');

-- Thêm dữ liệu vào bảng Rate
INSERT INTO Rate (RateID, UserID, BookID, RateStar, Comment) VALUES
(1, 1, 1, 5, 'Amazing sci-fi novel!'),
(2, 2, 2, 4, 'Very informative and inspiring.'),
(3, 3, 3, 3, 'Good book but a bit complex.'),
(4, 1, 4, 5, 'One of the best history books!');


