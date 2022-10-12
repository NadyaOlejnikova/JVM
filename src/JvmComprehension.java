public class JvmComprehension {
    // загружается в систему ClassLoader'ов и попадает в Metaspace для сохранения данных
    public static void main(String[] args) {
        int i = 1;                      // 1 Во фрейме main создается переменная i со значением 1 в Stack Memory (область памяти)
        Object o = new Object();        // 2 o попадает в Stack Memory (область памяти), создается Object в heap
        Integer ii = 2;                 // 3 в heap создается объект Integer со значением 2
        printAll(o, i, ii);             // 4 В Stack Memory создается фрейм printAll, и записываются o, i, ii
        System.out.println("finished"); // 7 В Stack'е создается фрейм println, который ссылается на String, который создан в heap (значение finished)
    }
    // Garbage Collector работает параллельно с программой

    private static void printAll(Object o, int i, Integer ii) {   // во фрейме printAll появляется переменная uselessVar со ссылкой на объект Integer (700)
        Integer uselessVar = 700;                   // 5 создается объект Integer со значением 700 в heap
             System.out.println(o.toString() + i + ii);  // 6 В Stack Memory (область памяти) создается фрейм println, фрейм toString
        // Также туда передаются ссылки на Object o, int i и Integer ii
    }
}

