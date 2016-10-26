package com.realdolmen.course.service.jms;

import com.realdolmen.course.domain.Person;
import com.realdolmen.course.domain.VerifiedPerson;
import com.realdolmen.course.utilities.integration.RemoteJmsTest;
import org.junit.Test;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import java.time.LocalDateTime;

public class PersonMessageDrivenBeanTest extends RemoteJmsTest {
    @Test
    public void shouldSendAPersonMessage() throws JMSException {
        ObjectMessage message = session.createObjectMessage(new VerifiedPerson("Theo", "Tester", "pass", "mail", LocalDateTime.now(), 21));
        producer.send(message);
        assertPatiently(() -> assertEquals(3, count(Person.class)));
    }
}
