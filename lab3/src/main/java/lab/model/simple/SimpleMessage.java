package lab.model.simple;

import lab.model.Message;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class SimpleMessage implements Message {
    String message;
}
