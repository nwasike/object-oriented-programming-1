package com.company;

public class YearRange {
    public int year1;
    public int year2;

    public int rangetype;
    public int divisor1;
    public int divisor2;

    public YearRange(int firstyear, int secondyear){
        this.year1 = firstyear;
        this.year2 = secondyear;
    }

    public void setRangeType(int type){
        this.rangetype = type;

        if(type == 1) {
            this.divisor1 = 14;
            this.divisor2 = 20;
        }
        else if(type == 2){
            this.divisor1 = 4;
            this.divisor2 = 400;
        }
        else if(type == 3){
            this.divisor1 = 4;
            this.divisor2 = 3;
        }
    }

    public int getFirstDivisor(){
        return this.divisor1;
    }

    public int getSecondDivisor(){
        return this.divisor2;
    }

    public int getFirstYear(){
        return this.year1;
    }

    public int getSecondYear(){
        return this.year2;
    }

}

