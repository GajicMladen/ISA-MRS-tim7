package tim7.ISAMRSproject.Student2Tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.test.context.junit4.SpringRunner;
import tim7.ISAMRSproject.model.*;
import tim7.ISAMRSproject.repository.ClientRepository;
import tim7.ISAMRSproject.repository.ReservationRepository;
import tim7.ISAMRSproject.service.ActionService;
import tim7.ISAMRSproject.service.ClientService;
import tim7.ISAMRSproject.service.ReservationService;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActionsTests {


    @Autowired
    private ReservationService reservationService;
    @Autowired
    private ClientService clientService;
    @Test(expected = ObjectOptimisticLockingFailureException.class)
    public void testOptimisticLockingScenario() throws Throwable {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<?> future1 = executor.submit(new Runnable() {

            @Override
            public void run() {

                System.out.println("Startovan Thread 1");
                Client client = clientService.findClientById(9);
                Reservation res = reservationService.findById(1);
                reservationService.buyAction(client,res);
                try { Thread.sleep(3000); } catch (InterruptedException e) {}
                reservationService.saveReservation(res);

            }
        });


        executor.submit(new Runnable() {

            @Override
            public void run() {

                System.out.println("Thread 2 start");
                Client client = clientService.findClientById(10);
                Reservation res = reservationService.findById(1);
                try { Thread.sleep(1000); } catch (InterruptedException e) {}
                reservationService.buyAction(client,res);
                reservationService.saveReservation(res);
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
