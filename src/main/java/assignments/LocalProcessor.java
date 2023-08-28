package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Logger;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LocalProcessor {
    private StringBuilder processorName;
    private Long period;
    private StringBuilder processorVersion;
    private Integer valueOfCheap;
    private Scanner informationScanner;
    private List<String> stringArrayList;

    private final Logger logger = Logger.getLogger(LocalProcessor.class.getName());

    public LocalProcessor(
        StringBuilder processorName,
        Long period,
        StringBuilder processorVersion,
        Integer valueOfCheap,
        Scanner informationScanner,
        List<String> stringArrayList
    ) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) throws IllegalStateException{
        try {
            if(Objects.isNull(stringList)) { throw new IllegalStateException("Input is null."); }
            stringList.forEach(string ->
                System.out.println((Objects.nonNull(string)? string.hashCode() : ""))
            );

        } catch(IllegalStateException ise){
            logger.info(ise.getMessage());
            throw new IllegalStateException(ise);
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(List<String> stringList) throws IllegalStateException{
        try {
            if(Objects.isNull(stringList)) { throw new IllegalStateException("Input is null."); }
            stringList.forEach(string -> processorName.append(string).append(" "));
            return processorName.toString();

        } catch(IllegalStateException ise){
            logger.info(ise.getMessage());
            throw new IllegalStateException(ise);
        }
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        try(Scanner informationScanner = new Scanner(file)){
            if(Objects.isNull(informationScanner)) { throw new IllegalStateException("File is null."); }
            while (informationScanner.hasNext()) {
                processorVersion.append(informationScanner.nextLine());
            }

        } catch(Exception e){
            logger.info(e.getMessage());
            throw new IllegalStateException(e);

        }
    }

    public static void main(String[] args) {
        LocalProcessor processor = new LocalProcessor();
        try {
            String fileName = "\\src\\main\\resources\\text.txt";
            String currentDirectory = System.getProperty("user.dir");
            File file = new File(currentDirectory, fileName);
            String absolutePath = file.getAbsolutePath();

            System.out.println("Absolute path to text.txt: " + absolutePath);
            processor.readFullProcessorName(new File(absolutePath));

        } catch(Exception e){
            processor.logger.info(e.getMessage());
        }
    }
}
