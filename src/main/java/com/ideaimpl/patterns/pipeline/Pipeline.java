package com.ideaimpl.patterns.pipeline;

/**
 * Pipeline holds a number of stages which will be executed.
 * 
 * @author Benoy Antony (benoy@ideaimpl.com) (http://www.ideaimpl.com)
 * 
 *         Modified by Siddhu Warrier (siddhu.warrier@cloudreach.co.uk)
 *         (http://www.cloudreach.co.uk)
 */
public interface Pipeline extends Stage {

    /**
     * appends a stage to the pipeline
     * 
     * @param stage
     */
    public void addStage(Stage stage);

    /**
     * adds a stage to the error handling sequence of stages
     * 
     * @param stage
     */
    public void addErrorStage(Stage stage);

    /**
     * adds a stage to the "final" sequence of stages The final sequence of
     * stages will be executed even if there is any error
     * 
     * @param stage
     */
    public void addFinalStage(Stage stage);

    public void cancelExecution();

    public boolean isCancelled();

    public boolean isFinished();
}
