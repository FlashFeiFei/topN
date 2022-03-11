package ly.example.TopN.data;


import java.time.LocalDateTime;

/**
 * 牛顿冷却定律需要的数据
 */
public class NewtonsLawOfCoolingPayload extends Payload {

    public NewtonsLawOfCoolingPayload(long id, LocalDateTime createDateTime, double score) {
        super(id, createDateTime, score);
    }
}
