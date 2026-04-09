import java.nio.file.*;
import java.time.Instant;
import java.util.*;

public class CyclingAnalysis {

    // Garmin timestamp offset
    static final long OFFSET = 631065600L;

    // -----------------------------
    // TrackPoint Class
    // -----------------------------
    static class TrackPoint {
        long timestamp;
        double speed;
        int power;
        double distance;

        TrackPoint(long t, double s, int p, double d) {
            timestamp = t;
            speed = s;
            power = p;
            distance = d;
        }

        String getTime() {
            return Instant.ofEpochSecond(timestamp + OFFSET).toString();
        }
    }

    // -----------------------------
    // MAIN METHOD
    // -----------------------------
    public static void main(String[] args) throws Exception {

        // Load ALL files
        String[] files = {"day1.json", "day2.json", "day3.json", "day4.json"};

        List<TrackPoint> allPoints = new ArrayList<>();

        for (String file : files) {
            String content = Files.readString(Paths.get(file));
            allPoints.addAll(parse(content));
        }

        System.out.println("Total records loaded: " + allPoints.size());

        // -----------------------------
        // PROBLEM 1: MERGE SORT (POWER)
        // -----------------------------
        mergeSort(allPoints);

        System.out.println("\nTop 10 Highest Power Outputs:");
        for (int i = 0; i < 10; i++) {
            TrackPoint p = allPoints.get(i);
            System.out.println((i + 1) + ". Time: " + p.getTime()
                    + " | Power: " + p.power
                    + "W | Speed: " + p.speed + " m/s");
        }

        // -----------------------------
        // PROBLEM 2: BINARY SEARCH (SPEED)
        // -----------------------------
        double targetSpeed = 8.0;

        // Sort by speed for binary search
        mergeSortBySpeed(allPoints);

        int index = binarySearchFirstAbove(allPoints, targetSpeed);

        System.out.println("\nTimes where speed > " + targetSpeed + " m/s:");

        if (index == -1) {
            System.out.println("No records found.");
        } else {
            for (int i = index; i < allPoints.size(); i++) {
                TrackPoint p = allPoints.get(i);
                System.out.println(p.getTime() + " | Speed: " + p.speed);
            }
        }
    }

    // -----------------------------
    // PARSER (TAILORED TO YOUR FILE)
    // -----------------------------
    static List<TrackPoint> parse(String content) {

        List<TrackPoint> list = new ArrayList<>();

        content = content.substring(1, content.length() - 1);

        String[] records = content.split("\\],\\[");

        for (String r : records) {
            r = r.replace("[", "").replace("]", "");

            String[] v = r.split(",");

            long timestamp = Long.parseLong(v[0].replace("\"", ""));
            double distance = Double.parseDouble(v[1].replace("\"", ""));
            double speed = Double.parseDouble(v[3].replace("\"", ""));
            int power = Integer.parseInt(v[7].replace("\"", ""));

            list.add(new TrackPoint(timestamp, speed, power, distance));
        }

        return list;
    }

    // -----------------------------
    // MERGE SORT (BY POWER DESC)
    // -----------------------------
    static void mergeSort(List<TrackPoint> list) {
        if (list.size() <= 1) return;

        int mid = list.size() / 2;

        List<TrackPoint> left = new ArrayList<>(list.subList(0, mid));
        List<TrackPoint> right = new ArrayList<>(list.subList(mid, list.size()));

        mergeSort(left);
        mergeSort(right);

        merge(list, left, right);
    }

    static void merge(List<TrackPoint> list, List<TrackPoint> left, List<TrackPoint> right) {

        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).power > right.get(j).power) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            list.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            list.set(k++, right.get(j++));
        }
    }

    // -----------------------------
    // MERGE SORT (BY SPEED ASC)
    // -----------------------------
    static void mergeSortBySpeed(List<TrackPoint> list) {
        if (list.size() <= 1) return;

        int mid = list.size() / 2;

        List<TrackPoint> left = new ArrayList<>(list.subList(0, mid));
        List<TrackPoint> right = new ArrayList<>(list.subList(mid, list.size()));

        mergeSortBySpeed(left);
        mergeSortBySpeed(right);

        mergeSpeed(list, left, right);
    }

    static void mergeSpeed(List<TrackPoint> list, List<TrackPoint> left, List<TrackPoint> right) {

        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).speed < right.get(j).speed) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            list.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            list.set(k++, right.get(j++));
        }
    }

    // -----------------------------
    // BINARY SEARCH
    // -----------------------------
    static int binarySearchFirstAbove(List<TrackPoint> list, double target) {

        int left = 0;
        int right = list.size() - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (list.get(mid).speed > target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}