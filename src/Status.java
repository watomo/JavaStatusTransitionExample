import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public enum Status {

    準備中,
    処理中,
    完了,
    取消

    ;

    private Status() {

    }

    public Map<Status, List<Status>> transitionTo(Status...  transitionableList) {
        final Map<Status, List<Status>> map = new HashMap<>();
        if(transitionableList == null || transitionableList.length == 0) {
            return map;
        }
        map.put(this, asList(transitionableList));
        return map;
    }

}
