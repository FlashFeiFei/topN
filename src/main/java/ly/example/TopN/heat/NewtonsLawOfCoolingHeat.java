package ly.example.TopN.heat;


import ly.example.TopN.data.NewtonsLawOfCoolingPayload;
import ly.example.TopN.data.Payload;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * 牛顿冷却定律
 * "当前热度分 = 上一期得分 * exp（-（冷却系数） * 时间间隔）"
 * <p>
 * 解释：
 * 1. exp 函数
 * 2. 时间间隔，单位可以自己确定，小时、分钟
 * 3. 冷却系数 例如：指定45分钟后物体温度为初始温度的0.5，即 0.5=1×exp(-a×45)，求得α=0.1556。
 */
public class NewtonsLawOfCoolingHeat implements Heat {

    //冷却系数
    private final double a;

    public NewtonsLawOfCoolingHeat() {
        this.a = 0.1156;
    }

    public NewtonsLawOfCoolingHeat(double a) {
        this.a = a;
    }

    public double compute(Payload payload) {
        //类型转化
        NewtonsLawOfCoolingPayload newtonsLawOfCoolingPayload = (NewtonsLawOfCoolingPayload) payload;
        //以分钟为单位
        Duration between = Duration.between(LocalDateTime.now(), newtonsLawOfCoolingPayload.getCreateDateTime());

        //当前热度分 = 上一期得分 * exp（-（冷却系数） * 时间间隔）
        return newtonsLawOfCoolingPayload.getScore() * Math.exp(-1 * a * Math.abs(between.toMinutes()));
    }
}
