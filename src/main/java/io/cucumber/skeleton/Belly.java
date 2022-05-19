package io.cucumber.skeleton;

public class Belly {
    private Integer cakes;
    private Integer stomachTime;

    public void eat(Integer cukes) {
        this.cakes = cukes;
    }

    public void waitX(Integer time) {
        this.stomachTime = time;
    }

    public boolean isGrowling() {
        return  (stomachTime<=  cakes / 10 );
    }
}
