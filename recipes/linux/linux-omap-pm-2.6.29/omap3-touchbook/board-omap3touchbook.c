/*
 * linux/arch/arm/mach-omap2/board-omap3touchbook.c
 *
 * Copyright (C) 2009 Always Innovating
 *
 * Modified from mach-omap2/board-omap3beagleboard.c
 *
 * Initial code: Grégoire Gentil, Tim Yamin
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2 as
 * published by the Free Software Foundation.
 */

#include <linux/kernel.h>
#include <linux/init.h>
#include <linux/platform_device.h>
#include <linux/delay.h>
#include <linux/err.h>
#include <linux/clk.h>
#include <linux/io.h>
#include <linux/leds.h>
#include <linux/gpio.h>
#include <linux/input.h>
#include <linux/gpio_keys.h>

#include <linux/mtd/mtd.h>
#include <linux/mtd/partitions.h>
#include <linux/mtd/nand.h>

#include <mach/mcspi.h>
#include <linux/spi/spi.h>
#include <linux/spi/ads7846.h>
#include <linux/mma7455l.h>

#include <mach/dmtimer.h>
#include <linux/backlight.h>

#include <linux/regulator/machine.h>
#include <linux/i2c/twl4030.h>
#include <linux/omapfb.h>

#include <mach/hardware.h>
#include <asm/mach-types.h>
#include <asm/mach/arch.h>
#include <asm/mach/map.h>
#include <asm/mach/flash.h>

#include <mach/board.h>
#include <mach/usb.h>
#include <mach/common.h>
#include <mach/gpmc.h>
#include <mach/nand.h>
#include <mach/mux.h>
#include <mach/omap-pm.h>
#include <mach/clock.h>
#include <mach/display.h>


#include "twl4030-generic-scripts.h"
#include "mmc-twl4030.h"
#include "pm.h"
#include "omap3-opp.h"


#define GPMC_CS0_BASE  0x60
#define GPMC_CS_SIZE   0x30

#define NAND_BLOCK_SIZE		SZ_128K

#define OMAP3_AC_GPIO		136 //Int1 DRDY
#define OMAP3_TS_GPIO		162
#define OMAP3_CHACHA_GPIO	154
#define TB_BL_PWM_TIMER		9
#define TB_KILL_POWER_GPIO	168

unsigned int ai_revision = 2;

static struct mtd_partition omap3touchbook_nand_partitions[] = {
	/* All the partition sizes are listed in terms of NAND block size */
	{
		.name		= "X-Loader",
		.offset		= 0,
		.size		= 4 * NAND_BLOCK_SIZE,
		.mask_flags	= MTD_WRITEABLE,	/* force read-only */
	},
	{
		.name		= "U-Boot",
		.offset		= MTDPART_OFS_APPEND,	/* Offset = 0x80000 */
		.size		= 15 * NAND_BLOCK_SIZE,
		.mask_flags	= MTD_WRITEABLE,	/* force read-only */
	},
	{
		.name		= "U-Boot Env",
		.offset		= MTDPART_OFS_APPEND,	/* Offset = 0x260000 */
		.size		= 1 * NAND_BLOCK_SIZE,
	},
	{
		.name		= "Kernel",
		.offset		= MTDPART_OFS_APPEND,	/* Offset = 0x280000 */
		.size		= 32 * NAND_BLOCK_SIZE,
	},
	{
		.name		= "File System",
		.offset		= MTDPART_OFS_APPEND,	/* Offset = 0x680000 */
		.size		= MTDPART_SIZ_FULL,
	},
};

static struct omap_nand_platform_data omap3touchbook_nand_data = {
	.options	= NAND_BUSWIDTH_16,
	.parts		= omap3touchbook_nand_partitions,
	.nr_parts	= ARRAY_SIZE(omap3touchbook_nand_partitions),
	.dma_channel	= -1,		/* disable DMA in OMAP NAND driver */
	.nand_setup	= NULL,
	.dev_ready	= NULL,
};

