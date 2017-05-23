import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("beans.xml");

        RepositoryService repositoryService = (RepositoryService)
                applicationContext.getBean("repositoryService");
        String deploymentId = repositoryService .createDeployment()
                .addClasspathResource("process.bpmn20.xml")
                .deploy().getId();

        // Start process
        RuntimeService runtimeService = (RuntimeService) applicationContext.
                getBean("runtimeService");
        runtimeService.startProcessInstanceByKey("process");
        /*RuntimeService runtimeService = (RuntimeService) applicationContext.
                getBean("runtimeService");
        runtimeService.startProcessInstanceByKey(deploymentId);*/
    }
}
