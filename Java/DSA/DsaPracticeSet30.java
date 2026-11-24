import java.util.*;
public class DsaPracticeSet30 {
 static class ListNode{int v;ListNode n;ListNode(int x){v=x;}}
 static class TreeNode{int v;TreeNode l,r;TreeNode(int x){v=x;}}
 // 1 Kadane O(n)
 static int maxSubarray(int[]a){if(a.length==0)throw new IllegalArgumentException();int c=a[0],b=c;for(int i=1;i<a.length;i++){c=Math.max(a[i],c+a[i]);b=Math.max(b,c);}return b;}
 // 2 Rotate right O(n)
 static void rotate(int[]a,int k){if(a.length==0)return;k=Math.floorMod(k,a.length);rev(a,0,a.length-1);rev(a,0,k-1);rev(a,k,a.length-1);}
 static void rev(int[]a,int l,int r){while(l<r){int t=a[l];a[l++]=a[r];a[r--]=t;}}
 // 3 Move zeroes O(n)
 static void moveZeroes(int[]a){int w=0;for(int x:a)if(x!=0)a[w++]=x;while(w<a.length)a[w++]=0;}
 // 4 Product except self O(n)
 static long[] productExceptSelf(int[]a){long[]o=new long[a.length];long p=1;for(int i=0;i<a.length;i++){o[i]=p;p*=a[i];}long s=1;for(int i=a.length-1;i>=0;i--){o[i]*=s;s*=a[i];}return o;}
 // 5 Merge intervals O(n log n)
 static int[][] mergeIntervals(int[][]a){int[][]x=Arrays.stream(a).map(int[]::clone).toArray(int[][]::new);Arrays.sort(x,Comparator.comparingInt(v->v[0]));List<int[]>o=new ArrayList<>();for(int[]v:x){if(o.isEmpty()||v[0]>o.get(o.size()-1)[1])o.add(v);else o.get(o.size()-1)[1]=Math.max(o.get(o.size()-1)[1],v[1]);}return o.toArray(new int[0][]);}
 // 6 Anagram O(n)
 static boolean anagram(String a,String b){if(a.length()!=b.length())return false;int[]f=new int[65536];for(int i=0;i<a.length();i++){f[a.charAt(i)]++;f[b.charAt(i)]--;}for(int x:f)if(x!=0)return false;return true;}
 // 7 Longest common prefix
 static String commonPrefix(String[]a){if(a.length==0)return "";String p=a[0];for(String s:a)while(!s.startsWith(p)){if(p.isEmpty())return "";p=p.substring(0,p.length()-1);}return p;}
 // 8 Reverse words O(n)
 static String reverseWords(String s){if(s.trim().isEmpty())return "";String[]w=s.trim().split("\\s+");Collections.reverse(Arrays.asList(w));return String.join(" ",w);}
 // 9 Longest palindrome O(n^2)
 static String longestPalindrome(String s){int st=0,len=0;for(int i=0;i<s.length();i++)for(int d=0;d<2;d++){int l=i,r=i+d;while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){l--;r++;}if(r-l-1>len){st=l+1;len=r-l-1;}}return s.substring(st,st+len);}
 // 10 Two sum O(n) average
 static int[] twoSum(int[]a,int t){Map<Integer,Integer>m=new HashMap<>();for(int i=0;i<a.length;i++){if(m.containsKey(t-a[i]))return new int[]{m.get(t-a[i]),i};m.put(a[i],i);}return new int[0];}
 // 11 Group anagrams O(n*k log k)
 static List<List<String>> groupAnagrams(String[]a){Map<String,List<String>>m=new LinkedHashMap<>();for(String s:a){char[]c=s.toCharArray();Arrays.sort(c);m.computeIfAbsent(new String(c),z->new ArrayList<>()).add(s);}return new ArrayList<>(m.values());}
 // 12 Subarray sum k O(n) average
 static int subarraySum(int[]a,int k){Map<Integer,Integer>m=new HashMap<>();m.put(0,1);int s=0,c=0;for(int x:a){s+=x;c+=m.getOrDefault(s-k,0);m.put(s,m.getOrDefault(s,0)+1);}return c;}
 // 13 3Sum O(n^2)
 static List<List<Integer>> threeSum(int[]nums){int[]a=nums.clone();Arrays.sort(a);List<List<Integer>>o=new ArrayList<>();for(int i=0;i<a.length-2;i++){if(i>0&&a[i]==a[i-1])continue;int l=i+1,r=a.length-1;while(l<r){long s=(long)a[i]+a[l]+a[r];if(s==0){o.add(Arrays.asList(a[i],a[l],a[r]));int x=a[l],y=a[r];while(l<r&&a[l]==x)l++;while(l<r&&a[r]==y)r--;}else if(s<0)l++;else r--;}}return o;}
 // 14 Container water O(n)
 static int maxArea(int[]h){int l=0,r=h.length-1,b=0;while(l<r){b=Math.max(b,(r-l)*Math.min(h[l],h[r]));if(h[l]<h[r])l++;else r--;}return b;}
 // 15 Remove duplicates sorted O(n), returns logical length
 static int removeDuplicates(int[]a){if(a.length==0)return 0;int w=1;for(int r=1;r<a.length;r++)if(a[r]!=a[w-1])a[w++]=a[r];return w;}
 // 16 Longest unique substring O(n)
 static int longestUnique(String s){Map<Character,Integer>m=new HashMap<>();int l=0,b=0;for(int r=0;r<s.length();r++){if(m.containsKey(s.charAt(r)))l=Math.max(l,m.get(s.charAt(r))+1);m.put(s.charAt(r),r);b=Math.max(b,r-l+1);}return b;}
 // 17 Minimum window O(n)
 static String minWindow(String s,String t){if(t.isEmpty()||s.length()<t.length())return "";Map<Character,Integer>m=new HashMap<>();for(char c:t.toCharArray())m.put(c,m.getOrDefault(c,0)+1);int miss=t.length(),l=0,bs=0,bl=Integer.MAX_VALUE;for(int r=0;r<s.length();r++){char c=s.charAt(r);if(m.getOrDefault(c,0)>0)miss--;m.put(c,m.getOrDefault(c,0)-1);while(miss==0){if(r-l+1<bl){bs=l;bl=r-l+1;}char x=s.charAt(l++);m.put(x,m.getOrDefault(x,0)+1);if(m.get(x)>0)miss++;}}return bl==Integer.MAX_VALUE?"":s.substring(bs,bs+bl);}
 // 18 Binary search O(log n)
 static int binarySearch(int[]a,int t){int l=0,r=a.length-1;while(l<=r){int m=l+(r-l)/2;if(a[m]==t)return m;if(a[m]<t)l=m+1;else r=m-1;}return -1;}
 // 19 Search rotated distinct array O(log n)
 static int searchRotated(int[]a,int t){int l=0,r=a.length-1;while(l<=r){int m=l+(r-l)/2;if(a[m]==t)return m;if(a[l]<=a[m]){if(a[l]<=t&&t<a[m])r=m-1;else l=m+1;}else{if(a[m]<t&&t<=a[r])l=m+1;else r=m-1;}}return -1;}
 // 20 First and last occurrence O(log n)
 static int[] searchRange(int[]a,int t){int l=lower(a,t),r=upper(a,t)-1;return l<a.length&&a[l]==t?new int[]{l,r}:new int[]{-1,-1};}
 static int lower(int[]a,int t){int l=0,r=a.length;while(l<r){int m=(l+r)/2;if(a[m]<t)l=m+1;else r=m;}return l;}
 static int upper(int[]a,int t){int l=0,r=a.length;while(l<r){int m=(l+r)/2;if(a[m]<=t)l=m+1;else r=m;}return l;}
 // 21 Reverse linked list O(n)
 static ListNode reverseList(ListNode h){ListNode p=null,c=h;while(c!=null){ListNode n=c.n;c.n=p;p=c;c=n;}return p;}
 // 22 Cycle detection O(n), O(1)
 static boolean hasCycle(ListNode h){ListNode s=h,f=h;while(f!=null&&f.n!=null){s=s.n;f=f.n.n;if(s==f)return true;}return false;}
 // 23 Merge sorted lists O(n+m), reuses nodes
 static ListNode mergeLists(ListNode a,ListNode b){ListNode d=new ListNode(0),t=d;while(a!=null&&b!=null){if(a.v<=b.v){t.n=a;a=a.n;}else{t.n=b;b=b.n;}t=t.n;}t.n=a!=null?a:b;return d.n;}
 // 24 Valid parentheses O(n)
 static boolean validParentheses(String s){Deque<Character>q=new ArrayDeque<>();for(char c:s.toCharArray()){if(c=='('||c=='['||c=='{')q.push(c);else{if(q.isEmpty())return false;char x=q.pop();if((c==')'&&x!='(')||(c==']'&&x!='[')||(c=='}'&&x!='{'))return false;}}return q.isEmpty();}
 // 25 Next greater element O(n)
 static int[] nextGreater(int[]a){int[]o=new int[a.length];Arrays.fill(o,-1);Deque<Integer>q=new ArrayDeque<>();for(int i=0;i<a.length;i++){while(!q.isEmpty()&&a[q.peek()]<a[i])o[q.pop()]=a[i];q.push(i);}return o;}
 // 26 Max tree depth O(n)
 static int maxDepth(TreeNode n){return n==null?0:1+Math.max(maxDepth(n.l),maxDepth(n.r));}
 // 27 Level order traversal O(n)
 static List<List<Integer>> levelOrder(TreeNode n){List<List<Integer>>o=new ArrayList<>();if(n==null)return o;Queue<TreeNode>q=new ArrayDeque<>();q.add(n);while(!q.isEmpty()){int z=q.size();List<Integer>row=new ArrayList<>();while(z-->0){TreeNode x=q.remove();row.add(x.v);if(x.l!=null)q.add(x.l);if(x.r!=null)q.add(x.r);}o.add(row);}return o;}
 // 28 Subsets O(n*2^n)
 static List<List<Integer>> subsets(int[]a){List<List<Integer>>o=new ArrayList<>();subDfs(a,0,new ArrayList<>(),o);return o;}
 static void subDfs(int[]a,int i,List<Integer>p,List<List<Integer>>o){if(i==a.length){o.add(new ArrayList<>(p));return;}subDfs(a,i+1,p,o);p.add(a[i]);subDfs(a,i+1,p,o);p.remove(p.size()-1);}
 // 29 Combination sum; positive candidates; reusable
 static List<List<Integer>> combinationSum(int[]a,int t){Arrays.sort(a);List<List<Integer>>o=new ArrayList<>();combDfs(a,t,0,new ArrayList<>(),o);return o;}
 static void combDfs(int[]a,int t,int i,List<Integer>p,List<List<Integer>>o){if(t==0){o.add(new ArrayList<>(p));return;}for(int j=i;j<a.length&&a[j]<=t;j++){if(j>i&&a[j]==a[j-1])continue;p.add(a[j]);combDfs(a,t-a[j],j,p,o);p.remove(p.size()-1);}}
 // 30 Permutations of distinct values O(n*n!)
 static List<List<Integer>> permutations(int[]a){List<List<Integer>>o=new ArrayList<>();permDfs(a,new boolean[a.length],new ArrayList<>(),o);return o;}
 static void permDfs(int[]a,boolean[]u,List<Integer>p,List<List<Integer>>o){if(p.size()==a.length){o.add(new ArrayList<>(p));return;}for(int i=0;i<a.length;i++)if(!u[i]){u[i]=true;p.add(a[i]);permDfs(a,u,p,o);p.remove(p.size()-1);u[i]=false;}}
 public static void main(String[]z){System.out.println("Q1: "+maxSubarray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));System.out.println("Q10: "+Arrays.toString(twoSum(new int[]{2,7,11,15},9)));System.out.println("Q24: "+validParentheses("({[]})"));System.out.println("Q28 count: "+subsets(new int[]{1,2,3}).size());}
}