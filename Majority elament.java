int majorityElement(int* nums, int numsSize) {
    int i,count=0;
    int a[10];
    int num=0;
    for(i=0;i<numsSize;i++)
    {
        if(count==0)
        {
            num=nums[i];
            count=1;
        } 
        else if(nums[i]==num)
        {
           count++;
         }
         else
        {
             count--;
        }
    }
    return num;
}