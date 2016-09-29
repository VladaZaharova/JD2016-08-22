package by.it.shkantau.jd02_02.market;

import java.util.Currency;
import java.util.Locale;
import java.util.Map;

public class Cashier implements Runnable {

    private Double chashProceed = 0.0;
    private String name;
    public Cashier(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        Buyer buyer;
        boolean serviceStatus = false;

        while (true) {
//  kill thread if there is no buyersList buyersList
            synchronized (RunnerMarket.getBuyersList()){
                if(RunnerMarket.getBuyersList().size()==0){
                    break;
                }
            }
            synchronized (Queues.queueOfBuyers) {
                if (Queues.queueOfBuyers.size() > 0) {
                    buyer = Queues.queueOfBuyers.pollFirst();
//                  System.out.println(buyer + " services in " + this + " " + (double)(System.currentTimeMillis() - RunnerMarket.getStartMils())/1000);
                    chashProceed += buyer.getBucket().getTotalSum();
                    RunnerMarket.addProceeds(buyer.getBucket().getTotalSum());
                    printCheck(buyer.getBucket());
                    serviceStatus = true;
//  wakeUp Buyer
                    synchronized (buyer) {
                        buyer.notify();
                    }
                }
            }
// sleep service time;
            if (serviceStatus){
                serviceStatus = false;
                try {
                    Thread.sleep(Helper.random(2.0, 5.0));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(this + " is closed.");// + (double)(System.currentTimeMillis() - RunnerMarket.getStartMils())/1000);
        System.out.println("CashProceed = "+ chashProceed);
    }

    private void printCheck(Bucket buyerBucket){
        System.out.println("Services check, " + this);
        int indexOfGoods = 1;
        for (Map.Entry<Goods, Double> entry : buyerBucket.getGoodsInBucket().entrySet()) {
            System.out.println("" + (indexOfGoods++)+". " + entry.getKey().getName() + "\t" + (entry.getValue()+"*" + entry.getKey().getCost()));
        }
        System.out.printf("Total sum = %.2f %s\n",buyerBucket.getTotalSum(), Currency.getInstance(new Locale("ru", "ru")));
    }


    @Override
    public String toString() {
        return  "Cash" + this.name;
    }
}
