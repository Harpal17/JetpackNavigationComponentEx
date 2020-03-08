package com.example.jetpacknavigationcomponentex;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;

public class Money implements Parcelable {
    private BigDecimal amount;


    protected Money(Parcel in) {
    }

    public static final Creator<Money> CREATOR = new Creator<Money>() {
        @Override
        public Money createFromParcel(Parcel in) {
            return new Money(in);
        }

        @Override
        public Money[] newArray(int size) {
            return new Money[size];
        }
    };

    public Money() {

    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
