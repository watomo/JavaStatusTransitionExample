import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;


public class StatusTransition {

    private static final Map<Status, List<Status>> STATUS_TRANSITION_MAP= new HashMap<>();

    static {
        STATUS_TRANSITION_MAP.putAll(Status.準備中.transitionTo(Status.処理中,Status.完了,Status.取消));
        STATUS_TRANSITION_MAP.putAll(Status.処理中.transitionTo(Status.完了,Status.取消));
        STATUS_TRANSITION_MAP.putAll(Status.完了.transitionTo(Status.処理中));
    }

    public static void canTransition(Status beforeStatus, Status afterStatus) {
        if(!STATUS_TRANSITION_MAP.containsKey(beforeStatus)) {
            throw new RuntimeException(String.format("%sは遷移できません。",beforeStatus.name()));
        }
        List<Status> transionableStausList = STATUS_TRANSITION_MAP.get(beforeStatus);
        if(!transionableStausList.contains(afterStatus)) {
            throw new RuntimeException(String.format("%sから%sへは遷移できません。", beforeStatus.name(),afterStatus.name()));
        }
    }
}
