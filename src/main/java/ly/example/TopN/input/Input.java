package ly.example.TopN.input;

import ly.example.TopN.data.DatePayload;
import ly.example.TopN.data.NewtonsLawOfCoolingPayload;
import ly.example.TopN.data.Payload;
import ly.example.TopN.data.StackOverflowPayload;
import ly.example.TopN.heat.DateHeat;
import ly.example.TopN.heat.NewtonsLawOfCoolingHeat;
import ly.example.TopN.heat.StackOverflowHeat;
import ly.example.TopN.sink.Sink;

import java.util.List;


/**
 * 计算流程
 * 1. 获取每一项数据，如果有初始分数，进入牛顿冷却定律计算热度
 * 2. 如果没有初始分数，选择一种初始分数生成策略，计算初始分数，进入牛顿冷却定律计算热度
 * <p>
 * INPUT1 原始数据类型
 * INPUT2 首次获得分数需要包装INPUT1的类型
 */
public class Input<INPUT1 extends Payload> {

    private final NewtonsLawOfCoolingHeat newtonsLawOfCoolingHeat;

    private final DateHeat dateHeat;

    private final StackOverflowHeat stackOverflowHeat;

    private final Sink sink;


    public Input(Sink sink) {
        this.sink = sink;
        this.newtonsLawOfCoolingHeat = new NewtonsLawOfCoolingHeat();
        this.dateHeat = new DateHeat();
        this.stackOverflowHeat = new StackOverflowHeat();
    }


    /**
     * 计算热度，默认是采用牛顿冷却定律
     *
     * @param data
     */
    public void run(List<INPUT1> data) {

        //输出分数
        data.stream().peek(payload -> {


            //根据数据源类型，采用指定的计算公式
            double compute;
            if (payload instanceof DatePayload) {
                compute = computeByDateOrStackOverflow(payload);
            } else if (payload instanceof StackOverflowPayload) {
                compute = computeByDateOrStackOverflow(payload);
            } else if (payload instanceof NewtonsLawOfCoolingPayload) {
                compute = computeByNewtonsLawOfCoolingHeat(payload);
            } else {
                compute = computeByNewtonsLawOfCoolingHeat(payload);
            }


            payload.setScore(compute);

        }).forEach(sink::inputResult);
    }

    private double computeByDateOrStackOverflow(Payload payload) {

        double compute;
        if (payload instanceof DatePayload) {
            compute = dateHeat.compute(payload);
        } else if (payload instanceof StackOverflowPayload) {
            compute = stackOverflowHeat.compute(payload);
        } else {
            throw new RuntimeException("未支持的类型");
        }

        if (compute == payload.getScore()) {
            compute = computeByNewtonsLawOfCoolingHeat(payload);
        }

        return compute;
    }

    private double computeByNewtonsLawOfCoolingHeat(Payload payload) {

        NewtonsLawOfCoolingPayload newtonsLawOfCoolingPayload = new NewtonsLawOfCoolingPayload(payload.getId(), payload.getCreateDateTime(), payload.getScore());
        return newtonsLawOfCoolingHeat.compute(newtonsLawOfCoolingPayload);
    }

}
