class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        int h1= Integer.parseInt(startTime.substring(0,2));
        int m1= Integer.parseInt(startTime.substring(3,5));
        int s1= Integer.parseInt(startTime.substring(6,8));

        int h2= Integer.parseInt(endTime.substring(0,2));
        int m2= Integer.parseInt(endTime.substring(3,5));
        int s2= Integer.parseInt(endTime.substring(6,8));

        int time=0;
        if(m1==m2 && h1==h2)
            return s2-s1;

        m1++;
        time+= (60-s1) + s2;
        if(h1!=h2)
            time+= (((60-m1) + m2) * 60);
        else 
            time+= (m2-m1) * 60;

        h1++;
        if(h1<=h2)
            time+= Math.abs(h2-h1) * 3600;
        return time;
    }
}