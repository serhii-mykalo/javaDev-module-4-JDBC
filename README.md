# javaDev-module-4-JDBC

Створи новий gradle проєкт. Додай туди необхідні залежності для роботи з СУБД H2.

Створи у корені проєкту директорію sql. Скопіюй туди всі .sql файли з попереднього завдання.

Завдання №1 - створити утилітний клас для роботи з БД
Створи клас-сінглтон Database, який інкапсулює у собі логіку для роботи з БД. Під час створення екземпляру цього класу має відбуватись підключення до СУБД та зберігатись екземпляр Connection. Має бути можливість отримати Connection викликом методу getConnection(). Наприклад, ось так:

Connection conn = Database.getInstance().getConnection();

Завдання №2 - створити клас для ініціалізації структури БД
Створи клас з назвою DatabaseInitService. У цьому класі має бути метод public static void main(String[] args), який зчитуватиме файл sql/init_db.sql і виконуватиме запити з цього класу у БД.

Для роботи з БД використовуй написаний раніше тобою клас Database.

Результат запуску цього класу - проініцалізована база даних з коректно створеними таблицями та зв'язками між цими таблицями.

Завдання №3 - створити клас для наповнення таблиць БД
Створи клас з назвою DatabasePopulateService. У цьому класі має бути метод public static void main(String[] args), який зчитуватиме файл sql/populate_db.sql і виконуватиме запити з цього класу у БД.

Для роботи з БД використовуй написаний раніше тобою клас Database.

Результат запуску цього класу - наповнені таблиці бази даних.

Завдання №4 - створити клас для вибірки даних з БД
Створи клас з назвою DatabaseQueryService. У цьому класі мають бути методи для кожного файлу з SELECT виразом з попереднього завдання. Кожний метод має:

зчитувати відповідний .sql файл
повертати потрібний результат
Кожний метод називай згідно Java Code Conventions. Зверни увагу на коректний тип значення, що повертатиме метод. Наприклад, для файлу find_max_projects_client сигнатура методу виглядатиме List<MaxProjectCountClient> findMaxProjectsClient(). При цьому клас MaxProjectCountClient необхідно описати, наприклад:

public class MaxProjectCountClient {
    private String name;
    private int projectCount;
}

Для роботи з БД використовуй написаний раніше тобою клас Database.

Результат виконання завдання - методи для кожного SELECT запиту, які можна викликати, наприклад, наступним чином:

List<MaxProjectCountClient> maxProjectCountClients = new DatabaseQueryService().findMaxProjectsClient();


Запусти так кожний метод, і переконайсь, що він повертає коректну інформацію і під час запуску ніде не виникають Exceptions.

Завдання №5 - оформи все в github репозиторій
Створи новий репозиторій на GitHub. Додай туди всі необхідні файли твого проєкту. Переконайсь, що в репозиторії немає зайвих файлів.

Результат виконання ДЗ - GitHub репозиторій зі всіма SQL файлами.
