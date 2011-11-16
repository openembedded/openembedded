# Common description for Atmel ARM processors running 2.6.39

TARGET_ARCH = "arm"
#PACKAGE_EXTRA_ARCHS = "armv4t armv5te"
SOC_FAMILY = "at91"

require conf/machine/include/tune-arm926ejs.inc

PREFERRED_PROVIDER_virtual/kernel = "linux"
PREFERRED_VERSION_linux = "2.6.39.2"
PREFERRED_VERSION_webkit-gtk = "1.2.3"
PREFERRED_VERSION_tslib = "1.0+git%"
PREFERRED_PROVIDER_bash = "bash"


PREFERRED_PROVIDER_at91bootstrap = "at91bootstrap"
PREFERRED_VERSION_at91bootstrap = "3.1.2"

PREFERRED_PROVIDER_u-boot = "u-boot"
PREFERRED_VERSION_u-boot = "2010.06"

KERNEL_IMAGETYPE = "uImage"

#don't try to access tty1
USE_VT = "0"

MACHINE_FEATURES = " kernel26 alsa ext2 usbgadget vfat uboot "

# Some options we disable for now
# MACHINE_FEATURES += "apm"
# MACHINE_FEATURES += "lcd"
# MACHINE_FEATURES += "bluetooth wifi irda phone gps"
# MACHINE_FEATURES += "mmc mmcroot fat"
# MACHINE_FEATURES += "i2c spi serial"
# MACHINE_FEATURES += "sound libogg libvorbis"

EXTRA_IMAGEDEPENDS += "u-boot"
EXTRA_IMAGEDEPENDS += "at91bootstrap"

MACHINE_EXTRA_RDEPENDS += " kernel-modules "
#MACHINE_EXTRA_RDEPENDS += " atmel-fixes "

# used by sysvinit_2
SERIAL_CONSOLE = "115200 ttyS0"

IMAGE_FSTYPES ?= "jffs2 ubi ubifs"
EXTRA_IMAGECMD_jffs2 = "--pad --little-endian --eraseblock=0x20000 --pagesize=0x800 -n"
UBI_VOLNAME = "rootfs"
MKUBIFS_ARGS = "-m 2KiB -e 124KiB -c 1984"
UBINIZE_ARGS = "-m 2KiB -p 128KiB -s 2048"

#
# Uncomment or add kernel modules that should be autoloaded
#module_autoload_g_file_storage = ${@base_contains('MACHINE_FEATURES', 'usbgadget',  'g_file_storage', '',d)}
#module_autoload_g_ether        = ${@base_contains('MACHINE_FEATURES', 'usbgadget',  'g_ether', '',d)}
module_autoload_g_serial       = ${@base_contains('MACHINE_FEATURES', 'usbgadget',  'g_serial', '',d)}


