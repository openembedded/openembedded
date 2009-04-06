require conf/machine/include/tune-cortexa8.inc
PREFERRED_PROVIDER_virtual/kernel = "linux-omap"
MACHINE_KERNEL_PR = "r20" 

KERNEL_IMAGETYPE = "uImage"

UBOOT_ENTRYPOINT = "0x80008000"
UBOOT_LOADADDRESS = "0x80008000"

EXTRA_IMAGEDEPENDS += "u-boot x-load"

MACHINE_EXTRA_RRECOMMENDS = " omap3-sgx-modules "
