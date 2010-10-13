# use this for overrides
MACHINE_CLASS = "motorola-ezx"

#
# Hardware-based properties
#
TARGET_ARCH = "arm"

# Use tune-xscale per default. Machine independent feeds should be built with tune-strongarm.
require conf/machine/include/tune-xscale.inc

# Uncomment this to use iwmmxt optimizations. Remove the above xscale stuff first
#require conf/machine/include/tune-iwmmxt.inc

#cat /proc/mtd
#dev:    size   erasesize  name
#mtd0: 00020000 00008000 "Bootloader"
#mtd1: 000e0000 00020000 "Kernel"
#mtd2: 00580000 00020000 "VFM_Filesystem"
#mtd3: 00020000 00020000 "Logo"

ROOT_FLASH_SIZE = "24"
MACHINE_GUI_CLASS = "smallscreen"
MACHINE_DISPLAY_WIDTH_PIXELS = "240"
MACHINE_DISPLAY_HEIGHT_PIXELS = "320"
MACHINE_DISPLAY_ORIENTATION = "0"
MACHINE_DISPLAY_PPI = "180"
MACHINE_FEATURES = "alsa apm bluetooth kernel26 keyboard phone screen touchscreen usbgadget usbhost vfat"
MACHINE_FEATURES += " iwmmxt"

# Comment this out if you change to tune-iwmmxt.inc above
PACKAGE_EXTRA_ARCHS += "iwmmxt"

#
# Software/packages selection
#
PREFERRED_PROVIDER_virtual/kernel ?= "openezx-kernel"
MODUTILS = "26"
XSERVER = "xserver-kdrive-fbdev"
PREFERRED_PROVIDER_virtual/xserver = "xserver-kdrive"

IMAGE_FSTYPES ?= "jffs2"
EXTRA_IMAGECMD_jffs2 = "--pad=14680064 --little-endian --eraseblock=0x20000 -n"

# In order to enable UIBIFS add "uibi and ubifs"
#IMAGE_FSTYPES += "ubi ubifs"

# From dmesg:
# UBI: smallest flash I/O unit:    1
# UBI: logical eraseblock size:    131072 bytes
# from ubiattach stdout:
# UBI device number 0, total 1996 LEBs
MKUBIFS_ARGS = "-m 1 -e 130944 -c 487"

# from dmesg:
# UBI: smallest flash I/O unit:    1
# UBI: physical eraseblock size:   131072 bytes (128 KiB)
# UBI: sub-page size:              512
UBINIZE_ARGS = "-m 1 -p 128KiB "


EXTRA_IMAGEDEPENDS += "moto-boot-usb-native ezx-gen-blob"

IMAGE_INSTALL_append += "\
  kernel-module-ohci-hcd \
  kernel-module-moto-usb-ipc \
  kernel-module-ts27010mux \
"

# Ezxd needs to be started very early so we need the mux devices in static /dev
IMAGE_DEVICE_TABLES = "files/device_table-minimal.txt \
                       files/device_table-ezx.txt"

SERIAL_CONSOLE = "115200 ttyS0"
