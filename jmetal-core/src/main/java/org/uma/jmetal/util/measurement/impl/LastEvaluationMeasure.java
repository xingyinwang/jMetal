package org.uma.jmetal.util.measurement.impl;

import org.uma.jmetal.util.measurement.MeasureListener;
import org.uma.jmetal.util.measurement.PushMeasure;
import org.uma.jmetal.util.measurement.impl.LastEvaluationMeasure.Evaluation;

/**
 * {@link LastEvaluationMeasure} is a {@link PushMeasure} providing the last
 * evaluation made in an algorithm. It extends {@link SimplePushMeasure} and add
 * the method {@link #push(Object, Object)} for simplicity.
 * 
 * @author Matthieu Vergne <matthieu.vergne@gmail.com>
 * 
 * @param <Solution>
 *            the solution evaluated
 * @param <Value>
 *            the type of value used to evaluate the solution (Double,
 *            BigDecimal, enum, ...)
 */
public class LastEvaluationMeasure<Solution, Value> extends
		SimplePushMeasure<Evaluation<Solution, Value>> {

	public LastEvaluationMeasure() {
		super("Last evaluation",
				"Provide the last solution evaluated and the result of its evaluation.");
	}

	/**
	 * Wrap the solution and its value into an {@link Evaluation} instance and
	 * push it to the observers which has registered a {@link MeasureListener}
	 * through {@link #register(MeasureListener)}.
	 * 
	 * @param solution
	 *            the solution evaluated
	 * @param value
	 *            the value of this solution
	 */
	public void push(Solution solution, Value value) {
		Evaluation<Solution, Value> evaluation = new Evaluation<Solution, Value>();
		evaluation.solution = solution;
		evaluation.value = value;
		push(evaluation);
	}

	/**
	 * This structure represent an atomic evaluation of a given solution.
	 * 
	 * @author Matthieu Vergne <matthieu.vergne@gmail.com>
	 * 
	 */
	public static class Evaluation<Solution, Value> {
		/**
		 * The solution evaluated.
		 */
		Solution solution;
		/**
		 * The evaluation of the solution.
		 */
		Value value;
	}

}
