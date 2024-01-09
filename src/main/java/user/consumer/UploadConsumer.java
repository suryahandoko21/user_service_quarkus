package user.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.smallrye.common.annotation.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import user.dto.request.RegisterRequest;
import user.service.UserService;

@ApplicationScoped
public class UploadConsumer {
    private static final Logger logger = LoggerFactory.getLogger(UploadConsumer.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final UserService userService;

    @Inject
    public UploadConsumer(UserService userService){
        this.userService = userService;
    }

    @Incoming("user-created")
    @Blocking
    @Transactional(Transactional.TxType.REQUIRED)
    public void reassignLeadDistributionExpired(String message) throws JsonProcessingException {
        logger.info("assignLeadDistribution Start: {}", message);
        final RegisterRequest request = objectMapper.readValue(message, RegisterRequest.class);
        userService.saveUser(request);
        logger.info("assignLeadDistribution End: {}", message);
    }
}
