#include <algorithm>
#include <array>
#include <climits>
#include <cctype>
#include <stdexcept>
#include <functional>
#include <iostream>
#include <map>
#include <queue>
#include <stack>
#include <string>
#include <unordered_map>
#include <vector>
using namespace std;
struct ListNode{int v;ListNode*n;explicit ListNode(int x):v(x),n(nullptr){}};
struct TreeNode{int v;TreeNode*l,*r;explicit TreeNode(int x):v(x),l(nullptr),r(nullptr){}};
// 1 Kadane O(n)
int maxSubarray(const vector<int>&a){if(a.empty())throw invalid_argument("empty");int c=a[0],b=c;for(int i=1;i<(int)a.size();i++){c=max(a[i],c+a[i]);b=max(b,c);}return b;}
// 2 Rotate right O(n)
void rotateRight(vector<int>&a,int k){if(a.empty())return;k=(k%(int)a.size()+(int)a.size())%(int)a.size();reverse(a.begin(),a.end());reverse(a.begin(),a.begin()+k);reverse(a.begin()+k,a.end());}
// 3 Move zeroes O(n)
void moveZeroes(vector<int>&a){int w=0;for(int x:a)if(x)a[w++]=x;while(w<(int)a.size())a[w++]=0;}
// 4 Product except self O(n)
vector<long long> productExceptSelf(const vector<int>&a){vector<long long>o(a.size(),1);long long p=1;for(int i=0;i<(int)a.size();i++){o[i]=p;p*=a[i];}long long s=1;for(int i=(int)a.size()-1;i>=0;i--){o[i]*=s;s*=a[i];}return o;}
// 5 Merge intervals O(n log n)
vector<vector<int>> mergeIntervals(vector<vector<int>>a){sort(a.begin(),a.end());vector<vector<int>>o;for(auto&v:a){if(o.empty()||v[0]>o.back()[1])o.push_back(v);else o.back()[1]=max(o.back()[1],v[1]);}return o;}
// 6 Anagram O(n), byte alphabet
bool anagram(const string&a,const string&b){if(a.size()!=b.size())return false;array<int,256>f{};for(unsigned char c:a)f[c]++;for(unsigned char c:b)f[c]--;return all_of(f.begin(),f.end(),[](int x){return x==0;});}
// 7 Longest common prefix
string commonPrefix(const vector<string>&a){if(a.empty())return "";string p=a[0];for(auto&s:a){size_t i=0;while(i<p.size()&&i<s.size()&&p[i]==s[i])i++;p.resize(i);}return p;}
// 8 Reverse words O(n)
string reverseWords(const string&s){vector<string>w;for(size_t i=0;i<s.size();){while(i<s.size()&&isspace((unsigned char)s[i]))i++;size_t j=i;while(j<s.size()&&!isspace((unsigned char)s[j]))j++;if(j>i)w.push_back(s.substr(i,j-i));i=j;}reverse(w.begin(),w.end());string o;for(auto&x:w){if(!o.empty())o+=' ';o+=x;}return o;}
// 9 Longest palindrome O(n^2)
string longestPalindrome(const string&s){int st=0,len=0;for(int i=0;i<(int)s.size();i++)for(int d=0;d<2;d++){int l=i,r=i+d;while(l>=0&&r<(int)s.size()&&s[l]==s[r]){l--;r++;}if(r-l-1>len){st=l+1;len=r-l-1;}}return s.substr(st,len);}
// 10 Two sum O(n) average
vector<int> twoSum(const vector<int>&a,int t){unordered_map<int,int>m;for(int i=0;i<(int)a.size();i++){auto it=m.find(t-a[i]);if(it!=m.end())return{it->second,i};m[a[i]]=i;}return{};}
// 11 Group anagrams O(n*k log k)
vector<vector<string>> groupAnagrams(const vector<string>&a){map<string,vector<string>>m;for(auto s:a){string k=s;sort(k.begin(),k.end());m[k].push_back(s);}vector<vector<string>>o;for(auto&p:m)o.push_back(p.second);return o;}
// 12 Subarray sum k O(n) average
int subarraySum(const vector<int>&a,int k){unordered_map<long long,int>m{{0,1}};long long s=0;int c=0;for(int x:a){s+=x;c+=m[s-k];m[s]++;}return c;}
// 13 3Sum O(n^2)
vector<vector<int>> threeSum(vector<int>a){sort(a.begin(),a.end());vector<vector<int>>o;for(int i=0;i+2<(int)a.size();i++){if(i&&a[i]==a[i-1])continue;int l=i+1,r=a.size()-1;while(l<r){long long s=(long long)a[i]+a[l]+a[r];if(s==0){o.push_back({a[i],a[l],a[r]});int x=a[l],y=a[r];while(l<r&&a[l]==x)l++;while(l<r&&a[r]==y)r--;}else if(s<0)l++;else r--;}}return o;}
// 14 Container water O(n)
long long maxArea(const vector<int>&h){int l=0,r=h.size()-1;long long b=0;while(l<r){b=max(b,(long long)(r-l)*min(h[l],h[r]));if(h[l]<h[r])l++;else r--;}return b;}
// 15 Remove duplicates sorted O(n)
int removeDuplicates(vector<int>&a){if(a.empty())return 0;int w=1;for(int r=1;r<(int)a.size();r++)if(a[r]!=a[w-1])a[w++]=a[r];return w;}
// 16 Longest unique substring O(n), byte alphabet
int longestUnique(const string&s){array<int,256>last;last.fill(-1);int l=0,b=0;for(int r=0;r<(int)s.size();r++){unsigned char c=s[r];l=max(l,last[c]+1);last[c]=r;b=max(b,r-l+1);}return b;}
// 17 Minimum window O(n), byte alphabet
string minWindow(const string&s,const string&t){if(t.empty()||s.size()<t.size())return "";array<int,256>need{};for(unsigned char c:t)need[c]++;int miss=t.size(),l=0,bs=0,bl=INT_MAX;for(int r=0;r<(int)s.size();r++){unsigned char c=s[r];if(need[c]>0)miss--;need[c]--;while(!miss){if(r-l+1<bl){bs=l;bl=r-l+1;}unsigned char x=s[l++];need[x]++;if(need[x]>0)miss++;}}return bl==INT_MAX?"":s.substr(bs,bl);}
// 18 Binary search O(log n)
int binarySearch(const vector<int>&a,int t){int l=0,r=a.size()-1;while(l<=r){int m=l+(r-l)/2;if(a[m]==t)return m;if(a[m]<t)l=m+1;else r=m-1;}return -1;}
// 19 Rotated sorted search, distinct values O(log n)
int searchRotated(const vector<int>&a,int t){int l=0,r=a.size()-1;while(l<=r){int m=l+(r-l)/2;if(a[m]==t)return m;if(a[l]<=a[m]){if(a[l]<=t&&t<a[m])r=m-1;else l=m+1;}else{if(a[m]<t&&t<=a[r])l=m+1;else r=m-1;}}return -1;}
// 20 First and last occurrence O(log n)
vector<int> searchRange(const vector<int>&a,int t){auto x=lower_bound(a.begin(),a.end(),t);if(x==a.end()||*x!=t)return{-1,-1};auto y=upper_bound(a.begin(),a.end(),t);return{int(x-a.begin()),int(y-a.begin()-1)};}
// 21 Reverse linked list O(n)
ListNode* reverseList(ListNode*h){ListNode*p=nullptr,*c=h;while(c){auto*n=c->n;c->n=p;p=c;c=n;}return p;}
// 22 Floyd cycle detection O(n)
bool hasCycle(ListNode*h){auto*s=h,*f=h;while(f&&f->n){s=s->n;f=f->n->n;if(s==f)return true;}return false;}
// 23 Merge sorted lists O(n+m), reuses nodes
ListNode* mergeLists(ListNode*a,ListNode*b){ListNode d(0),*t=&d;while(a&&b){if(a->v<=b->v){t->n=a;a=a->n;}else{t->n=b;b=b->n;}t=t->n;}t->n=a?a:b;return d.n;}
// 24 Valid parentheses O(n)
bool validParentheses(const string&s){stack<char>q;for(char c:s){if(c=='('||c=='['||c=='{')q.push(c);else{if(q.empty())return false;char x=q.top();q.pop();if((c==')'&&x!='(')||(c==']'&&x!='[')||(c=='}'&&x!='{'))return false;}}return q.empty();}
// 25 Next greater element O(n)
vector<int> nextGreater(const vector<int>&a){vector<int>o(a.size(),-1);stack<int>q;for(int i=0;i<(int)a.size();i++){while(!q.empty()&&a[q.top()]<a[i]){o[q.top()]=a[i];q.pop();}q.push(i);}return o;}
// 26 Maximum tree depth O(n)
int maxDepth(TreeNode*n){return n?1+max(maxDepth(n->l),maxDepth(n->r)):0;}
// 27 Level-order traversal O(n)
vector<vector<int>> levelOrder(TreeNode*n){vector<vector<int>>o;if(!n)return o;queue<TreeNode*>q;q.push(n);while(!q.empty()){int z=q.size();vector<int>row;while(z--){auto*x=q.front();q.pop();row.push_back(x->v);if(x->l)q.push(x->l);if(x->r)q.push(x->r);}o.push_back(row);}return o;}
// 28 Subsets O(n*2^n)
vector<vector<int>> subsets(const vector<int>&a){vector<vector<int>>o;vector<int>p;function<void(int)>dfs=[&](int i){if(i==(int)a.size()){o.push_back(p);return;}dfs(i+1);p.push_back(a[i]);dfs(i+1);p.pop_back();};dfs(0);return o;}
// 29 Combination sum; positive candidates; reusable
vector<vector<int>> combinationSum(vector<int>a,int t){sort(a.begin(),a.end());vector<vector<int>>o;vector<int>p;function<void(int,int)>dfs=[&](int rem,int i){if(!rem){o.push_back(p);return;}for(int j=i;j<(int)a.size()&&a[j]<=rem;j++){if(j>i&&a[j]==a[j-1])continue;p.push_back(a[j]);dfs(rem-a[j],j);p.pop_back();}};dfs(t,0);return o;}
// 30 Permutations of distinct values O(n*n!)
vector<vector<int>> permutations(const vector<int>&a){vector<vector<int>>o;vector<int>p;vector<bool>u(a.size());function<void()>dfs=[&](){if(p.size()==a.size()){o.push_back(p);return;}for(int i=0;i<(int)a.size();i++)if(!u[i]){u[i]=1;p.push_back(a[i]);dfs();p.pop_back();u[i]=0;}};dfs();return o;}
int main(){cout<<"Q1: "<<maxSubarray({-2,1,-3,4,-1,2,1,-5,4})<<'\n';cout<<"Q10 result size: "<<twoSum({2,7,11,15},9).size()<<'\n';cout<<"Q24: "<<boolalpha<<validParentheses("({[]})")<<'\n';cout<<"Q28 subsets: "<<subsets({1,2,3}).size()<<'\n';}
