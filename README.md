Gjoshe Todorov 233278

2. Control Flow Graph
   
![CFG](https://github.com/user-attachments/assets/a72e5d2d-0656-4b8c-8c46-315c202ab529)

3. Цикломатска комплексност
   
   Цикломатската комплексност на овој код е 9, истата ја добив преку формулата P + 1, каде што P е бројот на предикатни јазли. Во случајoв P = 8, па цикломатската комплексност изнесува 9.

4. Тест случаи според критериумот Every statement

| Тест Случај | Опис                                                                   | Очекувано                                    |
| ----------- | ---------------------------------------------------------------------- | -------------------------------------------- |
| **TC1**     | `allItems = null`                                                      | Фрла исклучок „allItems list can't be null!“ |
| **TC2**     | Валиден item без попуст, цена < 300, количина < 10; валиден cardNumber | Пресметка на редовна цена, враќа сума        |
| **TC3**     | Item со име `null` или празно                                          | Фрла исклучок „Invalid item!“                |
| **TC4**     | Item со цена > 300, discount > 0, quantity > 10, валидна картичка      | Се вклучува одбивање од 30 и попуст формула  |

5. Тест случаи според критериумот Every path

| Тест Случај | Price > 300 | Discount > 0 | Quantity > 10 | Услов | Акција          |
| ----------- | ----------- | ------------ | ------------- | ----- | --------------- |
| **MC1**     | false       | false        | false         | false | Не се одзема 30 |
| **MC2**     | true        | false        | false         | true  | Се одзема 30    |
| **MC3**     | false       | true         | false         | true  | Се одзема 30    |
| **MC4**     | false       | false        | true          | true  | Се одзема 30    |

Објаснување на напишаните unit tests

Every Statement (Минимум 4 тест случаи):
allItems = null – за да се активира throw за null листа.
Item со null име – за throw при невалиден предмет.
Валиден item без попуст и мала цена – пресметка без одбивка.
Item со висока цена, попуст или голема количина – активирање на условот price > 300 || discount > 0 || quantity > 10.

Multiple Condition (Минимум 4 тест случаи):
Потребни се случаи кои ги покриваат сите можни true/false комбинации од условот:
item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10
false || false || false → условот е false
true || false || false → условот е true
false || true || false → условот е true
false || false || true → условот е true
