/*
 * arch/arm/mach-ixp4xx/nslu2-pci.c
 *
 * NSLU2 board-level PCI initialization
 *
 * based on ixdp425-pci.c:
 *	Copyright (C) 2002 Intel Corporation.
 *	Copyright (C) 2003-2004 MontaVista Software, Inc.
 *
 * Maintainer: http://www.nslu2-linux.org/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2 as
 * published by the Free Software Foundation.
 *
 */
// GPIO 8 is used as the power input so is not free for use as a PCI IRQ
// However, all the common PCI setup code presumes the standard 4 PCI
// interrupts are available.  So we compromise...we don't enable the
// IRQ on Pin 8 but we let

#include <linux/config.h>
#include <linux/pci.h>
#include <linux/init.h>
#include <linux/delay.h>

#include <asm/mach/pci.h>
#include <asm/irq.h>
#include <asm/hardware.h>
#include <asm/mach-types.h>

void __init nslu2_pci_preinit(void)
{
	gpio_line_config(NSLU2_PCI_INTA_PIN,
				IXP4XX_GPIO_IN | IXP4XX_GPIO_ACTIVE_LOW);
	gpio_line_config(NSLU2_PCI_INTB_PIN,
				IXP4XX_GPIO_IN | IXP4XX_GPIO_ACTIVE_LOW);
	gpio_line_config(NSLU2_PCI_INTC_PIN,
				IXP4XX_GPIO_IN | IXP4XX_GPIO_ACTIVE_LOW);
//	gpio_line_config(NSLU2_PCI_INTD_PIN,
//				IXP4XX_GPIO_IN | IXP4XX_GPIO_ACTIVE_LOW);

	gpio_line_isr_clear(NSLU2_PCI_INTA_PIN);
	gpio_line_isr_clear(NSLU2_PCI_INTB_PIN);
	gpio_line_isr_clear(NSLU2_PCI_INTC_PIN);
//	gpio_line_isr_clear(NSLU2_PCI_INTD_PIN);

	ixp4xx_pci_preinit();
}

static int __init nslu2_map_irq(struct pci_dev *dev, u8 slot, u8 pin)
{
	static int pci_irq_table[NSLU2_PCI_IRQ_LINES] = {
		IRQ_NSLU2_PCI_INTA,
		IRQ_NSLU2_PCI_INTB,
		IRQ_NSLU2_PCI_INTC,
//		IRQ_NSLU2_PCI_INTD
	};

	int irq = -1;

	if (slot >= 1 && slot <= NSLU2_PCI_MAX_DEV &&
		pin >= 1 && pin <= NSLU2_PCI_IRQ_LINES) {
		irq = pci_irq_table[(slot + pin - 2) % 3]; // ! % 4 kas11
	}

	return irq;
}

struct hw_pci __initdata nslu2_pci = {
	.nr_controllers = 1,
	.preinit	= nslu2_pci_preinit,
	.swizzle	= pci_std_swizzle,
	.setup		= ixp4xx_setup,
	.scan		= ixp4xx_scan_bus,
	.map_irq	= nslu2_map_irq,
};

int __init nslu2_pci_init(void)		//monkey see, monkey do
{
	if (machine_is_nslu2())
		pci_common_init(&nslu2_pci);
	return 0;
}

subsys_initcall(nslu2_pci_init);

