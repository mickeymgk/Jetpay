package me.miza.jetpay.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Bundle {
    public int amount;
    public int cost;
    public String hoverId;
    public int duration;

    public Bundle(@NonNull int amount,@NonNull int cost, @Nullable String hoverId, @NonNull int duration) {
        this.amount = amount;
        this.cost = cost;
        this.hoverId = hoverId;
        this.duration = duration;
    }
}
