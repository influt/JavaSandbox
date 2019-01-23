package org.neocities.magranat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import java.util.Date;

@SpringBootApplication
@RestController
@ComponentScan
@Configuration
@EnableAutoConfiguration
public class SandboxService {

    private static final Log log = LogFactory.getLog(SandboxService.class);

    @Autowired
    private EntityManager entityManager;
    @Autowired
    private PlatformTransactionManager transactionManager;

    private TransactionTemplate transactionTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SandboxService.class, args);
    }

    @RequestMapping(value = "/updatePerson", method = RequestMethod.PUT)
    public void updatePerson(
            @RequestParam Integer id,
            @RequestParam String first,
            @RequestParam String last) {
        Person person = entityManager.find(Person.class, id);
        log.debug("Got person in /updatePerson: " + person);

        transactionTemplate = new TransactionTemplate(transactionManager);

        new Thread(() -> updatePersonFirstName(id, first)).start();
        new Thread(() -> updatePersonLastName(id, last)).start();
    }

    private void updatePersonFirstName(Integer id, String first) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            public void doInTransactionWithoutResult(TransactionStatus status) {
                log.debug("Trying to find person in updatePersonFirstName: " + id);
                Person person = entityManager.find(Person.class, id, LockModeType.PESSIMISTIC_WRITE);
                log.debug("Found person in updatePersonFirstName: " + person);
                person.setFirstName(first);
                person.setModified(new Date());
                log.debug("sleeping in updatePersonFirstName");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {
                    log.error("Couldn't sleep", ie);
                }
            }
        });
    }

    private void updatePersonLastName(Integer id, String last) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            public void doInTransactionWithoutResult(TransactionStatus status) {
                log.debug("Trying to find person in updatePersonLastName: " + id);
                Person person = entityManager.find(Person.class, id, LockModeType.PESSIMISTIC_WRITE);
                log.debug("Found person in updatePersonLastName: " + person);
                person.setLastName(last);
                person.setModified(new Date());
                log.debug("sleeping in updatePersonLastName");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {
                    log.error("Couldn't sleep", ie);
                }
            }
        });
    }
}
