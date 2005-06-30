/*
 * nslu2-part.c
 *
 * Maintainers: http://www.nslu2-linux.org/
 * Initial port: Mark Rakes <mrakes AT mac.com>
 *
 * "Parse" the fixed partition table of the Linksys NSLU2 and
 * produce a Linux partition array to match.
 */

#include <linux/kernel.h>
#include <linux/slab.h>
#include <linux/init.h>
#include <linux/vmalloc.h>
#include <linux/mtd/mtd.h>
#include <linux/mtd/partitions.h>

/* info we know about the NSLU2's flash setup:
 *
 * Num	Partition		offset		size
 * ---	---------		----------	-----------
 * 0	RedBoot			0x00000000	0x00040000
 * 1	System Configuration	0x00040000	0x00020000
 * 2	Kernel			0x00060000	0x00100000
 * 3	Ramdisk			0x00160000	0x006a0000
 */
 #define NSLU2_NUM_FLASH_PARTITIONS	4
 #define NSLU2_FLASH_PART0_NAME		"RedBoot"
 #define NSLU2_FLASH_PART0_OFFSET	0x00000000
 #define NSLU2_FLASH_PART0_SIZE		0x00040000
 #define NSLU2_FLASH_PART1_NAME		"System Configuration"
 #define NSLU2_FLASH_PART1_OFFSET	(NSLU2_FLASH_PART0_OFFSET + NSLU2_FLASH_PART0_SIZE)
 #define NSLU2_FLASH_PART1_SIZE		0x00020000
 #define NSLU2_FLASH_PART2_NAME		"Kernel"
 #define NSLU2_FLASH_PART2_OFFSET	(NSLU2_FLASH_PART1_OFFSET + NSLU2_FLASH_PART1_SIZE)
 #define NSLU2_FLASH_PART2_SIZE		0x00100000
 #define NSLU2_FLASH_PART3_NAME		"Ramdisk"
 #define NSLU2_FLASH_PART3_OFFSET	(NSLU2_FLASH_PART2_OFFSET + NSLU2_FLASH_PART2_SIZE)
 #define NSLU2_FLASH_PART3_SIZE		0x006a0000

static int parse_nslu2_partitions(struct mtd_info *master,
                             struct mtd_partition **pparts,
                             unsigned long flash_start)
{
	struct mtd_partition *parts;
	int ret = 0, namelen = 0;
	char *names;

	namelen = strlen(NSLU2_FLASH_PART0_NAME) +
		  strlen(NSLU2_FLASH_PART1_NAME) +
		  strlen(NSLU2_FLASH_PART2_NAME) +
		  strlen(NSLU2_FLASH_PART3_NAME) +
		  NSLU2_NUM_FLASH_PARTITIONS; /*4 strings + each terminator */

	parts = kmalloc(sizeof(*parts)*NSLU2_NUM_FLASH_PARTITIONS + namelen, GFP_KERNEL);
	if (!parts) {
		ret = -ENOMEM;
		goto out;
	}

	memset(parts, 0, sizeof(*parts)*NSLU2_NUM_FLASH_PARTITIONS + namelen);
	names = (char *)&parts[NSLU2_NUM_FLASH_PARTITIONS];

	/* RedBoot partition */
	parts[0].size	= NSLU2_FLASH_PART0_SIZE;
	parts[0].offset	= NSLU2_FLASH_PART0_OFFSET;
	parts[0].name	= NSLU2_FLASH_PART0_NAME;
	parts[0].mask_flags = MTD_WRITEABLE; /* readonly */
	strcpy(names, NSLU2_FLASH_PART0_NAME);
	names += strlen(names)+1;
	/* System Configuration */
	parts[1].size	= NSLU2_FLASH_PART1_SIZE;
	parts[1].offset	= NSLU2_FLASH_PART1_OFFSET;
	parts[1].name	= NSLU2_FLASH_PART1_NAME;
	parts[1].mask_flags = MTD_WRITEABLE; /* readonly */
	strcpy(names, NSLU2_FLASH_PART1_NAME);
	names += strlen(names)+1;
	/* Kernel */
	parts[2].size	= NSLU2_FLASH_PART2_SIZE;
	parts[2].offset	= NSLU2_FLASH_PART2_OFFSET;
	parts[2].name	= NSLU2_FLASH_PART2_NAME;
	parts[2].mask_flags = MTD_WRITEABLE; /* readonly */
	strcpy(names, NSLU2_FLASH_PART2_NAME);
	names += strlen(names)+1;
	/* Ramdisk */
	parts[3].size	= NSLU2_FLASH_PART3_SIZE;
	parts[3].offset	= NSLU2_FLASH_PART3_OFFSET;
	parts[3].name	= NSLU2_FLASH_PART3_NAME;
	parts[3].mask_flags = MTD_WRITEABLE; /* readonly */
	strcpy(names, NSLU2_FLASH_PART3_NAME);
	names += strlen(names)+1;

	ret = NSLU2_NUM_FLASH_PARTITIONS;
	*pparts = parts;
 out:
	return ret;
}

static struct mtd_part_parser nslu2_parser = {
	.owner = THIS_MODULE,
	.parse_fn = parse_nslu2_partitions,
	.name = "NSLU2",
};

static int __init nslu2_parser_init(void)
{
	return register_mtd_parser(&nslu2_parser);
}

static void __exit nslu2_parser_exit(void)
{
	deregister_mtd_parser(&nslu2_parser);
}

module_init(nslu2_parser_init);
module_exit(nslu2_parser_exit);

MODULE_LICENSE("GPL");
MODULE_AUTHOR("Mark Rakes");
MODULE_DESCRIPTION("Parsing code for NSLU2 flash tables");
