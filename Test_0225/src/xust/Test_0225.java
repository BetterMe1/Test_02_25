package xust;

/*
824. ɽ��������
����һ���ɿո�ָ�ʵľ��� S��ÿ������ֻ������д��Сд��ĸ��
����Ҫ������ת��Ϊ ��Goat Latin����һ�������� �������� - Pig Latin ���鹹���ԣ���

ɽ�������ĵĹ������£�
���������Ԫ����ͷ��a, e, i, o, u�����ڵ��ʺ����"ma"��
���磬����"apple"��Ϊ"applema"��
��������Ը�����ĸ��ͷ������Ԫ����ĸ�����Ƴ���һ���ַ��������ŵ�ĩβ��֮�������"ma"��
���磬����"goat"��Ϊ"oatgma"��
���ݵ����ھ����е��������ڵ�����������������ͬ��������ĸ'a'��������1��ʼ��
���磬�ڵ�һ�����ʺ����"a"���ڵڶ������ʺ����"aa"���Դ����ơ�
���ؽ� S ת��Ϊɽ�������ĺ�ľ��ӡ�

ʾ�� 1:
����: "I speak Goat Latin"
���: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
ʾ�� 2:
����: "The quick brown fox jumped over the lazy dog"
���: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
˵��:

S �н�������Сд��ĸ�Ϳո񡣵��ʼ����ҽ���һ���ո�
1 <= S.length <= 150��
 */
/*
 * ������
 * ���ַ���S�Կո�ָ�ָ����ַ�����������ArrayS�У���ʼ��Ϊ"",forѭ���߳�ʼ���ߴ��룩�� res�������������ַ�������ʼΪ "",��������ArrayS��
 * ÿ����һ�����ʣ��жϵ����Ƿ���Ԫ����ͷ�����ǣ���������������ĸɾ���ӵ����temp��˴�ĩβ�ӵ�"a"(��ʼΪ"a"������������һ��tempҲ���һ��"a"),
 * Ȼ���������ʺ����"ma"��temp,�޸���ϣ������ʺͿո�ӵ�res���棬���һ�����ʲ��ӿո񣬷���res��
 */
//public class Test_0225 {
//	public static void main(String[] args) {
//		Solution So = new Solution();
//		String S = "I speak Goat Latin";
//		System.out.println(So.toGoatLatin(S));
//	}
//}
//class Solution {
//    public String toGoatLatin(String S) {
//    	//����ArrayS��S�Կո�ָ��ĵ���
//        String[] ArrayS =  new String[S.length()];
//        int index_ArrayS=0;//ArrayS���������ʱΪ���ʸ���
//        ArrayS[0] = "";
//        String res = "";
//        for(int i=0; i<S.length(); i++){
//        	if(S.charAt(i) != ' ')
//        		ArrayS[index_ArrayS] = ArrayS[index_ArrayS] + String.valueOf(S.charAt(i));
//        	else{
//        		index_ArrayS++;
//        		ArrayS[index_ArrayS] = "";
//        	}
//        }
//        String temp = "a";
//        for(int j=0; j<=index_ArrayS; j++){
//        	//����ĸ�Ǹ���ʱ������ĸɾ���ӵ����
//        	if(ArrayS[j].charAt(0)!='a' && ArrayS[j].charAt(0)!='e' && ArrayS[j].charAt(0)!='i' &&
//        		ArrayS[j].charAt(0)!='o' && ArrayS[j].charAt(0)!='u' && ArrayS[j].charAt(0)!='A'&& 
//        		ArrayS[j].charAt(0)!='E' && ArrayS[j].charAt(0)!='I' && ArrayS[j].charAt(0)!='O' && 
//        		ArrayS[j].charAt(0)!='U')
//        		ArrayS[j] = ArrayS[j].substring(1) + String.valueOf(ArrayS[j].charAt(0));        	
//        	ArrayS[j] = ArrayS[j] + "ma" + temp;
//        	temp += "a"; 
//        	if(j != index_ArrayS)
//        		res = res + ArrayS[j] +" ";
//        	else
//        		res = res + ArrayS[j];        	
//        }
//        return res;
//    }
//}
/*
832. ��תͼ��
����һ�������ƾ��� A����������ˮƽ��תͼ��Ȼ��תͼ�񲢷��ؽ����
ˮƽ��תͼƬ���ǽ�ͼƬ��ÿһ�ж����з�ת�����������磬ˮƽ��ת [1, 1, 0] �Ľ���� [0, 1, 1]��
��תͼƬ����˼��ͼƬ�е� 0 ȫ���� 1 �滻�� 1 ȫ���� 0 �滻�����磬��ת [0, 1, 1] �Ľ���� [1, 0, 0]��

ʾ�� 1:
����: [[1,1,0],[1,0,1],[0,0,0]]
���: [[1,0,0],[0,1,0],[1,1,1]]
����: ���ȷ�תÿһ��: [[0,1,1],[1,0,1],[0,0,0]]��
     Ȼ��תͼƬ: [[1,0,0],[0,1,0],[1,1,1]]
ʾ�� 2:
����: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
���: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
����: ���ȷ�תÿһ��: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]��
     Ȼ��תͼƬ: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
˵��:
1 <= A.length = A[0].length <= 20
0 <= A[i][j] <= 1
 */
/*
 * ������
 * ��������A��ÿһ�У���תÿһ�е����ݣ����ڷ�ת�����н��з�ת����0��Ϊ1,1��Ϊ0�����ڷ�תʱ���п��ܱ����������м������
 * ���ÿ�����֮���жϱ�����������*2�Ƿ����A.length���������ڣ��ٽ����м������ת��
 */
public class Test_0225 {
	public static void main(String[] args) {
		Solution So = new Solution();
		int[][] A ={{1,1,0},{1,0,1},{0,0,0}};
		int[][]res = So.flipAndInvertImage(A);
		for(int i=0; i<res.length; i++){
			for(int j=0; j<res[i].length;j++){
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}
}
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int i=0; i<A.length; i++){
        	int j=0;
        	for(; j<A.length/2; j++){
        		if(A[i][j] != A[i][A.length-1-j]){
        			int temp = A[i][j];
        			A[i][j] = A[i][A.length-1-j];
        			A[i][A.length-1-j] = temp;
        		}
        		A[i][j] = A[i][j] ^ 1;
        		A[i][A.length-1-j] = A[i][A.length-1-j]^ 1;
        	}
        	if(j*2 != A.length)
        		A[i][j] = A[i][j] ^ 1;
        }
       return A; 
    }
}
