package com.ideaimpl.patterns.pipeline;

import java.util.List;

/**
 * 
 * Context allows different stages to collaborate by sharing data 
 * 
 * Note: The error handling is defined in the pipeline context since 
 * error handling is absolutely  necessary and has to be done in each stage
 * 
 * @author Benoy Antony (benoy@ideaimpl.com) (http://www.ideaimpl.com) 
 *
 */

public interface PipelineContext {

	public List<Error> getErrors ();
}
