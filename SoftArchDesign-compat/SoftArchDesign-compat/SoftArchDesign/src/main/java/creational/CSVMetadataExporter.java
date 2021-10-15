package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintStream;

public class CSVMetadataExporter extends BookMetadataExporter{
    
    public CSVMetadataExporter(){};

    @Override
    public void export(PrintStream stream) throws ParserConfigurationException, IOException {
        formatter = new CSVBookMetadataFormatter();
        super.export(stream);
    }
}
