TARGET_ARCH = "arm"
PACKAGE_EXTRA_ARCHS = "armv4 armv4t armv5te iwmmxt"

PREFERRED_PROVIDER_xserver = "xserver-kdrive"
PREFERRED_PROVIDER_virtual/kernel = "linux-ezx"

#cat /proc/mtd
#dev:    size   erasesize  name
#mtd0: 00020000 00008000 "Bootloader"
#mtd1: 000e0000 00020000 "Kernel"
#mtd2: 00580000 00020000 "VFM_Filesystem"
#mtd3: 00020000 00020000 "Logo"

MACHINE_FEATURES = "kernel26 touchscreen apm alsa bluetooth usbgadget usbhost keyboard screen"
MACHINE_FEATURES += "iwmmxt"


MACHINE_DISPLAY_WIDTH_PIXELS = "240"
MACHINE_DISPLAY_HEIGHT_PIXELS = "320"
MACHINE_DISPLAY_ORIENTATION = "0"
MACHINE_DISPLAY_PPI = "180"

ROOT_FLASH_SIZE = "24"

EXTRA_IMAGECMD_jffs2 = "--pad=14680064 --little-endian --eraseblock=0x20000 -n"

EXTRA_IMAGEDEPENDS += "ezx-boot-usb-native"

# the EZX phones need a userspace daemon to stop the BP from shutting down the phone
MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "ezxd"

# Ezxd needs to be started very early so we need the mux devices in static /dev
IMAGE_DEVICE_TABLES = "files/device_table-minimal.txt \
                       files/device_table-ezx.txt"

# Use tune-xscale per default. Machine independent feeds should be built with tune-strongarm.
require conf/machine/include/tune-xscale.inc

SERIAL_CONSOLE = "115200 ttyS0"
