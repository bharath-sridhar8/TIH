package hard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class JobInterval {
	private int start;
	private int end;
	private int profit;

	@Override
	public String toString() {
		return "JobInterval{" +
				"start=" + start +
				", end=" + end +
				", profit=" + profit +
				'}';
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public int getProfit() {
		return profit;
	}

	public JobInterval(int start, int end, int profit) {
		this.start = start;
		this.end = end;
		this.profit = profit;
	}
}

public class MaxProfitJobScheduling {
	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		// create interval objects, sort by startTime.
		// we'll have to to look at all possible combinations - backtracking
		// init result = [], profit = [0], i = 0, call check(intervals, 0, result, profit)
		// for (int i = 0; i < intervals.length; i ++)
		// if result.isEmpty() || intervals.get(i) does not overlap with result.top()
		// add intervals.get(i) to result, set profit[0] += intervals.get(i).getProfit();
		// check(intervals, i+1, result, profit)

		List<JobInterval> intervals = new ArrayList<>();
		
		for (int i = 0; i < startTime.length; i++) {
			intervals.add(new JobInterval(startTime[i], endTime[i], profit[i]));
		}
		
		intervals.sort(Comparator.comparingInt(JobInterval::getStart));
		
		List<Integer> maxProfit = new ArrayList<>();
		maxProfit.add(0);

		LinkedList<JobInterval> resultJobs = new LinkedList<>();
		
		checkCombinations(intervals, 0, maxProfit, resultJobs, 0);
		return maxProfit.get(0);
	}

	private void checkCombinations(List<JobInterval> intervals, int i, List<Integer> maxProfit, 
			LinkedList<JobInterval> resultJobs, int runningProfit) {
//		System.out.println(i);
		for (int i1 = i; i1 < intervals.size(); i1++) {
//			System.out.println(i1);
			JobInterval lastAddedInterval = resultJobs.peekLast();
			if (lastAddedInterval == null || lastAddedInterval.getEnd() <= intervals.get(i1).getStart()) {
				resultJobs.addLast(intervals.get(i1));
				runningProfit += intervals.get(i1).getProfit();
				checkCombinations(intervals, i1 + 1, maxProfit, resultJobs, runningProfit);
				resultJobs.removeLast();
				runningProfit -= intervals.get(i1).getProfit();
			}
		}
//		System.out.println("Out of loop at " + i);
//		System.out.println(resultJobs);
		if (maxProfit.get(0) < runningProfit)
			maxProfit.set(0, runningProfit);
	}

	public static void main(String[] args) {
		MaxProfitJobScheduling maxProfitJobScheduling = new MaxProfitJobScheduling();
		System.out.println(maxProfitJobScheduling.jobScheduling(new int[]{1,3,5}, new int[]{2,4,6}, new int[]{20,40,60}));
	}
}
