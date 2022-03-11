package ly.example.TopN.heat;

import ly.example.TopN.data.Payload;
import ly.example.TopN.data.StackOverflowPayload;

import java.time.Duration;
import java.time.LocalDateTime;


/**
 * 回帖机制 Stack Overflow
 *
 * @see <a href="https://hunglish.github.io/2018/07/08/20180708%E7%83%AD%E5%BA%A6TopN%E6%8E%92%E5%90%8D%E7%AE%97%E6%B3%95%E8%AE%BE%E8%AE%A1%E6%B2%89%E6%80%9D%E5%BD%95/">回帖机制Stack Overflow</a>
 * <p>
 * <p>
 * ((log10Qviews)∗4 + (Qanswers∗Qscore) / 5 + sum(Ascores) ) / ((Qage+1)−(Qage−Qupdated2))1.5
 * <p>
 * <p>
 * Qviews 问题浏览次数,某个问题的浏览次数越多，就代表越受关注，得分也就越高。这里使用了以10为底的对数，用意是当访问量越来越大，它对得分的影响将不断变小
 * <p>
 * Ascores 回答总得分
 * <p>
 * Qage（距离问题发表的时间） Qage和Qupdated的单位都是秒
 * <p>
 * Qupdated（距最后一个回答的时间） Qage和Qupdated的单位都是秒
 */
public class StackOverflowHeat implements Heat {


    public double compute(Payload payload) {

        StackOverflowPayload stackOverflowPayload = (StackOverflowPayload) payload;

        //问题的总浏览数
        int qViews = stackOverflowPayload.getqViews();
        //问题得分
        double qScore = stackOverflowPayload.getqScore();

        //回答总数
        int qAnswers = stackOverflowPayload.getqAnswers();

        LocalDateTime now = LocalDateTime.now();
        Duration betweenQAge = Duration.between(now, stackOverflowPayload.getCreateDateTime());
        double qAge = Math.abs(betweenQAge.toMillis()) / 1000.0;

        //最后一个回答的时间
        Duration betweenQUpdated = Duration.between(now, stackOverflowPayload.getLastAnswerDateTime());
        double qUpdated = Math.abs(betweenQUpdated.toMillis()) / 1000.0;

        //分子
        double molecule = (Math.log10(qViews) * 4) + ((qAnswers * qScore) / 5);

        //分母
        double denominator = Math.pow(((qAge / 2) + (qUpdated / 2) + 1), 1.5);


        return molecule / denominator;
    }
}
