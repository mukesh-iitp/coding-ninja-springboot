package Telecom.SubscriptionService.service;

import Telecom.SubscriptionService.dto.UserDto;
import Telecom.SubscriptionService.feign.SupportService;
import Telecom.SubscriptionService.model.Subscription;
import Telecom.SubscriptionService.model.User;
import Telecom.SubscriptionService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class UserService {


	@Autowired
	private UserRepository userRepository;

	//private RestTemplate restTemplate= new RestTemplate();
	
	@Autowired
    private SupportService supportService;

	public void createUser(UserDto userDto) {
		User user = new User();
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setAddress(userDto.getAddress());
		user.setContact(userDto.getContact());
		for(Subscription subscription : userDto.getSubscriptionList()){
			subscription.setUser(user);
		}
		user.setSubscriptionList(userDto.getSubscriptionList());
		userRepository.save(user);
	}

	public List<User> getAllUsers(){
		return this.userRepository.findAll();
	}

	public User getUserByName(String name){
		return userRepository.findByName(name);
	}

	public User getUserByEmail(String email){
		return userRepository.findByEmail(email);
	}

	public User getUserById(Long id) {
		return userRepository.findById(id)
				.orElse(null);
	}

	public void updateUser(Long id, UserDto userDto) {
		User existingUser = userRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("User not found with ID: " + id));
		existingUser.setName(userDto.getName());
		existingUser.setContact(userDto.getContact());
		existingUser.setEmail(userDto.getEmail());
		for(Subscription subscription : userDto.getSubscriptionList()){
			subscription.setUser(existingUser);
		}
		existingUser.setSubscriptionList(userDto.getSubscriptionList());
		userRepository.save(existingUser);
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	//	public List<TicketDto> getAllTickets(Long userId) {
	public  List<Object> getUserTickets(Long userId) {
		//		String resourceUrl = "http://localhost:8083/ticket/userId/{userId}";
		//		List<TicketDto> ticketList = restTemplate.getTicketByUserId(resourceUrl, TicketDto.class, userId);
		//		return ticketList;
		
		//String resourceUrl = "http://localhost:8083/ticket/userId";
		//System.out.println(userId);
		//System.out.println(resourceUrl + "/" + userId);
		//ResponseEntity<Object> response= restTemplate.exchange(resourceUrl + "/" + userId,
		//		HttpMethod.GET, null, Object.class);
		//return (List<Object>)response.getBody();
		return supportService.getTicketByUserId(userId);
	}



}
