SOC_FAMILY = "mx28"
TARGET_ARCH = "arm"

require conf/machine/include/tune-arm926ejs.inc

PREFERRED_PROVIDER_virtual/bootloader = "u-boot"

# Increase this everytime you change something in the kernel
MACHINE_KERNEL_PR = "r0"

KERNEL_IMAGETYPE = "uImage"

UBOOT_ENTRYPOINT = "0x40008000"
UBOOT_LOADADDRESS = "0x40008000"

EXTRA_IMAGEDEPENDS += "u-boot"

IMAGE_FSTYPES += "jffs2 tar.bz2"

