#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>

int stat(const char *file_name, struct stat *buf);

int syntax(void)
{
  printf("syntax:\n");
  printf("  pad padnum filename\n");
  return(0);
}

int main(int argc, char **argv)
{
  FILE *fp;
  long int i=0L, padsize=0L;
  unsigned char data=0xff;
  struct stat fileinfo;
  if(argc<3){
    syntax();
    exit(1);
  }
  if((fp=fopen(argv[2],"a"))==NULL){
    printf("error opening %s.\n",argv[2]);
    exit(1);
  }
  if(stat(argv[2],&fileinfo)!=0){
    printf("error in stat of %s.\n",argv[2]);
    exit(1);
  }
  padsize = strtol(argv[1],NULL,10) - fileinfo.st_size;
  for(i=0;i<padsize;i++){
    fwrite(&data,1,1,fp);
  }
  fclose(fp);
  return(0);
}
