Index: linux-2.6.20.1/drivers/net/r8169.c
===================================================================
--- linux-2.6.20.1.orig/drivers/net/r8169.c	2007-02-26 03:33:53.000000000 +0100
+++ linux-2.6.20.1/drivers/net/r8169.c	2007-02-26 03:34:21.000000000 +0100
@@ -1522,7 +1522,7 @@
 		goto err_out_disable_2;
 
 	/* save power state before pci_enable_device overwrites it */
-	pm_cap = pci_find_capability(pdev, PCI_CAP_ID_PM);
+	pm_cap = 220; // pci_find_capability(pdev, PCI_CAP_ID_PM)
 	if (pm_cap) {
 		u16 pwr_command, acpi_idle_state;
 
