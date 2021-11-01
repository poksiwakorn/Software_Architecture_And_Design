public class Main {
    public static void main(String[] args) throws Exception {
        
        var publisher = new StringPublisher();
        var sub1 = new AlphabetSubscriber("bao1");
        var sub2 = new NumberSubscriber("bao2");
        var sub3 = new SymbolSubscriber("bao3");

        publisher.subscribe(sub1);
        publisher.subscribe(sub2);
        publisher.subscribe(sub3);

        publisher.publish("Hello Test Test");
        publisher.publish("oatxhot555");
        publisher.publish("1+2 = 3");
        publisher.publish("OH NO!!! 123");

        publisher.close();
    }
}
