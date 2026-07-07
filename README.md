# Todo List Application (Backend API)

Ứng dụng quản lý công việc đầy đủ chức năng gồm backend Spring Boot.

## 1. Mô tả bài toán

Ứng dụng cho phép:
- Hiển thị danh sách công việc
- Thêm công việc mới
- Xem chi tiết một công việc
- Chỉnh sửa thông tin công việc
- Xóa công việc
- Đánh dấu hoàn thành / chưa hoàn thành
- Lọc công việc theo trạng thái, độ ưu tiên hoặc từ khóa
- Phân trang và sắp xếp dữ liệu
- Kiểm tra công việc quá hạn

---

## 2. Công nghệ sử dụng

### Backend

| Thông tin | Chi tiết |
|---|---|
| Framework | Spring Boot 3.5.16 |
| Language | Java 17 |
| Port | 8080 |
| Database | MySQL 8.0 |
| ORM | Spring Data JPA / Hibernate |
| Build Tool | Maven |
| Container | Docker |

**Dependencies chính:**

- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- Spring Boot Starter Validation
- MySQL Connector/J
- MapStruct
- Lombok
- JUnit 5
- Mockito

### Hạ tầng

- Docker
- Docker Compose

---

## 3. Cấu trúc dự án

```text
todolist/                                       # Java Spring Boot service
├── README.md                                   # This file
└── src/
    ├── main/
    │   ├── java/com/example/todolist/
    │   │   ├── controller/                     # REST controllers
    │   │   ├── service/                        # Business logic
    │   │   ├── repository/                     # Data access
    │   │   ├── entity/                         # JPA entities
    │   │   ├── dto/                            # Data transfer objects
    │   │   ├── mapper/                         # MapStruct
    │   │   ├── exception/                      # Exception handling
    │   │   └── specification/                  # Advanced Filtering
    │   └── resources/
    │       └── application.yaml                # Configuration
    └── test/
        └── java/com/example/todolist/
            └── service/
                └── impl/
                    └── TaskServiceImplTest.java # Service unit tests
```

---

## 4. Tính năng đã làm

### Backend

- CRUD công việc.
- Phân trang dữ liệu (lọc công việc theo trạng thái, độ ưu tiên).
- Validation dữ liệu đầu vào.
- Unit Test cho Service Layer bằng JUnit 5 và Mockito.

---

## 5. Yêu cầu của đề bài và trạng thái

| Yêu cầu | Trạng thái |
|---|---|
| Hiển thị danh sách công việc | Đã làm |
| Thêm công việc mới | Đã làm |
| Xem chi tiết công việc | Đã làm |
| Chỉnh sửa công việc | Đã làm |
| Xóa công việc | Đã làm |
| Đánh dấu hoàn thành / chưa hoàn thành | Đã làm |
| Tìm kiếm hoặc lọc theo trạng thái | Đã làm |
| Phân trang hoặc sắp xếp | Đã làm |
| Tổ chức mã nguồn rõ ràng | Đã làm |
| Xử lý dữ liệu không hợp lệ | Đã làm |
| Có README hướng dẫn chạy | Đã làm |
| Docker | Đã làm |
| Unit test | Đã làm |
| Triển khai online | Chưa bổ sung |
| Frontend | Chưa bổ sung |

---

## 6. Chạy bằng Docker Compose

Đây là cách khuyến nghị để chạy toàn bộ hệ thống gồm MySQL và Backend.

### 6.1. Yêu cầu

- Docker
- Docker Compose v2

Kiểm tra Docker Compose:

```bash
docker compose version
```

### 6.2. Chuẩn bị file môi trường

Tạo file môi trường cho backend nếu chưa có:

```bash
cd todolist
```

Nội dung mẫu:

```env
DB_HOST=db
DB_PORT=3306
DB_NAME=todolist_db
DB_USERNAME=root
DB_PASSWORD=root
DB_ROOT_PASSWORD=root
```

### 6.3. Build và chạy

Từ thư mục gốc của dự án, chạy:

```bash
docker compose up -d --build
```

### 6.4. Kiểm tra container

```bash
docker ps
```

### 6.5. Truy cập ứng dụng

- Backend API: `http://localhost:8080`

### 6.6. Dừng hệ thống

Dừng container nhưng giữ lại dữ liệu MySQL:

```bash
docker compose down
```

Dừng container và xóa luôn volume database:

```bash
docker compose down -v
```

---

## 7. Chạy local không dùng Docker

### 7.1. Yêu cầu

- Java 17
- Maven
- MySQL 8.0

### 7.2. Chuẩn bị database

Tạo database trong MySQL:

```sql
CREATE DATABASE todolist_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

Hoặc chạy bằng Docker MySQL riêng:

```bash
docker run --name mysql \
  -e MYSQL_ROOT_PASSWORD=root \
  -e MYSQL_DATABASE=todolist_db \
  -p 3306:3306 \
  -d mysql:8.0
```

### 7.3. Chạy backend

```bash
mvn spring-boot:run
```

Backend mặc định chạy tại:

```text
http://localhost:8080
```

### 7.4. Chạy test

```bash
mvn test
```

---

## 8. API chính

Base URL:

```text
http://localhost:8080/api/v1/tasks
```

### Task API

| Method | Endpoint | Mô tả |
|---|---|---|
| GET | `/tasks` | Lấy danh sách công việc |
| GET | `/tasks/{id}` | Lấy chi tiết công việc |
| POST | `/tasks` | Tạo công việc mới |
| PUT | `/tasks/{id}` | Cập nhật công việc |
| PATCH | `/tasks/{id}/status` | Cập nhật trạng thái công việc |
| DELETE | `/tasks/{id}` | Xóa công việc |

---


## 9. Kết luận

Dự án đáp ứng các yêu cầu chính của bài test Todo List Backend API. Ngoài các chức năng CRUD cơ bản, dự án còn có thêm các điểm mở rộng như phân trang, lọc dữ liệu, unit test và Docker Compose .