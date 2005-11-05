
#include <stdio.h>
#include <errno.h> 
#include <sys/types.h>
#include <sys/stat.h>


int main(int argc, char **argv)
{
	struct stat sbuf;
	char *devtype;
	FILE *headerfile;
	unsigned int header[4];


	if (argc != 3) {
		fprintf(stderr, "usage: %s NSLU2_kernel_file_name prepend_header_filename\nThis program builds a 16 byte header which can be prepended to a NSLU2 Kernel for reflashing\n", argv[0]);
		exit (1);
	}

	if (stat(argv[1], &sbuf) < 0) {
		fprintf(stderr, "%s: stat: %s\n", argv[1], strerror(errno));
		exit (1);
	}

	/* printf ("File %s is %d bytes long\n", argv[1], sbuf.st_size); */
	if ((headerfile=fopen(argv[2],"wb"))==NULL)
	{
                fprintf(stderr,"Error opening file\n");
		exit (1);
	}

	if ((sbuf.st_size + 16) > 0x100000) {
		fprintf(stderr,"Error Kernel + Header is > 1 MB\n");
		exit (1);
	}

	header[0] = (unsigned int)sbuf.st_size + 16;
	header[1] = 0; 
	header[2] = 0;
	header[3] = 0;
        if (!fwrite(&header, sizeof(unsigned int), 4, headerfile)) 
		fprintf(stderr,"Error write to headerfile: %s\n", strerror(errno));

	fclose(headerfile);
}

