package by.it.snegurskiy.jd02_01;

/**
 * Created by snegurskiy.nn on 01.10.2016.
 */
public class Buyer extends Thread implements IBuyer, Runnable, IUseBasket {

    int number;

    public Buyer(Integer number) {
        super("Покупатель №" + number.toString());
        this.number = number;
        start();

    }

    public void run() {
        enterToMarket(); //вошел в магазин (мгновенно)
        takeBacket(); //взял корзину
        chooseGoods(); //выбрал товар (от 0,5 до 2 секунд)
        putGoodsToBacket(); //положил выбранный товар в корзину
        goToOut(); //отправился на выход(мгновенно)
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " зашел в магазин");

    }

    @Override
    public void chooseGoods() {
        int pause=TimeHelper.random(500,2000);
        try {
            sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + " выбрал товар");

    }

    @Override
    public void goToOut() {
        System.out.println(this + " вышел из магазина");

    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBacket() {
        int pause=TimeHelper.random(100,200);
        try {
            sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + " взял корзину");

    }

    @Override
    public void putGoodsToBacket() {
        int pause=TimeHelper.random(100,200);
        try {
            sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + " положил в корзину ТОВАР");

    }
}