static struct resource omap3touchbook_nand_resource = {
	.flags		= IORESOURCE_MEM,
};

static struct platform_device omap3touchbook_nand_device = {
	.name		= "omap2-nand",
	.id		= -1,
	.dev		= {
		.platform_data	= &omap3touchbook_nand_data,
	},
	.num_resources	= 1,
	.resource	= &omap3touchbook_nand_resource,
};

#include "sdram-micron-mt46h32m32lf-6.h"

static struct omap_uart_config omap3_touchbook_uart_config __initdata = {
	.enabled_uarts	= ((1 << 0) | (1 << 1) | (1 << 2)),
};

static struct twl4030_usb_data touchbook_usb_data = {
	.usb_mode	= T2_USB_MODE_ULPI,
};

static struct twl4030_hsmmc_info mmc[] = {
	{
		.mmc		= 1,
		.wires		= 8,
		.gpio_wp	= 29,
	},
	{}	/* Terminator */
};

static struct regulator_consumer_supply touchbook_vmmc1_supply = {
	.supply			= "vmmc",
};

static struct regulator_consumer_supply touchbook_vsim_supply = {
	.supply			= "vmmc_aux",
};

static struct gpio_led gpio_leds[];

static int touchbook_twl_gpio_setup(struct device *dev,
		unsigned gpio, unsigned ngpio)
{
	/* gpio + 0 is "mmc0_cd" (input/IRQ) */
	omap_cfg_reg(AH8_34XX_GPIO29);
	mmc[0].gpio_cd = gpio + 0;
	twl4030_mmc_init(mmc);

	/* link regulators to MMC adapters */
	touchbook_vmmc1_supply.dev = mmc[0].dev;
	touchbook_vsim_supply.dev = mmc[0].dev;

	/* REVISIT: need ehci-omap hooks for external VBUS
	 * power switch and overcurrent detect
	 */

#if 0 /* TODO: This needs to be modified to not rely on u-boot */
	gpio_request(gpio + 1, "EHCI_nOC");
	gpio_direction_input(gpio + 1);

	/* TWL4030_GPIO_MAX + 0 == ledA, EHCI nEN_USB_PWR (out, active low) */
	gpio_request(gpio + TWL4030_GPIO_MAX, "nEN_USB_PWR");
	gpio_direction_output(gpio + TWL4030_GPIO_MAX, 1);

	/* TWL4030_GPIO_MAX + 1 == ledB, PMU_STAT (out, active low LED) */
	gpio_leds[2].gpio = gpio + TWL4030_GPIO_MAX + 1;
#endif
	return 0;
}

static struct twl4030_gpio_platform_data touchbook_gpio_data = {
	.gpio_base	= OMAP_MAX_GPIO_LINES,
	.irq_base	= TWL4030_GPIO_IRQ_BASE,
	.irq_end	= TWL4030_GPIO_IRQ_END,
	.use_leds	= true,
	.pullups	= BIT(1),
	.pulldowns	= BIT(2) | BIT(6) | BIT(7) | BIT(8) | BIT(13)
				| BIT(15) | BIT(16) | BIT(17),
	.setup		= touchbook_twl_gpio_setup,
};

static struct platform_device omap3_touchbook_lcd_device = {
	.name		= "omap3touchbook_lcd",
	.id		= -1,
};

static struct regulator_consumer_supply touchbook_vdac_supply = {
	.supply		= "vdac",
	.dev		= &omap3_touchbook_lcd_device.dev,
};

static struct regulator_consumer_supply touchbook_vdvi_supply = {
	.supply		= "vdvi",
	.dev		= &omap3_touchbook_lcd_device.dev,
};

/* VMMC1 for MMC1 pins CMD, CLK, DAT0..DAT3 (20 mA, plus card == max 220 mA) */
static struct regulator_init_data touchbook_vmmc1 = {
	.constraints = {
		.min_uV			= 1850000,
		.max_uV			= 3150000,
		.valid_modes_mask	= REGULATOR_MODE_NORMAL
					| REGULATOR_MODE_STANDBY,
		.valid_ops_mask		= REGULATOR_CHANGE_VOLTAGE
					| REGULATOR_CHANGE_MODE
					| REGULATOR_CHANGE_STATUS,
	},
	.num_consumer_supplies	= 1,
	.consumer_supplies	= &touchbook_vmmc1_supply,
};

