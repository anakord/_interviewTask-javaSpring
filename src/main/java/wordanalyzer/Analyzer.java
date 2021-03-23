package wordanalyzer;

import java.util.ArrayList;

/* Класс: Analyzer
  Хранит информацию о всех парах буква-количество(СounterLetter)
  Analyzer(String word) - конструктор (слово для анализа)
  String analyze() - возвращает ответ согласно условия задачи

*/

public class Analyzer {
  private String target_word;
  private ArrayList<CounterLetter> arr_CounterLetter = new ArrayList<CounterLetter>();

  Analyzer(String word) {
    this.target_word = word.toLowerCase();
  }

  public String analyze() {
    // Заполнение счётчиков букв
    int max_count = 1;
    CounterLetter result = null;

    for(int i = 0; i < this.target_word.length(); i++) {

        char curch = this.target_word.charAt(i);
        boolean is_exists = false; //Здесь хотелось бы иметь единый интерфейс
        // добавления без этой проверки, но пока не придумал как
        for(CounterLetter curCounter: this.arr_CounterLetter) {
            if(curCounter.getLetter() == curch) {
              curCounter.add();
              is_exists = true;
              if(max_count < curCounter.getCount())
                max_count = curCounter.getCount();
            }
            if(max_count == curCounter.getCount())
              result = curCounter;
        }
        if(!is_exists)
          arr_CounterLetter.add(new CounterLetter(curch));
    }

    return result.getResultString();
  }
}
