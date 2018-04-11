import lab.model.Message;
import lab.model.simple.SimpleMessage;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static lombok.AccessLevel.PRIVATE;
import static org.junit.jupiter.api.Assertions.assertEquals;

@FieldDefaults(level = PRIVATE)
public class Main {

    static final String APPLICATION_CONTEXT_XML_FILE_NAME = "ioc.xml";

    private BeanFactory context = new ClassPathXmlApplicationContext(
            APPLICATION_CONTEXT_XML_FILE_NAME);

    @Test
    void testInitPerson() {
        Message message = context.getBean("message", Message.class);
        assertEquals(getExpectedMessage(), message);
    }

    private Message getExpectedMessage() {
        return SimpleMessage.builder()
                .message("Hello, world")
                .build();
    }
}
