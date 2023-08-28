package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

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

    public LocalProcessor(
        String processorName,
        Long period,
        String processorVersion,
        Integer valueOfCheap,
        Scanner informationScanner,
        List<String> stringArrayList
    ) {
        this.processorName = new StringBuilder(processorName);
        this.period = period;
        this.processorVersion = new StringBuilder(processorVersion);
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
                System.out.println(Objects.nonNull(string)? string.hashCode() : "null")
            );

        } catch(IllegalStateException ise){
            System.out.println(ise.getMessage());
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
            System.out.println(ise.getMessage());
            throw new IllegalStateException(ise);
        }
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        try {
            if(Objects.isNull(file)) { throw new IllegalStateException("Input is null."); }
            informationScanner = new Scanner(file);
            while (informationScanner.hasNext()) {
                processorVersion.append(informationScanner.nextLine());
            }

        } catch(IllegalStateException ise){
            System.out.println(ise.getMessage());
            throw new IllegalStateException(ise);
        }
    }
}
