#include <stdio.h>
#include <fcntl.h>
#include <stdlib.h>
#include <sys/ioctl.h>

int main(int argc, char ** argv) {
  int fd = open("/dev/fb0", O_WRONLY|O_NONBLOCK );
  int on;
  int res = 0;

  if (argc != 2) {
    printf("You must specify on or off\n");
    return 0;
  }

  on = !strncmp(argv[1], "on", (strlen(argv[1]) > 1 ? 2 : 1));

  printf((on ? "on\n" : "off\n"));

  if ( fd )
    {
      int ioctlnum = 0x4611;
      int vesaMode = on ? 0 : 3;
      res = ioctl ( fd, ioctlnum, vesaMode );
      printf("%i\n", res);
      close ( fd );
    }
  else
    {
      printf("failed\n");
    }
  return res;
}

