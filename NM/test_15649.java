package NM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//n �߿��� m�� �ߺ����� ���ϱ�
public class test_15649 {
	//c�� idx �� false(���� �ȵ�) �Ǿ��ִ� �͵��� a�� �������.
	static boolean[] c = new boolean[10];
	static int[] a = new int[10];
	static StringBuilder sb = new StringBuilder();
	
	//��� + �޼ҵ�
	static void go(int idx, int n, int m) {
		//�� �� ����(0~m-1)
		if(idx == m) {
			for(int i=0; i<m; i++) {
				sb.append(a[i]);
				if(i != m-1)
					sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		
		//main
		for(int i=1; i<=n; i++) {
			//true : �̹� ���ѰŸ� �н�
			if(c[i])
				continue;
			//false : ���� �ȵǾ��ִ� -> �־����
			c[i] = true;
			a[idx] = i;
			go(idx+1, n, m);
			//�������� -> �ٽ� false�� �ʱ�ȭ
			c[i] = false;
		}
	}
	
	//����
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		go(0, n, m);
		System.out.println(sb.toString());
	}
}