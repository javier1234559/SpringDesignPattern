# 1.1 Giới thiệu công nghệ

**Spring** là một framework Java phổ biến và được sử dụng rộng rãi để xây dựng các ứng dụng web và doanh nghiệp. Spring ở cốt lõi là một container phụ thuộc tiêm, cung cấp tính linh hoạt để cấu hình các bean theo nhiều cách khác nhau, chẳng hạn như XML, Annotations và JavaConfig. Trong nhiều năm qua, Spring đã phát triển vượt bậc bằng cách đáp ứng nhu cầu của các ứng dụng kinh doanh hiện đại như bảo mật, hỗ trợ cho các cơ sở dữ liệu NoSQL, xử lý dữ liệu lớn, xử lý hàng loạt, tích hợp với các hệ thống khác, v.v. Spring, cùng với các dự án con của nó, trở thành một nền tảng khả thi để xây dựng các ứng dụng doanh nghiệp¹.

**Spring Boot** là một phần mở rộng của framework Spring, loại bỏ các cấu hình boilerplate cần thiết để thiết lập một ứng dụng Spring. Nó có một quan điểm định hướng về nền tảng Spring, tạo đường cho một hệ sinh thái phát triển nhanh hơn và hiệu quả hơn. Một vài tính năng trong Spring Boot có thể kể đến như :

- Tự động cấu hình: Spring Boot tự động cấu hình các bean và thiết lập cần thiết cho ứng dụng của dựa trên các thành phần có sẵn trên classpath.
- Khởi động nhanh: Spring Boot cho phép khởi động và chạy ứng dụng của chỉ trong vài giây bằng cách sử dụng tính năng embedded server như Tomcat hoặc Jetty.
- Quản lý phụ thuộc: Spring Boot quản lý các phiên bản của các thư viện phổ biến và tương thích với nhau thông qua các starter POMs. chỉ cần khai báo các starter POMs tương ứng với các tính năng muốn sử dụng trong ứng dụng
- Hỗ trợ Actuator: Spring Boot Actuator cung cấp các tính năng giám sát và quản lý cho ứng dụng, chẳng hạn như kiểm tra sức khỏe, số liệu thống kê, đường dẫn thông tin, v.v.
- Hỗ trợ testing: Spring Boot hỗ trợ việc kiểm thử ứng dụng của thông qua các annotation như @SpringBootTest và @AutoConfigureMockMvc.

# 1.2 Các Design Pattern sử dụng

## Creational

### **Dependency Injection**

Là một design pattern để loại bỏ sự phụ thuộc giữa các thành phần trong ứng dụng bằng cách cho phép các thành phần nhận các đối tượng phụ thuộc từ bên ngoài thay vì tự tạo ra chúng. Dependency Injection giúp mã nguồn dễ bảo trì, mở rộng và kiểm thử hơn. Spring Framework là một ví dụ điển hình của việc áp dụng Dependency Injection để quản lý các bean trong ứng dụng

### **Singleton Pattern**

Đây là một design pattern thuộc nhóm khởi tạo (creational), đảm bảo rằng chỉ có một thể hiện duy nhất của một lớp được tạo ra và cung cấp một điểm truy cập toàn cục cho nó. Singleton giúp tiết kiệm bộ nhớ và đồng bộ hóa truy cập đến tài nguyên chung

## Structural

### **Proxy Pattern**

Đây là một design pattern thuộc nhóm cấu trúc (structural), cho phép bạn cung cấp một đối tượng đại diện cho một đối tượng thực khác để kiểm soát hoặc tăng cường chức năng của đối tượng thực. Proxy giúp bạn thực hiện các nhiệm vụ như bảo mật, caching, lazy loading, logging, v.v. Ví dụ, bạn có thể sử dụng Proxy để kiểm tra quyền truy cập của người dùng trước khi gọi đến một phương thức nhạy cảm, hoặc để lưu trữ kết quả của một phương thức tốn kém vào bộ nhớ đệm để tránh gọi lại nhiều lần. Spring Framework hỗ trợ việc sử dụng Proxy thông qua tính năng Aspect Oriented Programming¹.

## Behavior

### **Template Method Pattern**

Đây là một design pattern định nghĩa một thuật toán trong một phương thức của lớp cha, và để các lớp con có thể ghi đè một số bước của thuật toán mà không làm thay đổi cấu trúc của nó. Template Pattern giúp tránh lặp lại mã nguồn và tăng tính tái sử dụng..

# 1.3 Ứng dụng Design Pattern trong nền tảng

## Creational

### **Singleton Pattern**

Mẫu Singleton được áp dụng cho đối tượng Bean, đồng thời được khởi tạo mặc định và quản lý bởi ApplicationContext. Nên ở ví dụ này chúng ta sẽ tạo một bean và in ra console để kiểm tra

![](RackMultipart20230601-1-601ac0_html_4a86546175c77c73.png)

![](RackMultipart20230601-1-601ac0_html_8eb2343af42c4328.png)

Kết quả nhận được:

![](RackMultipart20230601-1-601ac0_html_282debe2436f84d4.png)

