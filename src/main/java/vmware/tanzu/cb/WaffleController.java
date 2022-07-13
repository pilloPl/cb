package vmware.tanzu.cb;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class WaffleController {

    private final MacronutrientsProvider macronutrientsProvider;

    WaffleController(MacronutrientsProvider macronutrientsProvider) {
        this.macronutrientsProvider = macronutrientsProvider;
    }

    @GetMapping("/create")
    Waffle create() {
        return new Waffle(macronutrientsProvider.protein());
    }
}
