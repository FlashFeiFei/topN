package ly.example.TopN.data;

import java.time.LocalDateTime;

/**
 * 时间权重需要的数据
 */
public class DatePayload extends Payload {

    //内容点赞总数
    private final int likeTotal;

    public DatePayload(long id, LocalDateTime createDateTime, double score, int likeTotal) {
        super(id, createDateTime, score);
        this.likeTotal = likeTotal;
    }

    public int getLikeTotal() {
        return likeTotal;
    }
}
