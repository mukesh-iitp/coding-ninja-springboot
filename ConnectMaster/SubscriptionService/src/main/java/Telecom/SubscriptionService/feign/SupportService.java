package Telecom.SubscriptionService.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "support-service")
public interface SupportService {
	
	@GetMapping("ticket/userId/{userId}")
    public List<Object> getTicketByUserId(@PathVariable Long userId);

}
