drop schema public cascade;

drop table books if exists;
create table books (
    id   INTEGER IDENTITY PRIMARY KEY,
   title VARCHAR(255) ,
   available BOOLEAN DEFAULT TRUE
);

drop table clients if exists;
create table clients (
     id   INTEGER IDENTITY PRIMARY KEY,
     client_name VARCHAR(255),
     email VARCHAR(255) 
);

drop table current_book_loans if exists;
create table current_book_loans (
    id   INTEGER IDENTITY PRIMARY KEY,
    client_id INT,
    book_id INT,
    loan_date DATE NOT NULL,
    due_date DATE NOT NULL,
    FOREIGN KEY (client_id) REFERENCES clients(id),
    FOREIGN KEY (book_id) REFERENCES  books(id)
);


-- Sample data for the books table
INSERT INTO books (title, available) VALUES
     ('The Great Gatsby', 1),
     ('To Kill a Mockingbird', 1),
     ('1984', 1),
     ('Pride and Prejudice', 1),
     ('The Catcher in the Rye', 1),
     ('The Hobbit', 1),
     ('Brave New World', 1),
     ('The Lord of the Rings', 1),
     ('Moby-Dick', 1),
     ('War and Peace', 1);

-- Sample data for the clients table
INSERT INTO clients (client_name, email) VALUES
     ('John Smith', 'john.smith@example.com'),
     ('Jane Doe', 'jane.doe@example.com'),
     ('Alice Johnson', 'alice.johnson@example.com'),
     ('Bob Wilson', 'bob.wilson@example.com'),
     ('Eva Brown', 'eva.brown@example.com');

-- Sample data for the current_book_loans table
INSERT INTO current_book_loans (client_id, book_id, loan_date, due_date) VALUES
     (1, 6, '2023-09-18', '2023-10-02'),
     (2, 7, '2023-09-18', '2023-10-02'),
     (3, 8, '2023-09-18', '2023-10-02'),
     (4, 9, '2023-09-18', '2023-10-02');