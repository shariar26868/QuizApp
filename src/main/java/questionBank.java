import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class questionBank {
    public static void main(String[] args) throws IOException {
        JSONArray questionsArray = new JSONArray();

        // Define 20 questions in the JSON format
        JSONObject question1 = new JSONObject();
        question1.put("answerkey", 4);
        question1.put("option 1", "Regression Testing");
        question1.put("option 2", "Sanity Testing");
        question1.put("option 3", "Load Testing");
        question1.put("option 4", "Unit Testing");
        question1.put("question", "Which is not part of system testing?");
        questionsArray.add(question1);

        JSONObject question2 = new JSONObject();
        question2.put("answerkey", 3);
        question2.put("option 1", "Equivalent Partitioning");
        question2.put("option 2", "Boundary value testing");
        question2.put("option 3", "Decision table testing");
        question2.put("option 4", "Adhoc Testing");
        question2.put("question", "Which is whitebox testing technique?");
        questionsArray.add(question2);

        JSONObject question3 = new JSONObject();
        question3.put("answerkey", 1);
        question3.put("option 1", "Unit Testing");
        question3.put("option 2", "Integration Testing");
        question3.put("option 3", "Sanity Testing");
        question3.put("option 4", "Regression Testing");
        question3.put("question", "Which testing is done by developer?");
        questionsArray.add(question3);

        JSONObject question4 = new JSONObject();
        question4.put("answerkey", 3);
        question4.put("option 1", "Load Testing");
        question4.put("option 2", "Security Testing");
        question4.put("option 3", "Gorila Testing");
        question4.put("option 4", "Benchmark Testing");
        question4.put("question", "Which is functional testing?");
        questionsArray.add(question4);

        JSONObject question5 = new JSONObject();
        question5.put("answerkey", 2);
        question5.put("option 1", "Walkthrough");
        question5.put("option 2", "Exploratory Testing");
        question5.put("option 3", "Peer review");
        question5.put("option 4", "Inspection");
        question5.put("question", "Which is not static testing?");
        questionsArray.add(question5);

        JSONObject question6 = new JSONObject();
        question6.put("answerkey", 3);
        question6.put("option 1", "Fault");
        question6.put("option 2", "Bug");
        question6.put("option 3", "Failure");
        question6.put("option 4", "Defect");
        question6.put("question", "A deviation from actual result to the expected result to the end user is called?");
        questionsArray.add(question6);

        JSONObject question7 = new JSONObject();
        question7.put("answerkey", 1);
        question7.put("option 1", "Preventing defects");
        question7.put("option 2", "Repairing defects");
        question7.put("option 3", "Comparing actual results to expected results");
        question7.put("option 4", "Analyzing the cause of failure");
        question7.put("question", "Which of the following is a typical test objective?");
        questionsArray.add(question7);

        JSONObject question8 = new JSONObject();
        question8.put("answerkey", 2);
        question8.put("option 1", "The fault");
        question8.put("option 2", "The failure");
        question8.put("option 3", "The error");
        question8.put("option 4", "The defect");
        question8.put("question", "Suppose, you visit the HSC result publishing site to see the result of your younger sibling. But you see that site is down. What is the reason?");
        questionsArray.add(question8);

        JSONObject question9 = new JSONObject();
        question9.put("answerkey", 3);
        question9.put("option 1", "Error");
        question9.put("option 2", "Bug");
        question9.put("option 3", "Fault");
        question9.put("option 4", "Failure");
        question9.put("question", "What is missing requirement?");
        questionsArray.add(question9);

        JSONObject question10 = new JSONObject();
        question10.put("answerkey", 4);
        question10.put("option 1", "Equivalent partitioning");
        question10.put("option 2", "Boundary value analysis");
        question10.put("option 3", "While doing automation");
        question10.put("option 4", "Test procedure planning");
        question10.put("question", "Test data planning is included when?");
        questionsArray.add(question10);

        JSONObject question11 = new JSONObject();
        question11.put("answerkey", 3);
        question11.put("option 1", "Requirement Analysis");
        question11.put("option 2", "Assign task to QA team");
        question11.put("option 3", "Writing Testcase");
        question11.put("option 4", "Writing user manual");
        question11.put("question", "Which of the following is an example of a task that can be carried out as part of the test process?");
        questionsArray.add(question11);

        JSONObject question12 = new JSONObject();
        question12.put("answerkey", 3);
        question12.put("option 1", "Feature Test");
        question12.put("option 2", "Integration Test");
        question12.put("option 3", "Re-Test");
        question12.put("option 4", "Regression Test");
        question12.put("question", "Developer fixed an issue and told you to test the feature. What is the testing type?");
        questionsArray.add(question12);

        JSONObject question13 = new JSONObject();
        question13.put("answerkey", 1);
        question13.put("option 1", "Validation Techniques");
        question13.put("option 2", "Verification Techniques");
        question13.put("option 3", "Both of the above");
        question13.put("option 4", "None of the above");
        question13.put("question", "Dynamic testing is mainly?");
        questionsArray.add(question13);

        JSONObject question14 = new JSONObject();
        question14.put("answerkey", 3);
        question14.put("option 1", "Equivalence Partitioning");
        question14.put("option 2", "Boundary Value Testing");
        question14.put("option 3", "Branch Testing");
        question14.put("option 4", "State Transition");
        question14.put("question", "What is not the blackbox testing strategy?");
        questionsArray.add(question14);

        JSONObject question15 = new JSONObject();
        question15.put("answerkey", 2);
        question15.put("option 1", "Test planning and control");
        question15.put("option 2", "Requirement Analysis");
        question15.put("option 3", "Test implementation and execution");
        question15.put("option 4", "Evaluating exit criteria");
        question15.put("question", "Which is not in fundamental test process?");
        questionsArray.add(question15);

        JSONObject question16 = new JSONObject();
        question16.put("answerkey", 4);
        question16.put("option 1", "Test Case");
        question16.put("option 2", "Requirements Traceability Matrix [RTM]");
        question16.put("option 3", "Test strategy");
        question16.put("option 4", "Project Initiation Note [PIN]");
        question16.put("question", "Which of the following is not part of the Test document?");
        questionsArray.add(question16);

        JSONObject question17 = new JSONObject();
        question17.put("answerkey", 4);
        question17.put("option 1", "System Testing");
        question17.put("option 2", "Integration testing");
        question17.put("option 3", "Component testing");
        question17.put("option 4", "Maintenance testing");
        question17.put("question", "The _______ testing should include operational tests of the new environment as well as of the changed software.");
        questionsArray.add(question17);

        JSONObject question18 = new JSONObject();
        question18.put("answerkey", 3);
        question18.put("option 1", "5");
        question18.put("option 2", "6");
        question18.put("option 3", "7");
        question18.put("option 4", "8");
        question18.put("question", "How many Principles are there in Software Testing?");
        questionsArray.add(question18);

        JSONObject question19 = new JSONObject();
        question19.put("answerkey", 4);
        question19.put("option 1", "Rework");
        question19.put("option 2", "Repair");
        question19.put("option 3", "Failure mode analysis");
        question19.put("option 4", "None of the mentioned");
        question19.put("question", "Which of the following is not included in failure costs?");
        questionsArray.add(question19);

        JSONObject question20 = new JSONObject();
        question20.put("answerkey", 2);
        question20.put("option 1", "Hardware");
        question20.put("option 2", "Software");
        question20.put("option 3", "Project plan");
        question20.put("option 4", "Database");
        question20.put("question", "Configuration Management is about managing the ________ of a system.");
        questionsArray.add(question20);


        FileWriter file = new FileWriter("./src/main/resources/quiz.json");
        file.write(questionsArray.toJSONString());
        file.flush();
        file.close();
        System.out.println("SQA Question is ready");
    }

}
