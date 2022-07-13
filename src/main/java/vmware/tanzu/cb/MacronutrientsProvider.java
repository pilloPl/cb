package vmware.tanzu.cb;

import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
class MacronutrientsProvider {

    float protein() {
        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            //for the sake of the demo :)
        }

        //failure simulation
        if (new Random().nextBoolean()) {
            throw new IllegalStateException();
        }
        if (new Random().nextBoolean()) {
            throw new IllegalStateException();
        }

        return 23f;
    }
}
