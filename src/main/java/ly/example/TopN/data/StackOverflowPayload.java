package ly.example.TopN.data;

import java.time.LocalDateTime;

public class StackOverflowPayload extends Payload {

    //问题的总浏览数
    private int qViews;

    //问题得分
    private double qScore = 1;

    //回答总数
    private int qAnswers = 2;

    //最后一个回答的时间
    private LocalDateTime lastAnswerDateTime;

    public StackOverflowPayload(long id, LocalDateTime createDateTime, double score, int qViews, int qScore, int qAnswers, LocalDateTime lastAnswerDateTime) {
        super(id, createDateTime, score);
        this.qViews = qViews;
        this.qScore = qScore;
        this.qAnswers = qAnswers;
        this.lastAnswerDateTime = lastAnswerDateTime;
    }

    public int getqViews() {
        return qViews;
    }


    public double getqScore() {
        return qScore;
    }


    public int getqAnswers() {
        return qAnswers;
    }


    public LocalDateTime getLastAnswerDateTime() {
        return lastAnswerDateTime;
    }
}
