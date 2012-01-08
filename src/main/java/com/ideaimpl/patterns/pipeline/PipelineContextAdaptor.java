package com.ideaimpl.patterns.pipeline;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * An adaptor class for the PipelineContext interface
 * 
 * @author Benoy Antony (benoy@ideaimpl.com) (http://www.ideaimpl.com)
 *
 */

public class PipelineContextAdaptor implements PipelineContext {

	private List<Error> m_errors = new ArrayList<Error> ();
	public List<Error> getErrors() {
		return m_errors;
	}
	
	public void addError (Error e){
		m_errors.add(e);
	}

}
