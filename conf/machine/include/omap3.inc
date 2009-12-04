SOC_FAMILY = "omap3"

require conf/machine/include/tune-cortexa8.inc
PREFERRED_PROVIDER_virtual/kernel = "linux-omap"
# Increase this everytime you change something in the kernel
MACHINE_KERNEL_PR = "r50"

KERNEL_IMAGETYPE = "uImage"

UBOOT_ENTRYPOINT = "0x80008000"
UBOOT_LOADADDRESS = "0x80008000"

# Only build u-boot, xload is optional
EXTRA_IMAGEDEPENDS += "u-boot"

# TI DVSDK stuff:
# DSPLink rebuild
DSPLINKDSPCFG     ?= "OMAP3530SHMEM"
DSPLINKGPPOS      ?= "OMAPLSP"
DSPLINKPLATFORM   ?= "OMAP3530"
DSPLINKSOC        ?= "3530"


