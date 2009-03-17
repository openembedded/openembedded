Index: linux-2.6.20.2/drivers/mtd/maps/physmap.c
===================================================================
--- linux-2.6.20.2.orig/drivers/mtd/maps/physmap.c	2007-03-11 15:22:25.000000000 +0100
+++ linux-2.6.20.2/drivers/mtd/maps/physmap.c	2007-03-11 15:28:18.000000000 +0100
@@ -134,13 +134,53 @@
 	}
 	info->mtd->owner = THIS_MODULE;
 
+static struct mtd_partition TS101_partitions[] = {
+	{
+	  .name = "u-boot",
+	  .offset = 0x00F00000,
+	  .size = 0x00040000,
+	  .mask_flags = MTD_WRITEABLE,
+	},
+	{
+	  .name = "kernel",
+	  .offset = 0x00000000,
+	  .size = 0x00200000,
+	},
+	{
+	  .name = "rootfs",
+	  .offset = 0x00200000,
+	  .size = 0x00D00000,
+	},
+	{
+	  .name = "u-boot env",
+	  .offset = 0x00F40000,
+	  .size = 0x00020000,
+	},
+	{
+	  .name = "u-boot2",
+	  .offset = 0x00F60000,
+	  .size = 0x00040000,
+	},
+	{
+	  .name = "u-boot2 env",
+	  .offset = 0x00FA0000,
+	  .size = 0x00020000,
+	},
+	{
+	  .name = "sysconf",
+	  .offset = 0x00FC0000,
+	  .size = 0x00040000,
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
