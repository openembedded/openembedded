#include "arnold_boot.h"
#include <stdio.h>
volatile void 
error (char *msg)
{
  fprintf (stderr, "Fatal Error:%s\n", msg);
  exit (2);
}
#ifdef LITTLE_END
#define order(x)  ((x&0xff)<<24 | (x&0xff00) << 8 | (x&0xff0000) >>8 | (x&0xff000000)>>24)
#define swap(x)	  ((x&0xff)<<8 | (x&0xff00)>>8)
#else
#define order(x)  (x)
#define swap(x)	  (x)
#endif

main (int argc, char *argv[])
{
  union bootblock block0;
  char *ep;
  int nseg;

  memset ((void *) &block0, 0, sizeof (block0));
  strcpy (block0.boot.magic, ARNOLDMAGIC);
  if (argc < 3)
    error ("Bad Number of args:\n"
	   " Usage: gen_boot [-d[n]][-w][-r][-x filename] exec_adr nseg base1 len1 [base len]");

  if (strncmp (argv[1], "-d",2) == 0)
    {
	/* Set debugging to value (default 1) */
      if ( argv[1][2] == 0 ) {
	      block0.boot.debuggit = swap(1);
      }else{
	      block0.boot.debuggit = swap(argv[1][2] - '0');
      }
      argv++;
      argc--;
    }
  if (strcmp (argv[1], "-w") == 0)
    {
      block0.boot.writesmart = swap(WRITE_SMART_MAGIC);
      argv++;
      argc--;
    }
  if (strcmp (argv[1], "-r") == 0)
    {
      block0.boot.writesmart = swap(REBOOT_MAGIC);  /* Try to reboot ram image */
      argv++;
      argc--;
    }
  if (strcmp (argv[1], "-x") == 0)
    {
      block0.boot.extrafile=swap(EXTRA_BOOT);
      strncpy (block0.boot.otherfile,argv[2],sizeof(block0.boot.otherfile));

      argv+=2;
      argc-=2;
    }
  block0.boot.exec_adr = order (strtoul (argv[1], &ep, 0));
  if (ep != 0 && *ep != 0)
    {
      error ("Exec_addr ?");
    }
  argv++;
  argc--;
  nseg = strtoul (argv[1], &ep, 0);
  block0.boot.nosegs = order (nseg);
  if (ep != 0 && *ep != 0)
    {
      error ("Number of Segments ?");
    }
  argv++;
  argc--;
  argv++;
  argc--;			/* Start from index 0 */
  if (argc != (nseg * 2))
    {
      error ("Wrong number of arguments");
    }
  for (nseg = 0; (nseg * 2) < argc; nseg++)
    {
      block0.boot.lseg[nseg].base = (void *) order (strtoul (argv[nseg * 2], &ep, 0));
      if (ep != 0 && *ep != 0)
	{
	  error ("Base addr of Segment  ?");
	}
      block0.boot.lseg[nseg].len = order (strtoul (argv[nseg * 2 + 1], &ep, 0));
      if (ep != 0 && *ep != 0)
	{
	  error ("Length of Segment  ?");
	}
    }
  fwrite((void *) &block0, sizeof(block0), 1, stdout);
  fflush(stdout);
//  write (1, block0, sizeof (block0));

  exit (0);
}
