package ly.example.TopN;

import ly.example.TopN.data.DatePayload;
import ly.example.TopN.data.NewtonsLawOfCoolingPayload;
import ly.example.TopN.data.StackOverflowPayload;
import ly.example.TopN.input.Input;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {



        Input<DatePayload> payloadDatePayloadInput = new Input<>(
                (payload -> {
                    System.out.println(payload.getScore());
                }));


        System.out.println("时间权重");
        List<DatePayload> list = Arrays.asList(
                new DatePayload(1, LocalDateTime.now().minusHours(2), 0,10),
                new DatePayload(2, LocalDateTime.now().minusHours(3), 0,13),
                new DatePayload(3, LocalDateTime.now().minusHours(6), 0,27),
                new DatePayload(4, LocalDateTime.now().minusHours(4), 0,3),
                new DatePayload(5, LocalDateTime.now().minusHours(1), 0.0010337315795552898,50),
                new DatePayload(6, LocalDateTime.now().minusHours(16), 0,11)
                );



        payloadDatePayloadInput.run(list);


        System.out.println("牛顿冷却定律");
        Input<NewtonsLawOfCoolingPayload> newtonsLawOfCoolingPayloadInput = new Input<>(
                (payload -> {
                    System.out.println(payload.getScore());
                }));
        List<NewtonsLawOfCoolingPayload> newtonsLawOfCoolingPayloadList = Arrays.asList(
                new NewtonsLawOfCoolingPayload(1, LocalDateTime.now().minusHours(2), 10),
                new NewtonsLawOfCoolingPayload(2, LocalDateTime.now().minusHours(3), 20),
                new NewtonsLawOfCoolingPayload(3, LocalDateTime.now().minusHours(6), 30),
                new NewtonsLawOfCoolingPayload(4, LocalDateTime.now().minusHours(4), 5),
                new NewtonsLawOfCoolingPayload(5, LocalDateTime.now().minusHours(1), 2),
                new NewtonsLawOfCoolingPayload(6, LocalDateTime.now().minusHours(16), 3)
        );

        newtonsLawOfCoolingPayloadInput.run(newtonsLawOfCoolingPayloadList);


        System.out.println("回帖机制");

        Input<StackOverflowPayload> stackOverflowPayloadInput = new Input<>(
                (payload -> {
                    System.out.println(payload.getScore());
                }));
        List<StackOverflowPayload> stackOverflowPayloadInputList = Arrays.asList(
                new StackOverflowPayload(1, LocalDateTime.now().minusHours(2), 10,62,2,18,LocalDateTime.now().minusHours(3)),
                new StackOverflowPayload(2, LocalDateTime.now().minusHours(3), 10,19,4,4,LocalDateTime.now().minusHours(2)),
                new StackOverflowPayload(3, LocalDateTime.now().minusHours(4), 10,7,42,21,LocalDateTime.now().minusHours(3)),
                new StackOverflowPayload(4, LocalDateTime.now().minusHours(7), 10,13,32,5,LocalDateTime.now().minusHours(2)),
                new StackOverflowPayload(5, LocalDateTime.now().minusHours(2), 3.643499986062321E-4,32,11,63,LocalDateTime.now().minusHours(1)),
                new StackOverflowPayload(6, LocalDateTime.now().minusHours(1), 10,44,7,2,LocalDateTime.now().minusHours(3))
        );

        stackOverflowPayloadInput.run(stackOverflowPayloadInputList);
    }
}
