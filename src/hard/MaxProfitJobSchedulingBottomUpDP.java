package hard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MaxProfitJobSchedulingBottomUpDP {
	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		// prepare intervals.
		List<JobInterval> intervals = new ArrayList<>();
		for (int i = 0; i < startTime.length; i++) {
			intervals.add(new JobInterval(startTime[i], endTime[i], profit[i]));
		}
		
		// sort by start time.
		intervals.sort(Comparator.comparingInt(JobInterval::getStart));
		for (int i = 0; i < intervals.size(); i++) {
			startTime[i] = intervals.get(i).getStart();
		}
		
		// builds profit bottom up, starting from the last job.
		return getMaxProfitDP(intervals, startTime);
	}

	private int getMaxProfitDP(List<JobInterval> intervals, int[] startTime) {
		int size = intervals.size();
		// initialize result array.
		int[] result = new int[size];
		// last element max is the result including the profit of the last job.
		result[size - 1] = intervals.get(size - 1).getProfit();
		for (int i = size - 2; i >= 0; i--) {
			JobInterval jobInterval = intervals.get(i);
			int end = jobInterval.getEnd();
			// get the index of the next earliest job that does not overlap.
			int earliestNextJob = getEarliestNextJob(startTime, end);
			int maxWithJob = jobInterval.getProfit();
			if (earliestNextJob != size) {
				maxWithJob += result[earliestNextJob];
			}
			// We might be able to get higher profit without the current job also, hence take Max of with & without.
			result[i] = Math.max(maxWithJob, result[i+1]);
		}
		return result[0];
	}

	private int getEarliestNextJob(int[] startTime, int end) {
		// returns the index of the earliest job that can be started on or after `end`
		int low = 0, high = startTime.length - 1;
		int earliest = startTime.length;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (startTime[mid] < end) {
				low = mid + 1;
			} else {
				earliest = mid;
				high = mid - 1;
			}
		}
		return earliest;
	}

	public static void main(String[] args) {
		MaxProfitJobSchedulingBottomUpDP maxProfitJobScheduling = new MaxProfitJobSchedulingBottomUpDP();
		System.out.println(maxProfitJobScheduling.jobScheduling(new int[]{1,1,1}, new int[]{2,3,4}, new int[]{5,6,4}));
	}
}
