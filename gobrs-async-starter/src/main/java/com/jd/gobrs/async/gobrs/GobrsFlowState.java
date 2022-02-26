package com.jd.gobrs.async.gobrs;

import com.jd.gobrs.async.constant.StateConstant;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: gobrs-async
 * @ClassName GobrsFlowState
 * @description:
 * @author: sizegang
 * @create: 2022-02-19 23:20
 * @Version 1.0
 **/
public class GobrsFlowState {
    public static Map<Long, GobrsState> gobrsFlowState = new ConcurrentHashMap<>();
    public static final int FINISH = StateConstant.FINISH;
    public static final int ERROR = StateConstant.ERROR;
    public static final int WORKING = StateConstant.WORKING;
    public static final int STOP = StateConstant.STOP;

    public static boolean compareAndSetState(int expect, int update, long businessId) {
        GobrsState gobrsState = gobrsFlowState.get(businessId);
        if (gobrsState == null) {
            GobrsState gs = new GobrsState(WORKING);
            if (gs.getState() == expect) {
                gs.setState(update);
                gobrsFlowState.put(businessId, gs);
                return true;
            }
            return false;
        }
        if (expect == gobrsState.getState()) {
            gobrsState.setState(update);
            gobrsFlowState.put(businessId, gobrsState);
            return true;
        }
        return false;
    }

    public static class GobrsState {
        public GobrsState(Integer state) {
            this.state = state;
        }

        private int state;
        private int capCode;

        public Integer getState() {
            return state;
        }

        public void setState(Integer state) {
            this.state = state;
        }

        public Integer getCapCode() {
            return capCode;
        }

        public void setCapCode(Integer capCode) {
            this.capCode = capCode;
        }
    }


}
