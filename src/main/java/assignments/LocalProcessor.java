package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private Long period;
    private String processorVersion;
    private Integer valueOfCheap;
    private Scanner informationScanner;
    static List<String> stringArrayList;

    public LocalProcessor(
        String processorName,
        Long period,
        String processorVersion,
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
    public void listIterator(List<String> stringList) {
        stringList.forEach(string ->
            System.out.println(string.hashCode())
        );
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(List<String> stringList) {
        StringBuffer stringBuffer = new StringBuffer();
        stringList.forEach(string -> stringBuffer.append(string + ' '));
        processorName += stringBuffer.toString();
        return processorName;
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        informationScanner = new Scanner(file);
        StringBuffer stringBuffer = new StringBuffer();
        while (informationScanner.hasNext()) {
            stringBuffer.append(informationScanner.nextLine());
        }
        processorVersion += stringBuffer.toString();
    }
}
