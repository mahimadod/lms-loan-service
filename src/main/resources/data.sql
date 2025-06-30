INSERT INTO authors ( name) VALUES
( 'J.K. Rowling'),
( 'George R.R. Martin'),
( 'J.R.R. Tolkien'),
( 'Agatha Christie'),
( 'Isaac Asimov');

INSERT INTO publishers ( name) VALUES
( 'Penguin Random House'),
( 'HarperCollins'),
( 'Macmillan Publishers'),
( 'Simon & Schuster'),
( 'Hachette Book Group');

INSERT INTO categories ( name) VALUES
( 'Fantasy'),
( 'Science Fiction'),
( 'Mystery'),
( 'Romance'),
( 'Non-Fiction');

INSERT INTO books ( title, isbn, author_id, publisher_id, category_id, total_copies, available_copies) VALUES
( 'Harry Potter and the Sorcerers Stone', '9780439708180', 1, 1, 1, 10, 8),
( 'A Game of Thrones', '9780553573404', 2, 2, 1, 8, 6),
( 'The Hobbit', '9780547928227', 3, 3, 1, 7, 7),
( 'Murder on the Orient Express', '9780062073501', 4, 4, 3, 5, 4),
( 'Foundation', '9780553293357', 5, 5, 2, 6, 6);


INSERT INTO members (name, email, phone,status) VALUES
('Alice Smith', 'alice@example.com', '1234567890','STUDENT'),
('Bob Johnson', 'bob@example.com', '2345678901','FACULTY'),
('Carol Williams', 'carol@example.com', '3456789012','FACULTY'),
('David Brown', 'david@example.com', '4567890123','STUDENT'),
('Eve Davis', 'eve@example.com', '5678901234','FACULTY');

INSERT INTO loans (member_id, loan_date, due_date, return_date) VALUES
( 1, '2025-05-10', '2025-05-20', NULL),
( 2, '2025-05-11', '2025-05-21', NULL),
( 3, '2025-05-12', '2025-05-22', NULL),
( 4, '2025-05-13', '2025-05-23', '2025-05-17'),
( 5, '2025-05-14', '2025-05-24', '2025-06-18');

INSERT INTO loan_items (loan_id, book_id) VALUES
( 1, 1),
( 1, 2),
( 2, 3),
( 3, 4),
( 4, 5);
