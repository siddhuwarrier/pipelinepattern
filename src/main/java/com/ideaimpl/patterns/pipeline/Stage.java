package com.ideaimpl.patterns.pipeline;

/**
 * A basic work unit in the pipeline.
 * 
 * @author Benoy Antony (benoy@ideaimpl.com) (http://www.ideaimpl.com)
 * 
 */

public interface Stage {

    /**
     * executes the work to be performed. The input will be read from the
     * context The output will be stored in the context
     * 
     * @param context
     *            - context object which keeps shared state
     * 
     * */
    public void execute(PipelineContext context);
}
