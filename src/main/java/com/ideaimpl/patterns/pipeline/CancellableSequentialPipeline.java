package com.ideaimpl.patterns.pipeline;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The sequential pipeline executes the stage sequence imitating a try catch
 * finally block. try { execute stages } catch (any error){ execute error stages
 * } finally { execute finally stages }
 * 
 * Please note that
 * 
 * @author Siddhu Warrier (siddhu.warrier@cloudreach.co.uk
 *         (http://www.cloudreach.co.uk) (modified original code by Benoy Antony
 *         (benoy@ideaimpl.com)(http://www.ideaimpl.com))
 * 
 * 
 */
public class CancellableSequentialPipeline implements Pipeline {

    private List<Stage> stages = new ArrayList<Stage>();
    private List<Stage> errorStages = new ArrayList<Stage>();
    private List<Stage> finalStages = new ArrayList<Stage>();
    private PipelineContext context;

    private volatile boolean isCancelled;

    private volatile boolean isFinished;

    private ExecutorService executor;

    private final static int NUM_PARALLEL_THREADS = 1;

    @Override
    public void addStage(Stage stage) {
        stages.add(stage);

    }

    @Override
    public void addErrorStage(Stage stage) {
        errorStages.add(stage);
    }

    @Override
    public void addFinalStage(Stage stage) {
        finalStages.add(stage);

    }

    @Override
    public void execute(PipelineContext context) {
        this.context = context;
        executor = Executors.newFixedThreadPool(NUM_PARALLEL_THREADS);
        executor.execute(new SequentialPipelineRunner());
    }

    @Override
    public void cancelExecution() {
        if (executor != null) {
            isCancelled = true;
            executor.shutdownNow();
        }
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }

    public class SequentialPipelineRunner implements Runnable {

        @Override
        public void run() {
            executeSequentialPipeline();
        }

        public void executeSequentialPipeline() {
            isFinished = false;
            /* execute the stages */
            for (Stage stage : stages) {

                stage.execute(context);

                if (isCancelled || (context.getErrors() != null && !context.getErrors().isEmpty())) {
                    break;
                }

            }

            if (!isCancelled) {
                /* if any error occurred, execute the error stages */
                if (context.getErrors() != null && !context.getErrors().isEmpty()) {
                    for (Stage errorStage : errorStages) {
                        errorStage.execute(context);
                    }
                }

                // execute the final stages
                for (Stage finalStage : finalStages) {
                    finalStage.execute(context);
                }
            }

            CancellableSequentialPipeline.this.isFinished = true;
            synchronized (CancellableSequentialPipeline.this) {
                // notify all waiting threads
                CancellableSequentialPipeline.this.notifyAll();
            }
        }

    }

}
