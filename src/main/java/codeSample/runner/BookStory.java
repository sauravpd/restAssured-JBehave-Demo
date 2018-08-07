package codeSample.runner;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;

import codeSample.steps.BookApiSteps;

public class BookStory extends JUnitStories
{
	public BookStory() 
	{
		super();
		this.configuredEmbedder().candidateSteps().add(new BookApiSteps());
	}
	
	@Override
	public List<CandidateSteps> candidateSteps()
	{
		return new InstanceStepsFactory(configuration(),this).createCandidateSteps();
	}
	
	@Override
	protected List<String> storyPaths() {
	
		return Arrays.asList("codeSample/story/getBookDetails.story");
	}

}
