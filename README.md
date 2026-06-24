# Movie Booking Application

A full-stack RESTful movie booking backend application built with Spring Boot. It supports user authentication, movie and show management, seat booking, ticket pricing, payment integration with Razorpay, and email notifications.

---

## Tech Stack

- **Java 17**
- **Spring Boot 3**
- **Spring Security + JWT** — Authentication & Authorization
- **Spring Data JPA + Hibernate** — ORM
- **MySQL** — Database
- **MapStruct** — DTO mapping
- **Lombok** — Boilerplate reduction
- **Razorpay** — Payment gateway
- **Spring Mail** — Email notifications
- **Maven** — Build tool

---

## Project Structure

```
movie-booking-application/
├── movie-booking-data/         # Data layer (models, repositories, services, mappers, DTOs)
│   └── src/main/java/com/saru/movie_booking/
│       ├── dto/
│       ├── mapper/
│       ├── model/
│       ├── repository/
│       ├── security/
│       └── service/
│           └── impl/
└── movie-booking-web/          # Web layer (controllers, security config)
    └── src/main/java/com/saru/movie_booking/
        ├── controller/
        ├── exception/
        └── security/
```

---

## Prerequisites

- Java 17+
- Maven 3.8+
- MySQL 8+
- Razorpay account ([dashboard.razorpay.com](https://dashboard.razorpay.com))
- Gmail account with App Password enabled

---

## Getting Started

### 1. Clone the repository
```bash
git clone https://github.com/<your-username>/movie-booking-application.git
cd movie-booking-application
```

### 2. Create MySQL Database
```sql
CREATE DATABASE movie_booking;
```
Run the schema from:
```
movie-booking-data/src/main/resources/db/schema.sql
```

### 3. Configure application properties

Update `movie-booking-web/src/main/resources/application.properties`:

```properties
# Database
spring.datasource.url=jdbc:mysql://localhost:3306/movie_booking
spring.datasource.username=<db_username>
spring.datasource.password=<db_password>

# Mail
spring.mail.username=<your_email@gmail.com>
spring.mail.password=<your_app_password>
mail.from=<your_email@gmail.com>

# Razorpay
razorpay.key.id=<your_razorpay_key_id>
razorpay.key.secret=<your_razorpay_key_secret>
```

### 4. Build and Run
```bash
mvn install -DskipTests
cd movie-booking-web
mvn spring-boot:run
```

Application runs on `http://localhost:8080`

---

## API Endpoints

### Authentication
| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| POST | `/api/users/register` | Register new user | Public |
| POST | `/api/auth/login` | Login and get JWT token | Public |

### Users
| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| GET | `/api/users/list` | Get all users | ADMIN |
| GET | `/api/users/{id}` | Get user by ID | ADMIN |
| PUT | `/api/users/{id}` | Update user | ADMIN |
| DELETE | `/api/users/{id}` | Delete user | ADMIN |

### Movies
| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| POST | `/api/movies/add` | Add movie | Required |
| GET | `/api/movies/list` | Get all movies | Required |
| GET | `/api/movies/{id}` | Get movie by ID | Required |
| DELETE | `/api/movies/{id}` | Delete movie | Required |
| GET | `/api/movies/search/title?title=` | Search by title | Required |
| GET | `/api/movies/search/genre?genre=` | Search by genre | Required |
| GET | `/api/movies/search/language?language=` | Search by language | Required |

### Theaters
| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| POST | `/api/theaters/add` | Add theater | Required |
| GET | `/api/theaters/list` | Get all theaters | Required |
| GET | `/api/theaters/{id}` | Get theater by ID | Required |
| DELETE | `/api/theaters/{id}` | Delete theater | Required |

### Screens
| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| POST | `/api/screens/add` | Add screen | Required |
| GET | `/api/screens/list` | Get all screens | Required |
| GET | `/api/screens/{id}` | Get screen by ID | Required |
| DELETE | `/api/screens/{id}` | Delete screen | Required |

### Shows
| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| POST | `/api/shows/add` | Add show | Required |
| GET | `/api/shows/list` | Get all shows | Required |
| GET | `/api/shows/{id}` | Get show by ID | Required |
| DELETE | `/api/shows/{id}` | Delete show | Required |
| GET | `/api/shows/search/movie?movieId=` | Search by movie | Required |
| GET | `/api/shows/search/theater?theaterId=` | Search by theater | Required |
| GET | `/api/shows/search/date?date=` | Search by date | Required |

### Seats
| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| POST | `/api/seats/add` | Add seat | Required |
| GET | `/api/seats/list` | Get all seats | Required |
| GET | `/api/seats/{id}` | Get seat by ID | Required |
| DELETE | `/api/seats/{id}` | Delete seat | Required |
| GET | `/api/seats/available?screenId=` | Get available seats by screen | Required |

### Ticket Prices
| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| POST | `/api/ticket-prices/add` | Add ticket price | Required |
| PUT | `/api/ticket-prices/{id}` | Update ticket price | Required |
| DELETE | `/api/ticket-prices/{id}` | Delete ticket price | Required |
| GET | `/api/ticket-prices?showId=&seatId=` | Get ticket price | Required |

### Bookings
| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| POST | `/api/bookings/add` | Create booking | Required |
| GET | `/api/bookings/list` | Get all bookings | Required |
| GET | `/api/bookings/{id}` | Get booking by ID | Required |
| PUT | `/api/bookings/cancel/{id}` | Cancel booking | Required |
| DELETE | `/api/bookings/{id}` | Delete booking | Required |

### Payments
| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| POST | `/api/payments/create-order/{bookingId}` | Create Razorpay order | Required |
| POST | `/api/payments/verify` | Verify payment signature | Required |
| GET | `/api/payments/booking/{bookingId}` | Get payment by booking | Required |

---

## Authentication

All protected endpoints require a JWT token in the header:
```
Authorization: Bearer <jwt_token>
```

**Register and Login:**
```json
POST /api/users/register
{
    "name": "John Doe",
    "email": "john@example.com",
    "password": "password123",
    "phone": "9876543210",
    "role": "USER"
}

POST /api/auth/login
{
    "email": "john@example.com",
    "password": "password123"
}
```

---

## Booking Flow

1. **Register/Login** → get JWT token
2. **Search movies** → `GET /api/movies/search/title?title=Avengers`
3. **Find shows** → `GET /api/shows/search/movie?movieId=1`
4. **Check available seats** → `GET /api/seats/available?screenId=1`
5. **Create booking** → `POST /api/bookings/add`
6. **Create payment order** → `POST /api/payments/create-order/{bookingId}`
7. **Complete payment** via Razorpay checkout
8. **Verify payment** → `POST /api/payments/verify`
9. **Receive confirmation email** automatically

---

## Payment Flow

```
Create Booking → Create Razorpay Order → Frontend Checkout → Verify Signature → SUCCESS/FAILED
```

---

## Email Notifications

- **Booking Confirmation** — sent automatically after successful booking
- **Booking Cancellation** — sent automatically after cancellation

---

## License

This project is licensed under the MIT License.
