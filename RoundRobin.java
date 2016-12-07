import java.util.ArrayList;
import java.util.List;

public class RoundRobin {
	static int CPUTime=0;
	static List<Integer> runningTime;
	public RoundRobin(final List<Integer> runningTime, int CPUTimeSlice,final List<String> jobNames) {
		List<Integer> runningTimeOfJobs = new ArrayList<Integer>(runningTime);
		List<String> jobStarted = new ArrayList<String>();
		List<Integer> jobStartTime = new ArrayList<Integer>();
		List<Integer> jobResponseTime = new ArrayList<Integer>();
		List<String> jobName = new ArrayList<String>(jobNames);
		int i =0;
		int size = runningTimeOfJobs.size();
		while(runningTimeOfJobs.size()!=0)
		{
			
			if(size!=runningTimeOfJobs.size())
			{
				i--;
				size=runningTimeOfJobs.size();
			}
			if(i>runningTimeOfJobs.size()-1)
			{
				i=0;
			}
			if(runningTimeOfJobs.get(i)>CPUTimeSlice)
			{
				if(!jobStarted.contains(jobNames.get(i)))
				{
				jobStarted.add(jobNames.get(i));
				System.out.println("started job "+jobNames.get(i)+" at "+CPUTime);
				jobStartTime.add(CPUTime);
				}
				CPUTime = CPUTime+CPUTimeSlice;
				runningTimeOfJobs.set(i,runningTimeOfJobs.get(i)-CPUTimeSlice);
			}
			else
			{
				CPUTime = CPUTime+runningTimeOfJobs.get(i);
				runningTimeOfJobs.remove(i);
				System.out.println("Finished Job "+jobName.get(i)+" at CPU Time "+CPUTime+" using RR");
				if(jobStartTime.isEmpty())
				{
					jobStartTime.add(0);
				}
				jobResponseTime.add(CPUTime-jobStartTime.get(i));
				jobStartTime.remove(i);
				jobName.remove(i);
			}
			i++;
		}
		int averageResponseTime=0;
		for(int l =0;l<jobResponseTime.size();l++)
		{
			averageResponseTime=averageResponseTime+jobResponseTime.get(l);
		}
		averageResponseTime=averageResponseTime/jobResponseTime.size();
		System.out.println(averageResponseTime);
	}

}
