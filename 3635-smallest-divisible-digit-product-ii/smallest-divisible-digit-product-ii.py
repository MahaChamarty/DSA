class Solution:
    def smallestNumber(self, num: str, t: int) -> str:
        def buildEnd(req, size):
            res = []
            for f in range(9, 1, -1):
                while(req % f == 0):
                    req //= f
                    res.append(str(f))
            if len(res) < size:
                res += ['1']*(size - len(res))
            return "".join(res[::-1])
        n = len(num)
        cur = t
        for f in [2, 3, 5, 7]:
            while(cur % f == 0):
                cur //= f
        if cur != 1:
            return '-1'
        rem = [0]*(n+1)
        rem[0] = t
        for i in range(n):
            if num[i] == '0':
                break
            rem[i+1] = rem[i] // gcd(rem[i], int(num[i]))
        if rem[-1] == 1:
            return num
        
        z = num.find('0')
        start = z if z != -1 else n-1
        for i in range(start, -1, -1):
            end = n-i-1
            for d in range(int(num[i]) + 1, 10):
                end1 = buildEnd(rem[i] // gcd(rem[i], d), end)
                if len(end1) == end:
                    return num[:i] + str(d) + end1
        return buildEnd(t, n+1)