/* VSIM for MMC1 pins DAT4..DAT7 (2 mA, plus card == max 50 mA) */
static struct regulator_init_data touchbook_vsim = {
	.constraints = {
		.min_uV			= 1800000,
		.max_uV			= 3000000,
		.valid_modes_mask	= REGULATOR_MODE_NORMAL
					| REGULATOR_MODE_STANDBY,
		.valid_ops_mask		= REGULATOR_CHANGE_VOLTAGE
					| REGULATOR_CHANGE_MODE
					| REGULATOR_CHANGE_STATUS,
	},
	.num_consumer_supplies	= 1,
	.consumer_supplies	= &touchbook_vsim_supply,
};

/* VDAC for DSS driving S-Video (8 mA unloaded, max 65 mA) */
static struct regulator_init_data touchbook_vdac = {
	.constraints = {
		.min_uV			= 1800000,
		.max_uV			= 1800000,
		.valid_modes_mask	= REGULATOR_MODE_NORMAL
					| REGULATOR_MODE_STANDBY,
		.valid_ops_mask		= REGULATOR_CHANGE_MODE
					| REGULATOR_CHANGE_STATUS,
	},
	.num_consumer_supplies	= 1,
	.consumer_supplies	= &touchbook_vdac_supply,
};

/* VPLL2 for digital video outputs */
static struct regulator_init_data touchbook_vpll2 = {
	.constraints = {
		.name			= "VDVI",
		.min_uV			= 1800000,
		.max_uV			= 1800000,
		.valid_modes_mask	= REGULATOR_MODE_NORMAL
					| REGULATOR_MODE_STANDBY,
		.valid_ops_mask		= REGULATOR_CHANGE_MODE
					| REGULATOR_CHANGE_STATUS,
	},
	.num_consumer_supplies	= 1,
	.consumer_supplies	= &touchbook_vdvi_supply,
};

static const struct twl4030_resconfig touchbook_resconfig[] = {
	/* disable regulators that u-boot left enabled; the
	 * devices' drivers should be managing these.
	 */
	{ .resource = RES_VAUX3, },	/* not even connected! */
	{ .resource = RES_VMMC1, },
	{ .resource = RES_VSIM, },
	{ .resource = RES_VPLL2, },
	{ .resource = RES_VDAC, },
	{ .resource = RES_VUSB_1V5, },
	{ .resource = RES_VUSB_1V8, },
	{ .resource = RES_VUSB_3V1, },
	{ 0, },
};

static struct twl4030_power_data touchbook_power_data = {
	.resource_config	= touchbook_resconfig,
	/* REVISIT can't use GENERIC3430_T2SCRIPTS_DATA;
	 * among other things, it makes reboot fail.
	 */
};

static struct twl4030_bci_platform_data touchbook_bci_data = {
	.tblsize		= 0,
	.no_backup_battery	= 1,
};

static struct twl4030_madc_platform_data touchbook_madc_data = {
	.irq_line	= 1,
};

static struct twl4030_platform_data touchbook_twldata = {
	.irq_base	= TWL4030_IRQ_BASE,
	.irq_end	= TWL4030_IRQ_END,

	/* platform_data for children goes here */
	.usb		= &touchbook_usb_data,
	.gpio		= &touchbook_gpio_data,
	.power		= &touchbook_power_data,
	.vmmc1		= &touchbook_vmmc1,
	.vsim		= &touchbook_vsim,
	.vdac		= &touchbook_vdac,
	.vpll2		= &touchbook_vpll2,

	/* TouchBook BCI */
	.bci		= &touchbook_bci_data,
	.madc		= &touchbook_madc_data,
};

