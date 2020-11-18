package Bean;
public class questionbean
{
private String q[]=new String[5];
private String ch1[]=new String[5];
private String ch2[]=new String[5];
private String ch3[]=new String[5];
private String ch4[]=new String[5];
public void setQ(int i,String q1)
{
this.q[i]=q1;
}
public void setCh1(int i,String ch)
{
this.ch1[i]=ch;
}

public void setCh2(int i,String ch)
{
this.ch2[i]=ch;
}
public void setCh3(int i,String ch)
{
this.ch3[i]=ch;
}
public void setCh4(int i,String ch)
{
this.ch4[i]=ch;
}
public String getQ(int i)
{
return q[i];
}
public String getCh1(int i)
{
return ch1[i];
}
public String getCh2(int i)
{
return ch2[i];
}
public String getCh3(int i)
{
return ch3[i];
}
public String getCh4(int i)
{
return ch4[i];
}
}
