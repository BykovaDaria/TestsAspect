package quoter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import quoter.aspect.SayQuoter;

/**
 * Created by dasha on 03.05.18.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SayQuoterTest {
    @Autowired
    SayQuoter sayQuoter;

    @Test
    public void Test() {
        sayQuoter.now();
    }
}
