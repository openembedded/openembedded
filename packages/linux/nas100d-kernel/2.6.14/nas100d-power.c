/*
 * arch/arm/mach-ixp4xx/nas100d-power.c
 *
 * NAS 100d Power/Reset driver
 *
 * Copyright (C) 2005 Tower Technologies
 *
 * based on nas100d-io.c
 *  Copyright (C) 2004 Karen Spearel
 *
 * Author: Alessandro Zummo <a.zummo@towertech.it>
 * Maintainers: http://www.nslu2-linux.org/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2 as
 * published by the Free Software Foundation.
 *
 */

#include <linux/module.h>
#include <linux/reboot.h>
#include <linux/interrupt.h>

#include <asm/mach-types.h>

extern void ctrl_alt_del(void);

static irqreturn_t nas100d_power_handler(int irq, void *dev_id, struct pt_regs *regs)
{
	/* Signal init to do the ctrlaltdel action, this will bypass init if
	 * it hasn't started and do a kernel_restart.
	 */
	ctrl_alt_del();

	return IRQ_HANDLED;
}

static irqreturn_t nas100d_reset_handler(int irq, void *dev_id, struct pt_regs *regs)
{
	/* This is the paper-clip reset, it shuts the machine down directly.
	 */
	machine_power_off();

	return IRQ_HANDLED;
}

static int __init nas100d_power_init(void)
{
	if (!(machine_is_nas100d()))
		return 0;

	// *IXP4XX_GPIO_GPISR = 0x20400000;	/* read the 2 irqs to clr */

	set_irq_type(NAS100D_RB_IRQ, IRQT_LOW);
//	set_irq_type(NAS100D_PB_IRQ, IRQT_HIGH);

	gpio_line_isr_clear(NAS100D_RB_GPIO);
//	gpio_line_isr_clear(NAS100D_PB_GPIO);

	if (request_irq(NAS100D_RB_IRQ, &nas100d_reset_handler,
		SA_INTERRUPT, "NAS100D reset button", NULL) < 0) {

		printk(KERN_DEBUG "Reset Button IRQ %d not available\n",
			NAS100D_RB_IRQ);

		return -EIO;
	}
/*
	if (request_irq(NAS100D_PB_IRQ, &nas100d_power_handler,
		SA_INTERRUPT, "NAS100D power button", NULL) < 0) {

		printk(KERN_DEBUG "Power Button IRQ %d not available\n",
			NAS100D_PB_IRQ);

		return -EIO;
	}
*/
	return 0;
}

static void __exit nas100d_power_exit(void)
{
	free_irq(NAS100D_RB_IRQ, NULL);
//	free_irq(NAS100D_PB_IRQ, NULL);
}

module_init(nas100d_power_init);
module_exit(nas100d_power_exit);

MODULE_AUTHOR("Alessandro Zummo <a.zummo@towertech.it>");
MODULE_DESCRIPTION("NAS100D Power/Reset driver");
MODULE_LICENSE("GPL");
