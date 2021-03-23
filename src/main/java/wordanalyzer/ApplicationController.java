package wordanalyzer;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ApplicationController {

    @RequestMapping(value = "/wordanalyzer/")
    public String root_path() {
        return "Слово для анализа не обнаружено. Добавьте '/analyze?word=_test'"+
               " где _test - слово для анализа.";
    }

    @RequestMapping(value = "/wordanalyzer/analyze")
    public String analyze_path(
       @RequestParam("word") String word) {
         Analyzer runner = new Analyzer(word);
        if(word != "")
         return runner.analyze();
        else return "Слово не введено";
    }
}
