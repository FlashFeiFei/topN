package ly.example.TopN.heat;

import ly.example.TopN.data.DatePayload;
import ly.example.TopN.data.Payload;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * 时间权重
 * <p>
 * (P−1) / (T+2)G
 * <p>
 * P: 表示帖子的得票数
 * T: 表示距离发帖的时间（单位小时）
 * G： 标识因子，它的数值大小决定了排名随时间下降的速度
 */
public class DateHeat implements Heat {

    private final double G;

    public DateHeat() {
        this.G = 9.8;
    }

    public DateHeat(double G) {
        this.G = G;
    }

    @Override
    public double compute(Payload payload) {

        DatePayload datePayload = (DatePayload) payload;

        Duration between = Duration.between(LocalDateTime.now(), datePayload.getCreateDateTime());


        return (datePayload.getLikeTotal() - 1) / Math.pow((Math.abs(between.toHours()) + 2), G);
    }
}
