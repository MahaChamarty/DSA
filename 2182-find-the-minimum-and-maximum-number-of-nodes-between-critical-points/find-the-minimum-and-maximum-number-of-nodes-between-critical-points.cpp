/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    vector<int> nodesBetweenCriticalPoints(ListNode* head) {
       ListNode* prev = head;
       ListNode* curr = prev->next;
       ListNode* forw = curr->next;
       int f = -1, l = -1, c = 0;
       vector<int> ans = {INT_MAX, -1};
       while(forw != NULL){
        if((curr->val > prev->val && curr->val > forw->val) || (curr->val < prev->val && curr->val < forw->val)){
            if(f != -1){
                ans[0] = min(ans[0], c-f);
                ans[1] = c-l;
            }
            else{
                l = c;
            }
            f = c;
        }
        prev = curr;
        curr = forw;
        forw = forw->next;
        c++;
       } 
       if(ans[0] == INT_MAX){
        ans[0] = -1;
       }
       return ans;
    }
};