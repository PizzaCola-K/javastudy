package chapter02.movie;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
