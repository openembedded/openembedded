#@TYPE: Machine
#@Name: AFEB9260 development board http://www.oshw.ru/

TARGET_ARCH = "arm"
#PACKAGE_EXTRA_ARCHS = "armv4t armv5te"

PREFERRED_PROVIDER_virtual/kernel = "linux"
PREFERRED_PROVIDER_xserver = "xserver-kdrive"
XSERVER = "xserver-kdrive-fbdev"

KERNEL_IMAGETYPE = "uImage"

#don't try to access tty1
USE_VT = "0"

MACHINE_FEATURES = "kernel26 ext2 usbhost usbgadget"
EXTRA_IMAGEDEPENDS += "at91bootstrap u-boot"

# used by sysvinit_2
SERIAL_CONSOLE = "115200 ttyS0"
IMAGE_FSTYPES ?= "jffs2"
EXTRA_IMAGECMD_jffs2 = "--pad --little-endian --eraseblock=0x20000 -n"

require conf/machine/include/tune-arm926ejs.inc
