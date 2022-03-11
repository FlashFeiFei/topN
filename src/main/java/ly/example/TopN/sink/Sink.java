package ly.example.TopN.sink;

import ly.example.TopN.data.Payload;

public interface Sink {
    void inputResult(Payload payload);
}
