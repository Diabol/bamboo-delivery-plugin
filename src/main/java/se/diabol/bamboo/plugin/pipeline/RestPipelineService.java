package se.diabol.bamboo.plugin.pipeline;


import com.atlassian.bamboo.build.Job;
import com.atlassian.bamboo.chains.ChainStage;
import com.atlassian.bamboo.plan.ExecutionStatus;
import com.atlassian.bamboo.plan.PlanExecutionManager;
import com.atlassian.bamboo.plan.PlanManager;
import com.atlassian.bamboo.plan.TopLevelPlan;
import com.atlassian.bamboo.project.Project;
import com.atlassian.bamboo.resultsummary.ResultsSummary;
import com.atlassian.bamboo.resultsummary.ResultsSummaryManager;
import se.diabol.bamboo.plugin.pipeline.model.Pipeline;
import se.diabol.bamboo.plugin.pipeline.model.Stage;
import se.diabol.bamboo.plugin.pipeline.model.Task;
import se.diabol.bamboo.plugin.pipeline.model.status.StatusFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("/")
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class RestPipelineService {

    private PlanManager planManager;
    private PlanExecutionManager executionManager;
    private ResultsSummaryManager resultsSummaryManager;

    public RestPipelineService(PlanManager planManager, PlanExecutionManager executionManager, ResultsSummaryManager resultsSummaryManager) {
        this.planManager = planManager;
        this.executionManager = executionManager;
        this.resultsSummaryManager = resultsSummaryManager;
    }

    @GET
    @Path("pipelines")
    public Response getPipelines() {
        List<TopLevelPlan> plans = planManager.getAllPlans(TopLevelPlan.class);
        //planManager.

        List<Pipeline> pipelines = new ArrayList<Pipeline>();

        for (TopLevelPlan plan : plans) {
            List<Stage> stages = new ArrayList<Stage>();


            Collection<? extends ExecutionStatus> statuses = executionManager.getExecutionStatus(plan.getPlanKey());

            List<ResultsSummary> results = resultsSummaryManager.getResultSummariesForPlan(plan, 0, 0);

            //resultsSummaryManager.getStageForResult()

            Project project = plan.getProject();

            List<ChainStage> bambooStages = plan.getStages();

            for (ChainStage chainStage : bambooStages) {
                //chainStage.
                Set<Job> jobs = chainStage.getJobs();
                List<Task> tasks = new ArrayList<Task>();
                for (Job job : jobs) {
                    //executionManager.getJobExecution(job.get);
                    tasks.add(new Task(String.valueOf(job.getId()), job.getBuildName(), null, StatusFactory.idle(), null, false, null));

                }


                stages.add(new Stage(chainStage.getName(), tasks));
            }

            pipelines.add(new Pipeline(project.getName(), null, null, null, stages, false));

        }
        GenericEntity<List<Pipeline>> entity = new GenericEntity<List<Pipeline>>(pipelines) {};
        return Response.ok(entity).build();
    }

}
