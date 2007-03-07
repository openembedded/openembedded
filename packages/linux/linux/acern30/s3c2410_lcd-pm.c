Index: linux-2.6.14/drivers/video/backlight/s3c2410_lcd.c
===================================================================
--- linux-2.6.14.orig/drivers/video/backlight/s3c2410_lcd.c
+++ linux-2.6.14/drivers/video/backlight/s3c2410_lcd.c
@@ -248,10 +248,75 @@ static int s3c2410bl_remove(struct devic
 
 }
 
+#ifdef CONFIG_PM
+
+static int s3c2410bl_suspend(struct device *dev, pm_message_t state)
+{
+	struct s3c2410_bl_mach_info *info =
+		(struct s3c2410_bl_mach_info *)dev->platform_data;
+
+	if (info) {
+		if (info->backlight_power)
+			info->backlight_power(0);
+		if (info->lcd_power)
+			info->lcd_power(0);
+	}
+
+	return 0;
+}
+
+static int s3c2410bl_resume(struct device *dev)
+{
+	struct s3c2410_bl_mach_info *info =
+		(struct s3c2410_bl_mach_info *)dev->platform_data;
+
+	if (info) {
+		if (info->lcd_power) {
+			switch(info->lcd_power_value) {
+			case FB_BLANK_NORMAL:
+			case FB_BLANK_POWERDOWN:
+				info->lcd_power(0);
+				break;
+			default:
+			case FB_BLANK_VSYNC_SUSPEND:
+			case FB_BLANK_HSYNC_SUSPEND:
+			case FB_BLANK_UNBLANK:
+				info->lcd_power(1);
+				break;
+			}
+		}
+		if (info->backlight_power) {
+			switch(info->backlight_power_value) {
+			case FB_BLANK_NORMAL:
+			case FB_BLANK_VSYNC_SUSPEND:
+			case FB_BLANK_HSYNC_SUSPEND:
+			case FB_BLANK_POWERDOWN:
+				info->backlight_power(0);
+				break;
+			default:
+			case FB_BLANK_UNBLANK:
+				info->backlight_power(1);
+				break;
+			}
+		}
+		if (info->set_brightness)
+			info->set_brightness(info->brightness_value);
+	}
+
+	return 0;
+}
+
+#else
+#define s3c2410bl_suspend NULL
+#define s3c2410bl_resume  NULL
+#endif
+
 static struct device_driver s3c2410bl_driver = {
 	.name		= "s3c2410-bl",
 	.bus		= &platform_bus_type,
 	.probe		= s3c2410bl_probe,
+	.suspend        = s3c2410bl_suspend,
+	.resume         = s3c2410bl_resume,
 	.remove		= s3c2410bl_remove,
 };
 
