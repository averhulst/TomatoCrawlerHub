package messaging;

import com.rabbitmq.client.Channel;

import java.io.IOException;

public class Publisher extends Connection {
    private Consumer consumer;

    public Publisher(Channel channel, String queueName) {
        setChannel(channel);
        setQueueName(queueName);

    }

    public void publishMessage(String message){;
        try {
            getChannel().queueDeclare(getQueueName(), false, false, false, null);
            getChannel().basicPublish("", getQueueName(), null, message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}