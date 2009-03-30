
#define ARNOLDMAGIC "ARNOLDBOOTBLOCK"
#define MAXSEG 32 
#define WRITE_SMART_MAGIC  3141  /* write tftp data to smart */
#define BOOT_SMART_MAGIC   9876  /* Start an Smartmedia */
#define REBOOT_MAGIC   9123  /* restart old image ? */
#define EXTRA_BOOT     0xdead /* Load named image */

struct segment { void *base; long len; };  /* len MUST be Multiple of 512 */

struct arnold_bootheader {
  char magic[16];
  long exec_adr;
  long nosegs;
  struct segment lseg[MAXSEG];
  long stack_p;
  short debuggit;
  short writesmart;
  unsigned short extrafile;
  char otherfile[20];

  char reserved[1];  /* reserved for future use */
};
union bootblock {
  char buffer[512];
  struct arnold_bootheader boot;
};

