package wordanalyzer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/* Класс: CounterLetter
    Связывает встречную букву (letter) в слове с её количеством
    в этом слове (count).

    Counter(char ch) - конструктор (буква для подсчёта)
    void add() - увеличивает счётчик буквы
    get*() - getter буквы/её количества
    String getResultString() - возвращает строку с ответом

*/

public class CounterLetter {
  private char letter; // Буква в слове
  private byte count = 1; // Количество буквы letter в слове

  CounterLetter(char ch) {
    this.letter = ch;
  }

  public void add() {
    this.count++;
  }
  public char getLetter() {return this.letter;}
  public byte getCount() {return this.count;}

  public String getResultString() {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String json = gson.toJson(this);
    return "<pre>" + json + "</pre>";
  }
}
