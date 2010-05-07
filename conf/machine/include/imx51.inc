require conf/machine/include/tune-cortexa8.inc
PREFERRED_PROVIDER_virtual/kernel = "linux"
# Increase this everytime you change something in the kernel

KERNEL_IMAGETYPE = "uImage"

UBOOT_ENTRYPOINT = "0x90008000"
UBOOT_LOADADDRESS = "0x90008000"

EXTRA_IMAGEDEPENDS += "u-boot"

