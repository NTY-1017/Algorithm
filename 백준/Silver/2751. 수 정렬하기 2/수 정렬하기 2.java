import java.io.*;

public class Main {
    /**
     * 시간 복잡도가 O(nlogn)인 정렬 알고리즘으로 풀 수 있는 문제
     * 병합 정렬, 힙 정렬 , 내장 정렬 함수 등 가능
     * 병합 정렬(Merge Sort)로 풀이 진행
     */
    private static int[] sorted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());    // 입력하는 N개의 수

        int[] array = new int[N];   // N개의 수 담을 배열

        sorted = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine()); // 배열에 저장
        }

        /**
         * 병합 정렬(Merge Sort) 사용
         * Top-Down(재귀) / Bottom-Up(반복) 중 Bottom-Up 형식 사용 -> 정렬하는데 되도록이면 재귀는 피하는게 좋다고 한다
         * 1 -> 2 -> 4 -> 8 -> ... 1부터 배열을 나누는 길이 두 배씩 증가시킴
         */
        for (int length = 1; length <= array.length - 1; length += length) {
            // 부분 배열 2개를 순서대로 병합
            for (int left = 0; left <= (array.length - 1) -length; left += (2 * length)) {
                int low = left;
                int mid = left + length - 1;
                int high = Math.min(left + (2 * length) - 1, array.length - 1); // high값이 배열의 끝 인덱스를 넘어가는 상황 대비 둘 중 작은 값으로 대입
                merge_sort(array, low, mid, high);
            }
        }

        for (int i : array) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }

    /**
     * 부분 병합 정렬
     * @param array: 병합 정렬 하고자 하는 배열
     * @param left: 배열 시작 인덱스
     * @param mid: 배열 중간 인덱스
     * @param right: 배열 끝 인덱스
     */
    private static void merge_sort(int[] array, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int index = left;

        while (l <= mid && r <= right) {
            if (array[l] <= array[r]) {
                sorted[index] = array[l];
                index++;
                l++;
            }

            else {
                sorted[index] = array[r];
                index++;
                r++;
            }
        }

        if(l > mid) {
            while (r <= right) {
                sorted[index] = array[r];
                index++;
                r++;
            }
        }

        else {
            while (l <= mid) {
                sorted[index] = array[l];
                index++;
                l++;
            }
        }

        for (int i = left; i <= right; i++) {
            array[i] = sorted[i];
        }
    }
}