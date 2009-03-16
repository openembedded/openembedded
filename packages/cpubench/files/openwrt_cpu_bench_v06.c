
#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>
#include <time.h>
#include <unistd.h>




#define VERSION_STR "v0.6"

// This is the overhead of calling gettimeofday() 2 times
double overhead = -1;

double begin_secs = 0;
double real_get_seconds()
{
	struct timeval tv;
	double total;

	gettimeofday(&tv, NULL);
	total = (double)tv.tv_sec;
	total += ((double)tv.tv_usec)/(double)1000000.0;
	
	//printf("Secs: %d / Usecs: %d / FSecs: %f\n", tv.tv_sec, tv.tv_usec, total);

	return total;
}
double get_seconds()
{
	if (begin_secs == 0)
	{
		// First call
		begin_secs = real_get_seconds();
	}

	return (real_get_seconds() - begin_secs);
}


double run_float_bench()
{
	double secs;
	double begin = get_seconds();
	int i;

	double nb=0;
	for (i=0;i<300000;i++)
	{
		nb *= i;
		int n = i >> 10;
		nb /= n;
	}
	
	double end = get_seconds();
	secs = end-begin;
	printf("Time to run float bench: %.2f[secs]\n", secs);

	return secs;
}


double do_run_memory_bench()
{
	double begin, end;
	int i;
	int* buf;
	int len, index;
	double secs;

       	begin = get_seconds();
       
	len = (1<<21)/sizeof(int); // 2Mb
	buf = malloc(len*sizeof(int));

	// Write to memory - sequential
	for (i=0;i<len;i++)
	{
		buf[i] = i;
	}

	// Read memory - sequential
	for (i=0;i<len;i++)
	{
		int a = buf[i];
	}

	// Read memory - random
	for (i=0;i<len;i++)
	{
		index = (i*23)%(len/2);
		int a = buf[index];
	}

	// Write memory - random
	for (i=0;i<len;i++)
	{
		index = (i*23)%(len/2);
		buf[index] = i;
	}
	free(buf);
	
	end = get_seconds();
	secs = (end-begin);

	return secs;
}

double run_memory_bench()
{
	double secs = 0;
	int i;

	for (i=0;i<10;i++)
	{
		secs += do_run_memory_bench();
	}

	printf("Time to run memory bench: %.2f[secs]\n", secs);

	return secs;
}

#define NBD 9009
double run_compute_e()
{
	double begin, end;
	double secs;

	begin = get_seconds();

	int N=NBD, n=N, a[NBD],x;
	while(--n)
	{
		a[n]=1+1/n;
	}

	for(;N>9;)
	{
		for(n=N--;--n; a[n]=x%n, x=10*a[n-1]+x/n)
		{
		}
	}

	end = get_seconds();

	secs = (end-begin);
	printf("Time to run computation of e (%d digits): %.2f[secs]\n", NBD, secs);

	return secs;
}

double run_compute_pi()
{
	double begin, end;
	double secs;
	int i;

	begin = get_seconds();
	//printf("Begin: %f\n", begin);

	for (i=0;i<10;i++)
	{
		int a=10000,b=0,c=8400,d=0,e=0,f[8401],g=0;

		//printf("i:%d\n", i);
		for(;b-c;)
		{
			f[b++]=a/5;
		}

		for(;d=0,g=c*2;c-=14,e=d%a)
		{
			for(b=c;d+=f[b]*a,f[b]=d%--g,d/=g--,--b;d*=b)
			{
			}
		}
		//printf("Mid: %lld\n", (get_seconds()-end));
	}

	end = get_seconds();
	//printf("End: %f\n", end);

	secs = (end-begin);
	printf("Time to run computation of pi (2400 digits, 10 times): %.2f[secs]\n", secs);

	return secs;
}

int main()
{
	printf("This is CPU and memory benchmark for OpenWRT "VERSION_STR". This will then take some time... (typically 30-60 seconds on a 200MHz computer)\n");

	double begin = get_seconds();
	double end = get_seconds();
	overhead = (end-begin)*1000000;
	printf("Overhead for getting time: %.0fus\n", overhead);


	// Nb 1
	double sec_mem = run_memory_bench();

	// Nb 2
	double sec_pi = run_compute_pi();

	// Nb 3
	double sec_e = run_compute_e();

	// Nb 4
	double sec_float = run_float_bench();
	



	printf("Total time: %.1fs\n", (sec_mem+sec_e+sec_pi+sec_float));

	time_t t = time(0);
	struct tm ti;
       	localtime_r(&t, &ti);
	printf("\nYou can copy/paste the following line in the wiki table at: http://wiki.openwrt.org/HardwarePerformance\n");

	printf("|| %04d-%02d-%02d || ''Author'' || %.1fs || %.1fs || %.1fs || %.1fs || " VERSION_STR " || ''OS'' || ''DeviceModel'' || ''CPU model'' || ''CPU Frequency'' || ''LinkToHwPage'' ||\n", (ti.tm_year+1900), (ti.tm_mon+1), ti.tm_mday, sec_mem, sec_pi, sec_e, sec_float);

	return 0;
}