static struct i2c_board_info __initdata touchbook_i2c_boardinfo[] = {
	{
		I2C_BOARD_INFO("twl4030", 0x48),
		.flags = I2C_CLIENT_WAKE,
		.irq = INT_34XX_SYS_NIRQ,
		.platform_data = &touchbook_twldata,
	},
};

static struct i2c_board_info __initdata touchBook_i2c_boardinfo[] = {
	{
		I2C_BOARD_INFO("bq27200", 0x55),
	},
//	{
//		I2C_BOARD_INFO("chacha_mt8c", 0x40),
//		.irq = OMAP_GPIO_IRQ(OMAP3_CHACHA_GPIO),
//	},
};

static void __init omap3_touchbook_i2c_init(void)
{
	int ret;

	/* Standard TouchBook bus */
	omap_register_i2c_bus(1, 2600, touchbook_i2c_boardinfo,
			ARRAY_SIZE(touchbook_i2c_boardinfo));

	/* Additional TouchBook bus */
	omap_register_i2c_bus(3, 100, touchBook_i2c_boardinfo,
			ARRAY_SIZE(touchBook_i2c_boardinfo));

/*	ret = gpio_request(OMAP3_CHACHA_GPIO, "chacha_mt8c");
	if (ret < 0) {
		printk(KERN_ERR "Failed to request GPIO %d for chacha_mt8c IRQ\n", OMAP3_CHACHA_GPIO);
		return;
	}

	gpio_direction_input(OMAP3_CHACHA_GPIO);*/
	return;
}

static void __init omap3_ads7846_init(void)
{
	if (gpio_request(OMAP3_TS_GPIO, "ads7846_pen_down")) {
		printk(KERN_ERR "Failed to request GPIO %d for "
				"ads7846 pen down IRQ\n", OMAP3_TS_GPIO);
		return;
	}

	gpio_direction_input(OMAP3_TS_GPIO);
	omap_set_gpio_debounce(OMAP3_TS_GPIO, 1);
	omap_set_gpio_debounce_time(OMAP3_TS_GPIO, 0xa);
}

static struct ads7846_platform_data ads7846_config = {
	.x_min			= 100,
	.y_min			= 265,
	.x_max			= 3950,
	.y_max			= 3750,
	.x_plate_ohms		= 40,
	.pressure_max		= 255,
	.debounce_max		= 10,
	.debounce_tol		= 5,
	.debounce_rep		= 1,
	.gpio_pendown		= OMAP3_TS_GPIO,
	.keep_vref_on		= 1,
};

static struct omap2_mcspi_device_config ads7846_mcspi_config = {
	.turbo_mode	= 0,
	.single_channel	= 1,	/* 0: slave, 1: master */
};

static struct spi_board_info omap3_ads7846_spi_board_info[] __initdata = {
	{
		.modalias		= "ads7846",
		.bus_num		= 4,
		.chip_select		= 0,
		.max_speed_hz		= 1500000,
		.controller_data	= &ads7846_mcspi_config, //(void *) 161,
		.irq			= OMAP_GPIO_IRQ(OMAP3_TS_GPIO),
		.platform_data		= &ads7846_config,
	}
};

static void __init omap3_touchbook_init_irq(void)
{
	omap2_init_common_hw(mt46h32m32lf6_sdrc_params, omap3_mpu_rate_table,
						 omap3_dsp_rate_table, omap3_l3_rate_table);
	omap_init_irq();
	omap_gpio_init();
}

static struct gpio_led gpio_leds[] = {
	{
		.name			= "touchbook::usr0",
		.default_trigger	= "heartbeat",
		.gpio			= 150,
	},
	{
		.name			= "touchbook::usr1",
		.default_trigger	= "mmc0",
		.gpio			= 149,
	},
	{
		.name			= "touchbook::pmu_stat",
		.gpio			= -EINVAL,	/* gets replaced */
		.active_low		= true,
	},
};

static struct gpio_led_platform_data gpio_led_info = {
	.leds		= gpio_leds,
	.num_leds	= ARRAY_SIZE(gpio_leds),
};

