package com.plus;

import org.junit.Test;

import java.util.*;

/**
 * Created by Administrator on 2016/4/27.
 */
public class Solution {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] nums1 = {1,2,3,4,5,6,7,8,9,41,56,8};
        int[] nums2 = {5,41};
        int[] result = solution.intersection2(nums1,nums2);
        for(int i : result)
            System.out.println(i);
    }
    public String reverseVowels(String s) {

       int i=0,j=0;
        if(s==null)
            return s;
       for(int k=0;k<s.length();k++) {
           if (s.charAt(k) == 'a' || s.charAt(k) == 'e' || s.charAt(k) == 'i' || s.charAt(k) == 'o' || s.charAt(k) == 'u' ) {
               i = k;
               break;
           }
       }
        for(int k=i+1;k<s.length();k++) {
            if (s.charAt(i) != s.charAt(k)) {
               if(s.charAt(k) == 'a' || s.charAt(k) == 'e' || s.charAt(k) == 'i' || s.charAt(k) == 'o' || s.charAt(k) == 'u')
                {
                    j = k;
                    break;
                }
            }
        }
        char[] chars=s.toCharArray();
        char temp=chars[i];
        chars[i]=chars[j];
        chars[j]=temp;
        return String.valueOf(chars);
    }

    public String reverseString(String s) {

        char[] chars=s.toCharArray();
        char temp;
        for(int i=0,j=s.length()-1;i<s.length()/2;i++,j--) {
            temp = chars[i];
            chars[i]=chars[j];
            chars[j]=temp;
        }
        return String.valueOf(chars);
    }

    //丑数
    public boolean isUgly(int num) {
        // Write your code here
        while (num %2 == 0)
        {
            num /= 2;
        }
        while (num %3 == 0)
        {
            num /= 3;
        }
        while (num %5 == 0)
        {
            num /= 5;
        }
        if (num == 1)
            return true;
        else
            return false;
    }

    public static int[] getPrime(int n){

        int[] prime=new int[n/2];
        int k=0;
            for (int i = 2; i < n; i++) {
                Boolean flag = true;
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag == true)
                    prime[k++]=i;
            }
        return prime;
    }

    //求topk元素
    public List<Integer> topKFrequent(int[] nums, int k) {

          if(k<1)
              return null;
        List<Integer> list=new ArrayList<Integer>();
        Map<Integer,Integer> beforeSortmap=new HashMap<Integer,Integer>();
        Map<Integer,Integer> afterSortmap=new LinkedHashMap<Integer,Integer>();
        int count;
        Boolean flag;
        int length=nums.length;
        for(int i=0;i<length;i++) {
            count = 0;
            flag=false;
            for(int j=0;j<i;j++)
            {
                if(nums[i]==nums[j])
                    flag=true;
                    break;
            }

            if(flag==true)
                continue;
            for(int l=i;l<length;l++)
                if(nums[l]==nums[i])
                    count++;
            beforeSortmap.put(nums[i],count);
        }
        afterSortmap=mapsort(beforeSortmap);
            Iterator it=afterSortmap.entrySet().iterator();
        int p=0;
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> me = (Map.Entry<Integer, Integer>)it.next();
            list.add(me.getKey());
            p++;
            if (p>k)
                break;
        }
        return list;

    }

    //map排序
    public static Map<Integer,Integer> mapsort(Map<Integer,Integer> map){

        Map<Integer,Integer> aftermap=new LinkedHashMap<Integer,Integer>();
        Collection<Integer> collection=map.values();
        Object[] objects=collection.toArray();
        for(int i=0;i<objects.length;i++)
            for(int j=0;j<objects.length-1-i;j++){
                if(Integer.parseInt(objects[j].toString())<Integer.parseInt(objects[j+1].toString()))
                {
                    Object high=objects[j+1];
                    objects[j+1]=objects[j];
                    objects[j]=high;
                }
            }
        Set set=map.entrySet();
        for(int j=0;j<objects.length;j++) {
            Iterator it = set.iterator();
            while(it.hasNext()) {
                Map.Entry<Integer, Integer> me = (Map.Entry<Integer, Integer>)it.next();
                if(objects[j].equals(me.getValue())) {
                    aftermap.put(me.getKey(), me.getValue());
                }
            }
        }
        return aftermap;
    }

    public static boolean isPowerOfThree(int n) {

        if(n<=0)
            return false;
        if(n==1)
            return true;
        int i=3;
        while (true){
            if(i==n)
                return true;
           else if(i<n)
                i=i*3;
           else return false;
        }
    }

    //找出两个数组中相同的数
    public int[] intersection(int[] nums1,int[] nums2){
        if(nums1 == null || nums2 == null)
            return null;
        Map<Integer,Integer> resultMap = new HashMap<Integer, Integer>();
        Arrays.sort(nums1);
        for(int i =0;i < nums2.length;i++){
            int start = 0;
            int end = nums1.length - 1;
            Boolean tag = false;
            while (start <= end)
            {
                int mid = (start + end)/2;
                if(nums1[mid] == nums2[i]){
                    tag = true;
                    break;
                }
                if(nums1[mid] < nums2[i])
                    start = mid +1;
                if(nums1[mid] > nums2[i])
                    end = mid -1;
            }
            if(tag == true)
                resultMap.put(nums2[i],nums2[i]);
        }
        int[] result = new int[resultMap.size()];
        int i = 0;
        Iterator iterator = resultMap.keySet().iterator();
        while (iterator.hasNext())
            result[i++] = resultMap.get(iterator.next());
        return result;
    }

    public int[] intersection2(int[] nums1,int[] nums2){
        if(nums1 == null || nums2 == null)
            return null;
        Map<Integer,Integer> resultMap = new HashMap<Integer, Integer>();
        for(int i =0;i < nums2.length;i++){
            Boolean tag = false;
            for(int j = 0;j < nums1.length;j++)
                if (nums1[j] == nums2[i]) {
                    tag = true;
                    break;
                }
            if(tag == true)
                resultMap.put(nums2[i],nums2[i]);
        }
        int[] result = new int[resultMap.size()];
        int i = 0;
        Iterator iterator = resultMap.keySet().iterator();
        while (iterator.hasNext())
            result[i++] = resultMap.get(iterator.next());
        return result;
    }

    @Test
    public void testofintersection(){
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] result = intersection(nums1,nums2);
        for(int i : result)
            System.out.println(i);
    }
    public int sumoftownumbers(int a,int b){
        int sum = 0;
        while (b != 0){
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    @Test
    public void testofsumoftwonumbers(){
        System.out.println(sumoftownumbers(1,2));
    }
}
