package com.ideaimpl.patterns.pipeline.samples.numbermagic;

import com.ideaimpl.patterns.pipeline.PipelineContextAdaptor;
/**
 * A sample PipelineContext to demonstarte the usage of Pipeline Pattern
 * 
 * @author Benoy Antony (benoy@ideaimpl.com) (http://www.ideaimpl.com)
 *
 */
public class NumberMagicContext extends PipelineContextAdaptor {
	private int[] m_input;
	private int m_offset;
	private int[] m_increasedValues;
	private int[] m_sortedValues;
	
	public int[] getInput() {
		return m_input;
	}
	public void setInput(int[] input) {
		m_input = input;
	}
	public int getOffset() {
		return m_offset;
	}
	public void setOffset(int multiplicator) {
		m_offset = multiplicator;
	}
	public int[] getIncreasedValues() {
		return m_increasedValues;
	}
	public void setIncreasedValues(int[] increasedValues) {
		m_increasedValues = increasedValues;
	}
	public int[] getSortedValues() {
		return m_sortedValues;
	}
	public void setSortedValues(int[] sortedValues) {
		m_sortedValues = sortedValues;
	}
}
