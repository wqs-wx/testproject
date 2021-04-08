package com.mytest.testproject.service;

import com.fhparser.FetalParserLib;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *
 * </p>
 *
 * @author wqs
 * @version 1.0
 * @date 2021/4/8 10:18
 */
@Slf4j
public class FHDataCallbackImpl implements FetalParserLib.FetalCallback {
    public void onPeripheralInfo(int channelId, int isCollecting, int electrodeState, int flashDataSize, long flashTime) {

    }

    public void onPeripheralStart(int channelId) {

    }

    public void onPeripheralStop(int channelId) {

    }

    public void onPeripheralWarnning(int channelId, int warnning) {

    }

    public void onPeripheralElectrodeState(int channelId, byte[] state) {

    }

    public void onOriginalData(int channelId, short[] channel1, short[] channel2, short[] channel3, short[] ucData, int sn, int state, long time) {

    }

    public void onOriginalAcc(int channelId, byte[] accX, byte[] accY, byte[] accZ, int sn, long time) {

    }

    public void onFetusQrsIndex(int channelId, int qrsIndex, long time) {
        log.info("onParentHeartRate回调通道：" + channelId + "，qrsIndex：" + qrsIndex);
    }

    public void onParentQrsIndex(int channelId, int qrsIndex, long time) {
        log.info("onParentHeartRate回调通道：" + channelId + "，qrsIndex：" + qrsIndex);
    }

    public void onFetusHeartRate(int channelId, short heartRate, long time) {
        log.info("onFetusHeartRate回调通道：" + channelId + "，心率数据：" + heartRate);
    }

    public void onParentHeartRate(int channelId, short heartRate, long time) {
        log.info("onParentHeartRate回调通道：" + channelId + "，心率数据：" + heartRate);
    }

    public void onUterineCurve(int channelId, short value, long time) {

    }

    public void onFetusBaseline(int channelId, short heartRate, long time) {

    }

    public void onAccelerationDeceleration(int channelId, int type, int count, long time) {

    }

    public void onUterineData(int channelId, short value, long time) {

    }

    public void onPeriodVariation(int channelId, short periodTimes, long time) {

    }

    public void onAmplitudeVariation(int channelId, int value, long time) {

    }

    public void onStepScore(int channelId, short score, long time) {

    }

    public void onPeripheralWillUpgrade(int channelId) {

    }

    public void onPeripheralProgress(int channelId, float progress) {

    }

    public void onPeripheralUpgradeFinish(int channelId, boolean result) {

    }
}
