package quoter.aspect;

import org.springframework.stereotype.Component;
import quoter.aspect.annotation.ProfilingMethodA;
import quoter.aspect.annotation.RandomizeA;

import javax.annotation.PostConstruct;

/**
 * Created by dasha on 03.05.18.
 */
@Component
public class SayQuoter implements Quoter {
    private String message;

    @RandomizeA(min = 3, max = 10)
    private int repeat;

    @PostConstruct
    void init() {
        System.out.println("Phase 1.2: postProcessBeforeInitialization, repeat = " + repeat);
        System.out.print("Phase 2: init(), setMessage: ");
        message = "Hi! I'm robot Rob!";
        sayQuoter();
    }

    @Override
    public void sayQuoter() {
        System.out.println(message);
    }

    @ProfilingMethodA
    public void now() {
        for (int i = 0; i < repeat; i++) {
            sayQuoter();
        }
    }
}
