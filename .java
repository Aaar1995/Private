// Сущность User
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String login;
    private String password;
    private String phone;
    private String email;
    private String fullName;
    private Date birthDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    // getters and setters
}

// Сущность Account
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double balance;

    // getters and setters
}

// Репозитории
public interface UserRepository extends JpaRepository<User, Long> {}
public interface AccountRepository extends JpaRepository<Account, Long> {}

// Контроллеры
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        // реализация регистрации пользователя
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        // реализация обновления информации пользователя
    }

    @GetMapping
    public ResponseEntity<List<User>> search(UserSearchCriteria criteria) {
        // реализация поиска пользователей
    }
}

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @PostMapping("/{id}/transfer")
    public ResponseEntity<Account> transfer(@PathVariable Long id, @RequestBody TransferRequest request) {
        // реализация перевода денег
    }
}
