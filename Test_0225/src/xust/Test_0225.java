package xust;

/*
824. 山羊拉丁文
给定一个由空格分割单词的句子 S。每个单词只包含大写或小写字母。
我们要将句子转换为 “Goat Latin”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。

山羊拉丁文的规则如下：
如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。
例如，单词"apple"变为"applema"。
如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
例如，单词"goat"变为"oatgma"。
根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。
例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。
返回将 S 转换为山羊拉丁文后的句子。

示例 1:
输入: "I speak Goat Latin"
输出: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
示例 2:
输入: "The quick brown fox jumped over the lazy dog"
输出: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
说明:

S 中仅包含大小写字母和空格。单词间有且仅有一个空格。
1 <= S.length <= 150。
 */
/*
 * 分析：
 * 将字符串S以空格分割，分割后的字符串存入数组ArrayS中（初始化为"",for循环边初始化边存入）， res用来返回最后的字符串，初始为 "",遍历数组ArrayS，
 * 每遍历一个单词，判断单词是否以元音开头，不是（即辅音）则将首字母删掉加到最后，temp存此次末尾加的"a"(初始为"a"，随着索引加一，temp也多加一个"a"),
 * 然后给这个单词后加上"ma"和temp,修改完毕，将单词和空格加到res后面，最后一个单词不加空格，返回res。
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
//    	//数组ArrayS存S以空格分割后的单词
//        String[] ArrayS =  new String[S.length()];
//        int index_ArrayS=0;//ArrayS索引，最大时为单词个数
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
//        	//首字母是辅音时将首字母删掉加到最后
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
832. 翻转图像
给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。

示例 1:
输入: [[1,1,0],[1,0,1],[0,0,0]]
输出: [[1,0,0],[0,1,0],[1,1,1]]
解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
     然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
示例 2:
输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
输出: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
解释: 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
     然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
说明:
1 <= A.length = A[0].length <= 20
0 <= A[i][j] <= 1
 */
/*
 * 分析：
 * 遍历矩阵A的每一行，翻转每一行的数据，并在翻转过程中进行反转，将0改为1,1改为0，由于翻转时很有可能遍历不到最中间的数，
 * 因此每行完毕之后判断遍历到的索引*2是否等于A.length，若不等于，再将最中间的数反转。
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