static struct platform_device leds_gpio = {
	.name	= "leds-gpio",
	.id	= -1,
	.dev	= {
		.platform_data	= &gpio_led_info,
	},
};

static struct gpio_keys_button gpio_buttons[] = {
	{
		.code			= BTN_EXTRA,
		.gpio			= 7,
		.desc			= "user",
		.wakeup			= 1,
	},
	{
		.code			= KEY_POWER,
		.gpio			= 183,
		.desc			= "power",
		.wakeup			= 1,
		.active_low		= 1,
	},
};

static struct gpio_keys_platform_data gpio_key_info = {
	.buttons	= gpio_buttons,
	.nbuttons	= ARRAY_SIZE(gpio_buttons),
};

static struct platform_device keys_gpio = {
	.name	= "gpio-keys",
	.id	= -1,
	.dev	= {
		.platform_data	= &gpio_key_info,
	},
};

/* DSS */

static int touchbook_enable_dvi(struct omap_display *display)
{
	if (display->hw_config.panel_reset_gpio != -1)
		gpio_set_value(display->hw_config.panel_reset_gpio, 1);

	return 0;
}

static void touchbook_disable_dvi(struct omap_display *display)
{
	if (display->hw_config.panel_reset_gpio != -1)
		gpio_set_value(display->hw_config.panel_reset_gpio, 0);
}

static struct omap_dss_display_config touchbook_display_data_dvi = {
	.type = OMAP_DISPLAY_TYPE_DPI,
	.name = "dvi",
	.panel_name = "panel-generic",
	.u.dpi.data_lines = 24,
	.panel_reset_gpio = 176,
	.panel_enable = touchbook_enable_dvi,
	.panel_disable = touchbook_disable_dvi,
};


static int touchbook_panel_enable_tv(struct omap_display *display)
{
#define ENABLE_VDAC_DEDICATED           0x03
#define ENABLE_VDAC_DEV_GRP             0x20

	twl4030_i2c_write_u8(TWL4030_MODULE_PM_RECEIVER,
			ENABLE_VDAC_DEDICATED,
			TWL4030_VDAC_DEDICATED);
	twl4030_i2c_write_u8(TWL4030_MODULE_PM_RECEIVER,
			ENABLE_VDAC_DEV_GRP, TWL4030_VDAC_DEV_GRP);

	return 0;
}

static void touchbook_panel_disable_tv(struct omap_display *display)
{
	twl4030_i2c_write_u8(TWL4030_MODULE_PM_RECEIVER, 0x00,
			TWL4030_VDAC_DEDICATED);
	twl4030_i2c_write_u8(TWL4030_MODULE_PM_RECEIVER, 0x00,
			TWL4030_VDAC_DEV_GRP);
}

static struct omap_dss_display_config touchbook_display_data_tv = {
	.type = OMAP_DISPLAY_TYPE_VENC,
	.name = "tv",
	.u.venc.type = OMAP_DSS_VENC_TYPE_SVIDEO,
	.panel_enable = touchbook_panel_enable_tv,
	.panel_disable = touchbook_panel_disable_tv,
};

static struct omap_dss_board_info touchbook_dss_data = {
	.num_displays = 2,
	.displays = {
		&touchbook_display_data_dvi,
		&touchbook_display_data_tv,
	}
};

static struct platform_device touchbook_dss_device = {
	.name          = "omapdss",
	.id            = -1,
	.dev            = {
		.platform_data = &touchbook_dss_data,
	},
};

static void __init touchbook_display_init(void)
{
	int r;

	r = gpio_request(touchbook_display_data_dvi.panel_reset_gpio, "DVI reset");
	if (r < 0) {
		printk(KERN_ERR "Unable to get DVI reset GPIO\n");
		return;
	}

	gpio_direction_output(touchbook_display_data_dvi.panel_reset_gpio, 0);
}

static struct omap_board_config_kernel omap3_touchbook_config[] __initdata = {
	{ OMAP_TAG_UART,	&omap3_touchbook_uart_config },
};

