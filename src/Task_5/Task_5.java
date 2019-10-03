//Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать свое значение
//на единицу в заданном диапазоне. Предусмотрите инициализацию счетчика значениями по умолчанию и
//произвольными значениями. Счетчик имеет  методы  увеличения и уменьшения  состояния,  и метод
//позволяющее получить его текущее состояние. Написать код, демонстрирующий все возможности класса.

package Task_5;

public class Task_5 {
    int current;
    int high;
    int low;
    public String codeMistake;

    public Task_5() {                      // Конструктор
        this.current = 0;                // 1-й -по умолчанию
        this.high = 0;
        this.low = 10;
    }

    public Task_5(int current, int MinValue, int MaxValue) { // 2-й - c параметрами
        int x = Math.min(MinValue, MaxValue); // проверим границы
        if (x != MinValue) {
            MaxValue = MinValue;
            MinValue = x;
        }
        if (current < MinValue || current > MaxValue) {
            this.current = MinValue;
        }
        else {
            this.current = current;
        }
        this.low = MinValue;
        this.high = MaxValue;
    }

    public int state(){
            return this.current;                    // Возвращаем текущее состояние счетчика
    }

    public void increase() {                         // инкримент счетчика
        this.current++;

        if (this.current > this.high){               // проверка выхода за границу диапозона
            this.current = this.high;
            this.codeMistake = "Valid value exceeded";
        }
    }

    public void reduce() {  // дикримент счетчика
        this.current--;

        if (this.current < this.low) {
            this.current = this.low;
            this.codeMistake = "Valid value exceeded";  // проверка выхода за границу диапозона
        }
    }
        public static void main(String[] args) {
            Task_5 find = new Task_5();
            System.out.println(find.state());
            while (find.codeMistake == null) {
                find.increase();
                System.out.println(find.state());
            }
            System.out.println(find.codeMistake);
        }
    }
