package br.com.dmazine.rpg.experience;

public class DefaultExperienceGainCalculationStrategy implements ExperienceGainCalculationStrategy {

    private int minimum;

    private int maximum;

    public DefaultExperienceGainCalculationStrategy(int minimum, int maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    @Override
    public int calculateExperienceGain() {
        return (int) (Math.random() * ((maximum - minimum) + 1)) + minimum;
    }

}