static struct platform_device *omap3_touchbook_devices[] __initdata = {
	&touchbook_dss_device,
	&leds_gpio,
	&keys_gpio,
};

static void __init omap3touchbook_flash_init(void)
{
	u8 cs = 0;
	u8 nandcs = GPMC_CS_NUM + 1;

	u32 gpmc_base_add = OMAP34XX_GPMC_VIRT;

	/* find out the chip-select on which NAND exists */
	while (cs < GPMC_CS_NUM) {
		u32 ret = 0;
		ret = gpmc_cs_read_reg(cs, GPMC_CS_CONFIG1);

		if ((ret & 0xC00) == 0x800) {
			printk(KERN_INFO "Found NAND on CS%d\n", cs);
			if (nandcs > GPMC_CS_NUM)
				nandcs = cs;
		}
		cs++;
	}

	if (nandcs > GPMC_CS_NUM) {
		printk(KERN_INFO "NAND: Unable to find configuration "
				 "in GPMC\n ");
		return;
	}

	if (nandcs < GPMC_CS_NUM) {
		omap3touchbook_nand_data.cs = nandcs;
		omap3touchbook_nand_data.gpmc_cs_baseaddr = (void *)
			(gpmc_base_add + GPMC_CS0_BASE + nandcs * GPMC_CS_SIZE);
		omap3touchbook_nand_data.gpmc_baseaddr = (void *) (gpmc_base_add);

		printk(KERN_INFO "Registering NAND on CS%d\n", nandcs);
		if (platform_device_register(&omap3touchbook_nand_device) < 0)
			printk(KERN_ERR "Unable to register NAND device\n");
	}
}

static void __init omap3_mma7455l_init(void)
{
	int ret;

	ret = gpio_request(OMAP3_AC_GPIO, "mma7455l");
	if (ret < 0) {
		printk(KERN_ERR "Failed to request GPIO %d for mma7455l IRQ\n", OMAP3_AC_GPIO);
		return;
	}

	gpio_direction_input(OMAP3_AC_GPIO);
}

static struct mma7455l_platform_data mma7455l_config = {
	.calibration_x = -4, //26 for Beagleboard
	.calibration_y = 28, //44 for Beagleboard
	.calibration_z = -28, //26 for Beagleboard
};

static struct omap2_mcspi_device_config mma7455l_mcspi_config = {
	.turbo_mode	= 0,
	.single_channel	= 1,	/* 0: slave, 1: master */
};

static struct spi_board_info omap3_mma7455l_spi_board_info[] __initdata = {
	{
		.modalias		= "mma7455l",
		.bus_num		= 3,
		.chip_select		= 0,
		.max_speed_hz		= 200000,
		.irq			= OMAP_GPIO_IRQ(OMAP3_AC_GPIO),
		.controller_data	= &mma7455l_mcspi_config, //(void *) 135,
		.platform_data		= &mma7455l_config,
	}
};

static int touchbook_backlight_brightness = 50;
static struct omap_dm_timer *touchbook_backlight_pwm;

static int touchbook_backlight_read(struct backlight_device *bd)
{
	return touchbook_backlight_brightness;
}

static int touchbook_backlight_update(struct backlight_device *bd)
{
	int value = bd->props.brightness;
	touchbook_backlight_brightness = value;

	/* Frequency calculation:
	   - For 200Hz PWM, you want to load -164 (=> -32768Hz / 200Hz).
	   - Minimum duty cycle for the backlight is 15%.
	   - You have (164*0.85) => ~140 levels of brightness.
	*/

	/* Halve input brightness */
	value /= 2;

	/* For maximum brightness, just stop the timer... */
	if(value != bd->props.max_brightness)
	{
		/* Load the appropriate value for 200Hz PWM */
		u32 period = clk_get_rate(omap_dm_timer_get_fclk(touchbook_backlight_pwm)) / 200;

		/* Minimum duty cycle is 15% */
		u32 minimum = (period * 3) / 20;
		u32 maximum = (period * 17) / 20;

		/* Work out match value */
		u32 match = (maximum * value) / 100;

		/* Start... */
		omap_dm_timer_set_load(touchbook_backlight_pwm, 1, 0xFFFFFFFF - period - 1);
		omap_dm_timer_set_match(touchbook_backlight_pwm, 1, 0xFFFFFFFF - minimum - match);
		omap_dm_timer_write_counter(touchbook_backlight_pwm, -1);
		//omap_dm_timer_stop(touchbook_backlight_pwm);
		omap_dm_timer_start(touchbook_backlight_pwm);
	}
	else
		omap_dm_timer_stop(touchbook_backlight_pwm);


	return 0;
}

