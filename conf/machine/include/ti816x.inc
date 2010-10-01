TARGET_ARCH = "arm"
SOC_FAMILY = "ti816x"

require conf/machine/include/tune-cortexa8.inc

PREFERRED_PROVIDER_virtual/kernel = "linux-omap3"
PREFERRED_PROVIDER_virtual/bootloader = "u-boot"

# Increase this everytime you change something in the kernel
MACHINE_KERNEL_PR = "r1"

KERNEL_IMAGETYPE = "uImage"

UBOOT_ARCH = "arm"
UBOOT_MACHINE = "ti816x_evm_config"
UBOOT_ENTRYPOINT = "0x80008000"
UBOOT_LOADADDRESS = "0x80008000"

# Only build u-boot
EXTRA_IMAGEDEPENDS += "u-boot"

# Ship all kernel modules
IMAGE_FSTYPES += "jffs2 tar.bz2"
EXTRA_IMAGECMD_jffs2 = "-lnp -e 0x20000 -s 2048"
SERIAL_CONSOLE = "115200 ttyS2"
MACHINE_FEATURES = "kernel26 apm usbgadget usbhost vfat ext2 ethernet"
