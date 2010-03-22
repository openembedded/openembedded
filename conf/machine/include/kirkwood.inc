#@TYPE: Machine
#@DESCRIPTION: Machine configuration for various different Marvell Kirkwood based devices

TARGET_ARCH = "arm"

MACHINE_FEATURES 		= "kernel26 usbhost ext2 vfat mmc"
MACHINE_TASK_PROVIDER 		= "task-base"

USE_DEVFS = "0"

PREFERRED_PROVIDER_virtual/bootloader = ""
PREFERRED_PROVIDER_virtual/kernel = "linux-kirkwood"

MACHINE_KERNEL_PR = "r18"

IMAGE_FSTYPES += "tar.gz ubi"
SERIAL_CONSOLE = "ttyS0 115200"

# Currently all the orion devices we support use uImage
KERNEL_IMAGETYPE = "uImage"
UBOOT_ENTRYPOINT = "0x00008000"
UBOOT_LOADADDRESS = "0x00008000"

require conf/machine/include/tune-arm926ejs.inc
