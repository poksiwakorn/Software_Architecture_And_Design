import java.util.List;
import java.util.LinkedList;
import java.util.concurrent.Flow;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class StringSubscriber implements Flow.Subscriber{

    private Flow.Subscription subscription;
    private String name;
    private List<Object> consumedElements = new LinkedList<>();
    private String oldText;

    public StringSubscriber(String name){
        this.name = name;

        try {
			File file = new File(this.name +".txt");
			if (file.createNewFile()) {
			  System.out.println("File created: " + file.getName());
			} else {
			  System.out.println("File already exists.");
			  oldText = new String(Files.readAllBytes(Path.of(this.name + ".txt")));
			}
		}catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
    }

    public abstract void update(String text);

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(Object item) {
        System.out.println(name + " got : " + item);
        consumedElements.add(item);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println( "\n" + name + " --> Done");
    }

    public void writeFile(){
		try{
			FileWriter writer = new FileWriter(this.name + ".txt");
			writer.write(oldText);
            for(var element : consumedElements){
                writer.write(element + "\n");
            }
			writer.close();
			this.onComplete();
		}catch (IOException e) {
			System.out.println("An error occurred.");
			this.onError(e);
		}
	}
}
