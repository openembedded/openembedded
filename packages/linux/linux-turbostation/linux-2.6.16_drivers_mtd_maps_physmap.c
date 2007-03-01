Index: linux-2.6.20.1/drivers/mtd/maps/physmap.c
===================================================================
--- linux-2.6.20.1.orig/drivers/mtd/maps/physmap.c	2007-02-20 07:34:32.000000000 +0100
+++ linux-2.6.20.1/drivers/mtd/maps/physmap.c	2007-02-26 02:05:28.000000000 +0100
@@ -134,13 +134,53 @@
 	}
 	info->mtd->owner = THIS_MODULE;
 
+static struct mtd_partition TS101_partitions[] = {
+	{
+	  .name = "U-Boot",
+	  .offset = 0x00F00000,
+	  .size = 0x00040000,
+	  .mask_flags = MTD_WRITEABLE,  /* force read-only */
+	},
+	{
+	  .name = "Kernel",             /* default kernel image */
+	  .offset = 0x00000000,
+	  .size = 0x00200000,
+	},
+	{
+	  .name = "RootFS1",
+	  .offset = 0x00200000,
+	  .size = 0x00900000,
+	},
+	{
+	  .name = "RootFS2",
+	  .offset = 0x00b00000,
+	  .size = 0x00300000,
+	},
+	{
+	  .name = "Vendor",
+	  .offset = 0x00E00000,
+	  .size = 0x00100000,
+	},
+	{
+	  .name = "U-Boot Config",
+	  .offset = 0x00F40000,
+	  .size = 0x00020000,
+	},
+	{
+	  .name = "NAS Config",
+	  .offset = 0x00F60000,
+	  .size = 0x000A0000,
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
+	physmap_set_partitions(TS101_partitions, 7);
 	if (physmap_data->nr_parts) {
 		printk(KERN_NOTICE "Using physmap partition information\n");
 		add_mtd_partitions(info->mtd, physmap_data->parts,
