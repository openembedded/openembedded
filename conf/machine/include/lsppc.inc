#@TYPE: Machine configuration
#@Name: Buffalo PPC Linkstations
#@DESCRIPTION: Generic Machine configuration for ppc based linkstations

TARGET_ARCH = "powerpc"
PACKAGE_EXTRA_ARCHS = "ppc"

MACHINE_FEATURES = "kernel26 usbhost ext2"
MACHINE_EXTRA_RDEPENDS = "kernel-devicetree avr-evtd"
MACHINE_EXTRA_RRECOMMENDS = "u-boot-utils"

USE_DEVFS = "0"

BOOTSTRAP_EXTRA_RDEPENDS = "udev module-init-tools kernel-modules"
PREFERRED_PROVIDER_virtual/kernel = "linux-linkstationppc"

#don't try to access tty1
USE_VT = "0"

HOTPLUG = "udev"
udevdir = "/dev"

IMAGE_DEVICE_TABLES = "files/device_table-slugos.txt"
IMAGE_FSTYPES = "tar.gz"

KERNEL_IMAGETYPE = "uImage"
UBOOT_ENTRYPOINT = "0x00000000"
UBOOT_LOADADDRESS = "0x00000000"

require conf/machine/include/tune-ppc603e.inc
