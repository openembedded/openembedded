#@TYPE: Machine
#@DESCRIPTION: Machine configuration for various different Marvell Orion based devices

TARGET_ARCH = "arm"
TARGET_FPU  = "soft"

MACHINE_FEATURES 		= "kernel26 usbhost ext2 pci"
MACHINE_TASK_PROVIDER 		= "task-base"

USE_DEVFS = "0"

PREFERRED_PROVIDER_virtual/bootloader = ""
PREFERRED_PROVIDER_virtual/kernel = "linux-orion"
PREFERRED_VERSION_linux-orion = "2.6.27.10"

IMAGE_DEVICE_TABLES = "files/device_table-slugos.txt"
IMAGE_FSTYPES = "tar.gz"
SERIAL_CONSOLE = "ttyS0 115200"

require conf/machine/include/tune-arm926ejs.inc
