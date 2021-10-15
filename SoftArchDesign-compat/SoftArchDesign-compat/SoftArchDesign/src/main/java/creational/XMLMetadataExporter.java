package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintStream;

public class XMLMetadataExporter extends BookMetadataExporter{

    public void XMLMetadataExporter(){};

    @Override
    public void export(PrintStream  stream) throws ParserConfigurationException, IOException {
        formatter = new XMLBookMetadataFormatter();
        super.export(stream);
    }
}
