package tim7.ISAMRSproject.Student1Tests;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.test.context.junit4.SpringRunner;

import tim7.ISAMRSproject.dto.UserRegisterDTO;
import tim7.ISAMRSproject.model.Client;
import tim7.ISAMRSproject.model.Cottage;
import tim7.ISAMRSproject.model.Reservation;
import tim7.ISAMRSproject.model.User;
import tim7.ISAMRSproject.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
	
	@Autowired
	private UserService userService;
	
	@Test(expected = ObjectOptimisticLockingFailureException.class)
    public void testUpdateSameTime() throws Throwable {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<?> future1 = executor.submit(new Runnable() {

            @Override
            public void run() {

                System.out.println("Startovan Thread 1");
                User u = userService.findById(1).get();
                UserRegisterDTO dto = new UserRegisterDTO();          
                dto.setName("Test");
                dto.setLastName("Testic");
                dto.setCountry("Srbija");
                dto.setTown("Beograd");
                dto.setAddress("Karadjordjeva 10");
                dto.setPhoneNumber("+381642299996");
                userService.updateUser(u, dto);
                
            }
        });


        executor.submit(new Runnable() {

            @Override
            public void run() {

                System.out.println("Thread 2 start");
                User u = userService.findById(1).get();
                UserRegisterDTO dto = new UserRegisterDTO();
                dto.setName("Test");
                dto.setLastName("Testic");
                dto.setCountry("Srbija");
                dto.setTown("Beograd");
                dto.setAddress("Karadjordjeva 10");
                dto.setPhoneNumber("+381642299996");
                userService.updateUser(u, dto);
            }
        });

        try {
            future1.get(); // podize ExecutionException za bilo koji izuzetak iz prvog child threada
        } catch (ExecutionException e) {
            System.out.println("Exception from thread " + e.getCause().getClass()); // u pitanju je bas ObjectOptimisticLockingFailureException
            throw e.getCause();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }

}
