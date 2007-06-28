#include <sys/mount.h>
#include <stdio.h>
#include <fcntl.h>
#include <linux/loop.h>
#include <dirent.h>
#include <errno.h>
#include <sys/mman.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>

#define PREFIX
//#define PREFIX "/boot"
#define SQUASHFS_FILENAME PREFIX"/mnt/flash/squashfs"

#define streq(a,b) (strcmp((a),(b)) == 0)

/* This really needs to be in a header file... */
extern long init_module(void *, unsigned long, const char *);

/* We use error numbers in a loose translation... */
static const char *moderror(int err)
{
	switch (err) {
	case ENOEXEC:
		return "Invalid module format";
	case ENOENT:
		return "Unknown symbol in module";
	case ESRCH:
		return "Module has wrong symbol version";
	case EINVAL:
		return "Invalid parameters";
	default:
		return strerror(err);
	}
}

static void *grab_file(const char *filename, unsigned long *size)
{
	unsigned int max = 16384;
	int ret, fd;
	void *buffer = malloc(max);

	if (streq(filename, "-"))
		fd = dup(STDIN_FILENO);
	else
		fd = open(filename, O_RDONLY, 0);

	if (fd < 0)
		return NULL;

	*size = 0;
	while ((ret = read(fd, buffer + *size, max - *size)) > 0) {
		*size += ret;
		if (*size == max)
			buffer = realloc(buffer, max *= 2);
	}
	if (ret < 0) {
		free(buffer);
		buffer = NULL;
	}
	close(fd);
	return buffer;
}


int insmod(const char *filename)
{
	void *file;
	unsigned long len;
	long int ret;


	file = grab_file(filename, &len);
	if (!file) {
		fprintf(stderr, "insmod: can't read '%s': %s\n",
			filename, strerror(errno));
		return 1;
	}

	ret = init_module(file, len, "");
	if (ret != 0) {
		fprintf(stderr, "insmod: error inserting '%s': %li %s\n",
			filename, ret, moderror(errno));
		return 1;
	}
	return 0;
}

int main(int argc, char *argv[], char *envp[])
{
	int res, x;

		/* first, load some needed kernel modules located in the root of our boot partition */
	const char *modules[] = { "fs/squashfs/unlzma.ko", "fs/squashfs/sqlzma.ko", "fs/squashfs/squashfs.ko", "fs/unionfs.ko", "drivers/block/loop.ko", 0 };
	const char *modules_path = PREFIX"/lib/modules/2.6.12.6/kernel/";
	char path[255];

	printf("Hello world!\n");

	x=0;
	while(modules[x]) {
		strcpy(path, modules_path);
		strcat(path, modules[x++]);
		printf("insmodding %s..\n", path);
		if (insmod(path))
			return 1;
	}
	
		/* mount the RW jffs2 partition, which contains the squashfs image (in /squashfs) and the deltas (in /delta) */
	printf("mounting mtd...\n");
	res = mount("/dev/mtdblock/3", PREFIX"/mnt/flash", "jffs2", 0, 0);

	if (res)
	{
		perror("mounting /flash");
		return res;
	}
	
		/* loop-mount the squashfs, by first connecting the file to loop0 ... */
	printf("opening squashfs...\n");
	int squashfs_fd = open(SQUASHFS_FILENAME, O_RDONLY);
	if (squashfs_fd < 0)
	{
		perror(SQUASHFS_FILENAME);
		return 1;
	}
	
	printf("setup loop\n");
	int loop_fd = open("/dev/loop/0", O_RDONLY);
	
	if (loop_fd < 0)
	{
		perror("/dev/loop/0");
		return 1;
	}
	
	struct loop_info loopinfo;

	memset(&loopinfo, 0, sizeof(loopinfo));
	strncpy(loopinfo.lo_name, SQUASHFS_FILENAME, LO_NAME_SIZE);
	loopinfo.lo_offset = 0;
	loopinfo.lo_encrypt_key_size = 0;
	if (ioctl(loop_fd, LOOP_SET_FD, (void*)squashfs_fd) < 0) {
		perror("LOOP_SET_FD");
		return 1;
	}
	if (ioctl(loop_fd, LOOP_SET_STATUS, &loopinfo) < 0) {
		perror("LOOP_SET_STATUS");
		return 1;
	}
	close(loop_fd);
	close(squashfs_fd);

	printf("mounting squashfs..\n");

		/* and then mounting the loop device. */
	if (mount("/dev/loop/0", PREFIX"/mnt/squashfs", "squashfs", MS_MGC_VAL|MS_RDONLY, "") < 0)
	{
		perror("mounting squashfs");
		return 1;
	}
	
		/* now the situation is:
		
			/                     - our boot jffs2 partition
			/flash                - our RW jffs2 partition
			/flash/squashfs       - our loop-mounted squashfs file,
			/flash/delta          - the delta for the root
			/squashfs             - RO root
			/root                 - yet empty, but we will populate it using unionfs 
		*/
	
	
	printf("mounting unionfs..\n");
	res = mount("none", PREFIX"/mnt/root", "unionfs", MS_MGC_VAL, "dirs="PREFIX"/mnt/flash/delta=rw:"PREFIX"/mnt/squashfs=ro");
	if (res < 0)
	{
		perror("mounting unionfs");
		return 1;
	}

	printf("pivot_root\n");
	if ( pivot_root(PREFIX"/mnt/root", PREFIX"/mnt/root/boot") < 0)
	{
		perror("pivot_root");
		return 1;
	}

	printf("mounting devfs..\n");
	res = mount("none", "/dev", "devfs", 0, 0);
	if (res)
	{
		perror("mounting /dev");
		return res;
	}
	
	printf("try umount old devfs..\n");
	res = umount("/boot/dev");
	perror("umount /boot/dev");

	printf("call init!\n");
	execve("/sbin/init", argv, envp);
	perror("/sbin/init");
	
	return 1;
}
