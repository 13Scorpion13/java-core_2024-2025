package lr2;

public class Example7 {

    public interface BankAccount {
        void deposit(double amount);
        void withdraw(double amount);
        double getBalance();
    }

    public static class Account implements BankAccount {
        private double balance;  // Текущий баланс счета

        public Account (double balance) {
            this.balance = balance;
        }

        @Override
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Депозит успешно выполнен. Текущий баланс: " + balance);
            } else {
                System.out.println("Сумма депозита должна быть положительной.");
            }
        }

        @Override
        public void withdraw(double amount) {
            if (amount > 0) {
                if (balance >= amount) {
                    balance -= amount;
                    System.out.println("Снятие успешно выполнено. Текущий баланс: " + balance);
                } else {
                    System.out.println("Недостаточно средств на счете.");
                }
            } else {
                System.out.println("Сумма снятия должна быть положительной.");
            }
        }

        @Override
        public double getBalance() {
            return balance;
        }
    }

    public static void main (String[] args) {

        Account account = new Account(1000);

        account.deposit(500);  // Вносим депозит 500
        account.deposit(-100); // Пробуем внести отрицательный депозит
        // (хз как можно внести деньги в минус, но всё же, проверка на дурачка)

        account.withdraw(200); // Снимаем деньги: 200
        account.withdraw(2000); // У нас на депозите 1300 (1000+500-200), пытаемся снять > 300, 2000
        account.withdraw(-50);  // Ну и опять проверка на дурачка, пытаемся снять отрицательную сумму
        // хм, по сути - на - дает плюс (будто мы пытаемся дать деньги)

        System.out.println("Текущий баланс: " + account.getBalance());//Смотрим текущий баланс

    }

}

