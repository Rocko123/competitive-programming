#include <bits/stdc++.h>
 
using namespace std;
 
typedef long long ll;
typedef pair<int, int> pi;

int main() {
    ios::sync_with_stdio(0); cin.tie(0);

    int n, d;
    cin >> n >> d;
    int a[n+1], dp[n+1];
    for (int i = 1; i <= n; i++) cin >> a[i];

    dp[1] = a[1];
    priority_queue<pair<int, int>, vector<pi>, greater<pi>> pq;
    pq.push({dp[1], 1}); // val first

    for (int i = 2; i <= n; i++) {
        while (i-pq.top().second > d) pq.pop();
        dp[i] = pq.top().first + a[i];
        pq.push({dp[i], i});
    }
    cout << dp[n] << "\n";
    return 0;
}