static struct backlight_ops touchbook_backlight_properties = {
	.get_brightness = touchbook_backlight_read,
	.update_status = touchbook_backlight_update,
};

static void __init omap3_touchbook_backlight_init(void)
{
	static struct backlight_device *bd;
	bd = backlight_device_register("touchbook", NULL, NULL, &touchbook_backlight_properties);

	if(bd)
	{
		touchbook_backlight_pwm = omap_dm_timer_request_specific(TB_BL_PWM_TIMER);
		omap_dm_timer_enable(touchbook_backlight_pwm);
		omap_dm_timer_set_source(touchbook_backlight_pwm, OMAP_TIMER_SRC_SYS_CLK);
		omap_dm_timer_set_pwm(touchbook_backlight_pwm, 1, 1, OMAP_TIMER_TRIGGER_OVERFLOW_AND_COMPARE);

		bd->props.max_brightness = 100;
		bd->props.brightness = touchbook_backlight_brightness;
	}

	touchbook_backlight_update(bd);
}

static void omap3_touchbook_poweroff(void)
{
	int r;

	r = gpio_request(TB_KILL_POWER_GPIO, "DVI reset");
	if (r < 0) {
		printk(KERN_ERR "Unable to get kill power GPIO\n");
		return;
	}

	gpio_direction_output(TB_KILL_POWER_GPIO, 0);
}

static int __init ai_revision_instance(char *str)
{
	if (!str)
		return -EINVAL;

	ai_revision = simple_strtoul(str, NULL, 10);

	return 0;
}

static void __init omap3_touchbook_init(void)
{
	pm_power_off = omap3_touchbook_poweroff;

	omap3_touchbook_i2c_init();
	platform_add_devices(omap3_touchbook_devices,
			ARRAY_SIZE(omap3_touchbook_devices));
	omap_board_config = omap3_touchbook_config;
	omap_board_config_size = ARRAY_SIZE(omap3_touchbook_config);
	omap_serial_init();

	omap_cfg_reg(J25_34XX_GPIO170);

	omap3touchbook_flash_init();
	touchbook_display_init();
	omap3_touchbook_backlight_init();

	/* Touch Book */
	spi_register_board_info(omap3_ads7846_spi_board_info, ARRAY_SIZE(omap3_ads7846_spi_board_info));
	spi_register_board_info(omap3_mma7455l_spi_board_info, ARRAY_SIZE(omap3_mma7455l_spi_board_info));

	omap3_ads7846_init();
	omap3_mma7455l_init();

	usb_musb_init();
	usb_ehci_init();
}

static void __init omap3_touchbook_map_io(void)
{
	omap2_set_globals_343x();
	omap2_map_common_io();
}

early_param("air", ai_revision_instance);

MACHINE_START(OMAP3_TOUCHBOOK, "OMAP3 Touch Book")
	/* Maintainer: Gregoire Gentil - http://www.alwaysinnovating.com */
	.phys_io	= 0x48000000,
	.io_pg_offst	= ((0xd8000000) >> 18) & 0xfffc,
	.boot_params	= 0x80000100,
	.map_io		= omap3_touchbook_map_io,
	.init_irq	= omap3_touchbook_init_irq,
	.init_machine	= omap3_touchbook_init,
	.timer		= &omap_timer,
MACHINE_END
