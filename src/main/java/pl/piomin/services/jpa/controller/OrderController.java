package pl.piomin.services.jpa.controller;

@RestController
@RequestMapping("/order")
public class OrderController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	AccountClient accountClient;
	@Autowired
	CustomerRepository repository;
	
	@PostMapping
	public Customer add(@RequestBody Customer customer) {
		return repository.save(customer);
	}
	
	@PutMapping
	public Customer update(@RequestBody Customer customer) {
		return repository.save(customer);
	}
	
	@GetMapping("/{id}")
	public Customer findById(@PathVariable("id") String id) {
		return repository.findOne(id);
	}
	
	@GetMapping("/withAccounts/{id}")
	public Customer findByIdWithAccounts(@PathVariable("id") String id) throws JsonProcessingException {
		List<Account> accounts = accountClient.findByCustomer(id);
		LOGGER.info("Accounts found: {}", mapper.writeValueAsString(accounts));
		Customer c = repository.findOne(id);
		c.setAccounts(accounts);
		return c;
	}
	
	@PostMapping("/ids")
	public List<Customer> find(@RequestBody List<String> ids) {
		return repository.findByIdIn(ids);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		repository.delete(id);
	}
	
}
