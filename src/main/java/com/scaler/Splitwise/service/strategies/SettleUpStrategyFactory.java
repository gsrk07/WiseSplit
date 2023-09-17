package com.scaler.Splitwise.service.strategies;

public class SettleUpStrategyFactory {

    public static SettleUpStrategy getSettleUpStrategy(SettleUpStrategies strategyname){
        return new HeapBasedSettleUpStrategy();
    }
}
