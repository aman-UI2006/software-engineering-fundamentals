#include <algorithm>
#include <iostream>
#include <numeric>
#include <queue>
#include <string>
#include <unordered_map>
#include <vector>
using namespace std;
int main(){
 vector<int> values{8,2,5,2,9,1};sort(values.begin(),values.end());
 auto it=lower_bound(values.begin(),values.end(),5);
 unordered_map<string,int> frequency;
 for(const string& word:{"code","review","code","test"})++frequency[word];
 priority_queue<int> maxHeap(values.begin(),values.end());
 cout<<"Sorted: ";for(int x:values)cout<<x<<' ';
 cout<<"\nFirst >= 5 index: "<<(it-values.begin());
 cout<<"\nSum: "<<accumulate(values.begin(),values.end(),0);
 cout<<"\nLargest: "<<maxHeap.top();
 cout<<"\nFrequency(code): "<<frequency["code"]<<'\n';
}
