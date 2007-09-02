#@TYPE: Machine configuration
#@Name: Buffalo PPC Linkstations
#@DESCRIPTION: Generic Machine configuration for ppc based linkstations


TARGET_ARCH = "powerpc"
PACKAGE_EXTRA_ARCHS = "ppc ppc603e"
MACHINE_FEATURES = "kernel26 usbhost ext2 pci uboot"
TARGET_FPU = "hard"

USE_DEVFS = "0"

BOOTSTRAP_EXTRA_RDEPENDS = "udev module-init-tools kernel-modules"
PREFERRED_PROVIDER_virtual/kernel = "linux-linkstationppc"

#don't try to access tty1
USE_VT = "0"

HOTPLUG = "udev"
udevdir = "/dev"

IMAGE_DEVICE_TABLES = "files/device_table-slugos.txt"
IMAGE_FSTYPES = "tar.gz"

#tune for the MPC5200B cpu
require conf/machine/include/tune-ppc603e.inc
