package ly.example.TopN.data;

import java.time.LocalDateTime;

public abstract class Payload {

    //数据唯一标识
    public long id;

    //数据热度得分
    public double score;

    //数据在业务方被创建的时间
    public LocalDateTime createDateTime;

    public Payload(long id, LocalDateTime createDateTime,double score) {
        this.id = id;
        this.createDateTime = createDateTime;
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
