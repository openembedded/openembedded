/*
 * arch/arm/mach-ixp4xx/nas100d-pci.c
 *
 * NAS 100d board-level PCI initialization
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

#include <linux/config.h>
#include <linux/pci.h>
#include <linux/init.h>

#include <asm/mach/pci.h>
#include <asm/mach-types.h>

void __init nas100d_pci_preinit(void)
{
	set_irq_type(IRQ_NAS100D_PCI_INTA, IRQT_LOW);
	set_irq_type(IRQ_NAS100D_PCI_INTB, IRQT_LOW);
	set_irq_type(IRQ_NAS100D_PCI_INTC, IRQT_LOW);
	set_irq_type(IRQ_NAS100D_PCI_INTD, IRQT_LOW);
	set_irq_type(IRQ_NAS100D_PCI_INTE, IRQT_LOW);

	gpio_line_isr_clear(NAS100D_PCI_INTA_PIN);
	gpio_line_isr_clear(NAS100D_PCI_INTB_PIN);
	gpio_line_isr_clear(NAS100D_PCI_INTC_PIN);
	gpio_line_isr_clear(NAS100D_PCI_INTD_PIN);
	gpio_line_isr_clear(NAS100D_PCI_INTE_PIN);

	ixp4xx_pci_preinit();
}

static int __init nas100d_map_irq(struct pci_dev *dev, u8 slot, u8 pin)
{
	if (slot < 1 || slot > 3 || pin < 1 || pin > 3)
		return -1;

	switch (slot)
	{
	case 1:
		if (pin == 1)
			return IRQ_NAS100D_PCI_INTA;
		break;
	case 2:
		if (pin == 1)
			return IRQ_NAS100D_PCI_INTB;
		break;
	case 3:
		if (pin == 1)
			return IRQ_NAS100D_PCI_INTC;
		if (pin == 2)
			return IRQ_NAS100D_PCI_INTD;
		if (pin == 3)
			return IRQ_NAS100D_PCI_INTE;
		break;
	}

	return -1;
}

struct hw_pci __initdata nas100d_pci = {
	.nr_controllers = 1,
	.preinit	= nas100d_pci_preinit,
	.swizzle	= pci_std_swizzle,
	.setup		= ixp4xx_setup,
	.scan		= ixp4xx_scan_bus,
	.map_irq	= nas100d_map_irq,
};

int __init nas100d_pci_init(void)
{
	if (machine_is_nas100d())
		pci_common_init(&nas100d_pci);

	return 0;
}

subsys_initcall(nas100d_pci_init);