Khi thực hiện gọi context.getBean(Bean.class), ApplicationContext kiểm tra xem đã có một đối tượng Bean trong bộ nhớ cache chưa. Nếu đã có, nó sẽ trả về đối tượng đó. Ngược lại, nếu chưa có, nó sẽ tạo một đối tượng mới từ lớp Bean, thêm vào bộ nhớ cache và trả về .

Bởi vì Singleton Pattern được áp dụng, chỉ có một phiên bản duy nhất của Bean được tạo và lưu trữ trong bộ nhớ cache của ApplicationContext. Do đó, mỗi lần lấy Bean thông qua context.getBean(Bean.class), chúng ta đều nhận được tham chiếu đến cùng một đối tượng Bean.

### **Dependency Injection**

Dependency Injection (DI) là một mẫu thiết kế chủ chốt trong Spring Framework, nó kết hợp với Inversion of Control (IoC) để giảm sự phụ thuộc vào các đối tượng và tự động tiêm các phụ thuộc một cách tự động, làm cho việc quản lý mã dễ dàng hơn.

![](RackMultipart20230601-1-601ac0_html_4b321541a226ac21.png)

Trong ví dụ này, chúng ta thấy việc sử dụng Dependency Injection trong lớp `BeanService`. `BeanService` được chú thích với `@Service`, đây là một annotation trong Spring để đánh dấu lớp này như một thành phần (component).

Lớp `BeanService` có một trường dữ liệu `bean` được khai báo với từ khóa `final`, đảm bảo rằng giá trị của `bean` chỉ được thiết lập một lần trong quá trình khởi tạo.

Constructor `BeanService` nhận một đối tượng `Bean` như một đối số. Khi tạo một đối tượng `BeanService`, Spring sẽ tự động tiêm một đối tượng `Bean` vào constructor này với Bean cũng đã được đánh dấu là một component ở ví dụ trước đó .

![](RackMultipart20230601-1-601ac0_html_52a5ce16f61ccfbb.png)

Kết quả nhận được :

![](RackMultipart20230601-1-601ac0_html_8528f41de37f98b8.png)

Tiếp theo, chúng ta lấy một đối tượng `BeanService` từ `ApplicationContext` bằng cách gọi `context.getBean(BeanService.class).Và ta thấy được Bean đã được tiêm thành công và hoạt đông bên trong BeanSerice.

## Structural

### Proxy Pattern

Để minh họa cho mẫu Proxy Pattern được JPA sử dụng để tạo nên lazy-loading . Chúng ta sẽ tạo một 2 lớp Entity và thực hiện lấy giá trị một thực thể đang liên kết đến nhiều thực thể .

![](RackMultipart20230601-1-601ac0_html_2b56c56eb9e2f2ee.png)

![](RackMultipart20230601-1-601ac0_html_82cba4a143a6c85c.png)

![](RackMultipart20230601-1-601ac0_html_89bde39ff8fb93f0.png)

Kết quả :

![](RackMultipart20230601-1-601ac0_html_aea0eea69eec5f25.png)

Ở ví dụ trên ta thực hiện sử dụng một lớp EntityManager đây là là một thành phần quan trọng trong JPA (Java Persistence API) và được sử dụng để quản lý các thao tác liên quan đến cơ sở dữ liệu. Trong ví dụ này, chúng ta sử dụng EntityManager để tạo và lưu trữ dữ liệu vào cơ sở dữ liệu H2.và thêm các giá trị tương ứng . Sau đó lấy log các giá trị product từ thực thể Category bằng 2 cách em.getReference() và em.find() .

Ta có thể thấy là đối với thực thể được lấy bằng em.getReference() sẽ tra về một dạng proxy , nên các giá trị product tham chiếu sẽ rỗng . Trong khi em.find() thì sẽ lấy tất cả giá trị tham chiếu đến đối tượng nên sẽ trả về danh sách đầy đủ của các đối tượng Product.

## Behavior

### Template Method Pattern

Mẫu Template Method được sử dụng trong JPA , để minh họa cho điều này chúng ta tạo một Repository kế thừa

![](RackMultipart20230601-1-601ac0_html_3263f151a1847dfc.png)

![](RackMultipart20230601-1-601ac0_html_6ae7fa0164f6767e.png)

Kết quả nhận được là :

![](RackMultipart20230601-1-601ac0_html_5047b21ea20b0f6f.png)

Trong trường hợp này, ProductRepository đã kế thừa từ JpaRepository, một interface trong Spring Data JPA. JpaRepository áp dụng mẫu Method Pattern và cung cấp một tập hợp các phương thức chuyên biệt để thao tác với cơ sở dữ liệu, bao gồm save(), findById(), delete() và nhiều phương thức khác.

Việc kế thừa ProductRepository từ JpaRepository tận dụng các phương thức đã được triển khai sẵn trong JpaRepository, mà không cần phải triển khai lại chúng. Điều này giúp giảm lặp code và tối ưu hóa quá trình thao tác với cơ sở dữ liệu.
