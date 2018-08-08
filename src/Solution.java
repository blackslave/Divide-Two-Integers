/**
 * 因為使用加減法迴圈去解，必定超時，所以改用左移右移方式進行。
 * 將被除數左移後與除數比較如28/3時，將3左移三次，如3*2*2*2=24，若左移四次則會超過28
 * 之後將28-3*2^3=4，在將4與除數比較，將3左移，4-3*2^0=1
 * 記錄結果，第一次左移3次2^3=8加上第二次左移零次2^0=1，8+1=9即為結果商
 * @author black
 *
 */
public class Solution {
	public int divide(int dividend, int divisor) {
		int result = 0;
		if(dividend==-2147483648 && divisor==-1)	return ~dividend;
		long dividend2 = Math.abs((long)dividend);
		long divisor2 = Math.abs((long)divisor);
		while(dividend2>=divisor2)
		{
			int count = 0;
			while(divisor2<<count<=dividend2)
			{
				count++;
			}
			result = result + 1<<(count-1);
			dividend2 = dividend2 - (divisor2<<(count-1));
		}
		if((dividend>0 && divisor>0)||(dividend<0 && divisor<0))
			return result;
		else
			return -result;
    }
}
