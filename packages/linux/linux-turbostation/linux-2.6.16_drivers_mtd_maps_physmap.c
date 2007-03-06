Index: linux-2.6.21-rc2-git3/drivers/mtd/maps/physmap.c
===================================================================
--- linux-2.6.21-rc2-git3.orig/drivers/mtd/maps/physmap.c	2007-03-06 01:06:56.000000000 +0100
+++ linux-2.6.21-rc2-git3/drivers/mtd/maps/physmap.c	2007-03-06 01:12:35.000000000 +0100
@@ -134,13 +134,43 @@
 	}
 	info->mtd->owner = THIS_MODULE;
 
+static struct mtd_partition TS101_partitions[] = {
+	{
+	  .name = "u-boot",
+	  .offset = 0x00F00000,
+	  .size = 0x00040000,
+	  .mask_flags = MTD_WRITEABLE,  /* force read-only */
+	},
+	{
+	  .name = "kernel",             /* default kernel image */
+	  .offset = 0x00000000,
+	  .size = 0x00280000,
+	},
+	{
+	  .name = "rootfs",
+	  .offset = 0x00280000,
+	  .size = 0x00C80000,
+	},
+	{
+	  .name = "empty",
+	  .offset = 0x00F40000,
+	  .size = 0x000A0000,
+	},
+	{
+	  .name = "u-boot env",
+	  .offset = 0x00FE0000,
+	  .size = 0x00020000,
+	}
+};
+
+
 #ifdef CONFIG_MTD_PARTITIONS
 	err = parse_mtd_partitions(info->mtd, part_probe_types, &info->parts, 0);
 	if (err > 0) {
 		add_mtd_partitions(info->mtd, info->parts, err);
 		return 0;
 	}
-
+	physmap_set_partitions(TS101_partitions, 5);
 	if (physmap_data->nr_parts) {
 		printk(KERN_NOTICE "Using physmap partition information\n");
 		add_mtd_partitions(info->mtd, physmap_data->parts,
