package test8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] id = new int[2000006];
	static int[] sorted = new int[2000006];

	static class InputReader {
	    public BufferedReader br;
	    public StringTokenizer tokenizer;
	    public InputReader(InputStream stream) throws FileNotFoundException {
	        br = new BufferedReader(new InputStreamReader(stream), 327680);
	        tokenizer = null;
	    }
	    public String next() {
	        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
	            try {
	                tokenizer = new StringTokenizer(br.readLine());
	            } catch (IOException e) {
	                throw new RuntimeException(e);
	            }
	        }
	        return tokenizer.nextToken();
	    }
	    public int nextInt() {
	        try {
	            int c = br.read();
	            while (c <= 32) {
	                c = br.read();
	            }
	            boolean negative = false;
	            if (c == '-') {
	                negative = true;
	                c = br.read();
	            }
	            int x = 0;
	            while (c > 32) {
	                x = x * 10 + c - '0';
	                c = br.read();
	            }
	            return negative ? -x : x;
	        }catch(IOException e){
	            return  -1;
	        }
	    }
	    public long nextLong() {
	        try {
	            int c = br.read();
	            while (c <= 32) {
	                c = br.read();
	            }
	            boolean negative = false;
	            if (c == '-') {
	                negative = true;
	                c = br.read();
	            }
	            long x = 0;
	            while (c > 32) {
	                x = x * 10 + c - '0';
	                c = br.read();
	            }
	            return negative ? -x : x;
	        }catch(IOException e){
	            return  -1;
	        }
	    }
	}

	static InputReader input;
	static int ans = 0;
	public static void main(String[] args) throws FileNotFoundException {
		init();
		ans = solve(1, n);
		System.out.println(ans);
	}

	public static void init() throws FileNotFoundException {
		input = new InputReader(System.in);
		n = input.nextInt();
		for (int i = 1; i <= n; i++) {
			id[i] = input.nextInt();
		}
	}

	public static int solve(int l, int r) {
		if (l == r) {
			return 0;
		} else {
			return ((solve(l, (l + r) / 2) + solve((l + r) / 2 + 1, r)) % 1000000007
					+ merge(l, r)) % 1000000007;
		}
	}
	static int mid = 0;
	static int cnt = 0;
	static int i = 0;
	static int j = 0;
	static int pos = 0;
	public static int merge(int l, int r) {
		mid = (l + r) / 2;
		cnt = 0;
		i = l;
		j = mid + 1;
		pos = 0;
		while (i <= mid && j <= r) {
			if (id[i] > id[j]) {
				cnt += (mid - i + 1);
				cnt %= 1000000007;
				sorted[pos++] = id[j];
				j++;
			} else {
				sorted[pos++] = id[i];
				i++;
			}
		}
		while (i <= mid) {
			sorted[pos++] = id[i];
			i++;
		}
		while (j <= r) {
			sorted[pos++] = id[j];
			j++;
		}
		for (int k = 0; k < (r - l) + 1; k++) {
			id[k + l] = sorted[k];
		}
		return cnt;
	}
}

