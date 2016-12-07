import java.util.ArrayList;
import java.util.List;

public class MLFQ {
	static int CPUTime = 0;
	List<Integer> runningTime;

	MLFQ(List<Integer> runningTimeOfJobs, int CPUTimeSlice, List<String> jobNames, int priority) {
		List<Integer> priorityList = new ArrayList<Integer>();
		List<String> jobStarted = new ArrayList<String>();
		List<Integer> jobStartTime = new ArrayList<Integer>();
		List<Integer> jobResponseTime = new ArrayList<Integer>();
		for (int i = 0; i < runningTimeOfJobs.size(); i++) {
			priorityList.add(i);
		}
		runningTime = runningTimeOfJobs;
		int i = 0;
		int size = runningTime.size();
		while (runningTime.size() != 0) {

			if (size != runningTime.size()) {
				i--;
				size = runningTime.size();
			}
			if (i > runningTime.size() - 1) {
				i = 0;
			}
			if ((CPUTime % priority == 0)&&(jobStarted.size()==jobNames.size())) {
				int index = 0;
				int small = priorityList.get(0);
				for (int k = 0; k < priorityList.size(); k++) {
					if (priorityList.get(k) < small) {
						small = priorityList.get(k);
						index = k;
					}

				}
				i = index;

			}
			if (runningTime.get(i) > CPUTimeSlice) {
				if(!jobStarted.contains(jobNames.get(i)))
				{
				jobStarted.add(jobNames.get(i));
				System.out.println("started job "+jobNames.get(i)+" at "+CPUTime);
				jobStartTime.add(CPUTime);
				}
				CPUTime = CPUTime + CPUTimeSlice;
				runningTime.set(i, runningTime.get(i) - CPUTimeSlice);
				for (int j = 0; j < priorityList.size(); j++) {
					priorityList.set(j, priorityList.get(j) - 1);
				}
				//System.out.println("running job "+jobNames.get(i));
				//System.out.println(priorityList);

			} else {
				CPUTime = CPUTime + CPUTimeSlice;
				runningTime.remove(i);
				System.out.println("Finished Job " + jobNames.get(i) + " at CPU Time " + CPUTime + " using MLFQ");
				if(jobStartTime.isEmpty())
				{
					jobStartTime.add(0);
				}
				jobResponseTime.add(CPUTime-jobStartTime.get(i));
				jobStartTime.remove(i);
				//System.out.println(jobResponseTime);
				jobStarted.remove(jobNames.get(i));
				jobNames.remove(i);
				priorityList.remove(i);
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
