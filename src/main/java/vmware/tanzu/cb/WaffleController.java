package vmware.tanzu.cb;


import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class WaffleController {

    private final MacronutrientsProvider macronutrientsProvider;
    private final CircuitBreaker circuitBreaker;

    WaffleController(MacronutrientsProvider macronutrientsProvider, CircuitBreakerFactory circuitBreakerFactory) {
        this.macronutrientsProvider = macronutrientsProvider;
        this.circuitBreaker = circuitBreakerFactory.create("waffles");
    }

    @GetMapping("/create")
    Waffle create() {
        return new Waffle(circuitBreaker.run(macronutrientsProvider::protein));
    }
}
