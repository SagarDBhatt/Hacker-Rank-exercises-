package CodingInteview.Companies.AWS_SDE_InterviewPrep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class AE_ChannelQuality {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int packetsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> packets = IntStream.range(0, packetsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int channels = Integer.parseInt(bufferedReader.readLine().trim());

        long result = ResultAE1.findMaximumQuality(packets, channels);

        System.out.println(result);
    }
}

class ResultAE1 {

    public static long findMaximumQuality(List<Integer> packets, int channels) {
        //Sort the packets.
        Collections.sort(packets);

        //Make the sublist such a way to get atlesast 1 element from each channel.
        long median = 0;
        int stIndex = 0;
        int endIndex = packets.size() - channels + 1;
        for(int i = 0; i < channels; i++){
            List<Integer> subList = packets.subList(stIndex, endIndex);
            System.out.println(subList);
            median += findMedian(subList);
            stIndex = endIndex;
            endIndex += 1;
        }

        return median;
    }

    public static long findMedian(List<Integer> list){
        if(list.size() % 2 != 0){
            return list.get(list.size()/2);
        }
        else {
            return ( list.get( (list.size() / 2) - 1) +
                    list.get( ( list.size() / 2 ) + 1 ) ) / 2;
        }
    }

}