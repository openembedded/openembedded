/* (Platform independant) IP lister (c)2000-1 Craig Cheetham 
 * Released under the GNU Licence. - Spread the source, not 
 * the binaries! (ahem fixed)
 *
 * E-Mail: craig_cheetham@yahoo.co.uk
 *
 */
#include <stdio.h>
#include <string.h>
#include <netinet/in.h>

union ipaddy
{
	unsigned char	c_num[4];
	unsigned long   l_num;
};

int parse(char *string, char *dest)
{
	int  i = 0;
	unsigned long	num;
	char *p = string, *n;
        
        strtok(p,"."); 
	
        while(p && i<4) {
	   if((num = atol(p)) > 255)  return 1;
 	   dest[i++] = num;
	   p = strtok(0,".");
	}
	
	return 0;
}

int main (int argc, char **argv)
{
	union	ipaddy source, dest;
        
        if(argc < 3) {
           printf("Platform independant IP lister, by Craig Cheetham (c)2000-1\n");
           printf("===========================================================\n\n");
           printf("Usage: %s <start ip> <end ip>\n\n", argv[0]);                                               
	   printf("Examples:\n");
	   printf("\t\t%s 205 206\t\t\t# Class A scan\n", argv[0]);	   
	   printf("\t\t%s 205.214 205.215\t\t# Class B scan\n", argv[0]);
	   printf("\t\t%s 205.214.14 205.214.56\t# Class C scan\n", argv[0]);
           exit(0);
        }
        
	source.l_num = dest.l_num = 0;
	
	if(parse(argv[1], source.c_num)) {
	   fprintf(stderr, "Error: Source IP is jarg.\n");
	   return 0;
	}
	  
        if(parse(argv[2], dest.c_num)) {
	   fprintf(stderr, "Error: Dest IP is jarg.\n");
	   return 0;
	}	  
	             
	while(htonl(source.l_num) < htonl(dest.l_num)) {

	  if ((source.c_num[3]!=0) && (source.c_num[3]!=255))
	  printf("%u.%u.%u.%u\n",
	         source.c_num[0],
	         source.c_num[1],
                 source.c_num[2],
                 source.c_num[3]);
		
	  source.l_num = htonl(htonl(source.l_num)+1);
	}
        
	return 0;
}
