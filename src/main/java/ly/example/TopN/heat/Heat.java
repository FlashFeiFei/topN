package ly.example.TopN.heat;

import ly.example.TopN.data.Payload;

public interface Heat {
    /**
     * 计算下一次的热度
     * @param payload 数据
     * @return 返回下一次的热度得分
     */
    public double compute(Payload payload);
}
