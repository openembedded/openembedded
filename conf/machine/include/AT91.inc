# Common description for Atmel ARM processors

TARGET_ARCH = "arm"
#PACKAGE_EXTRA_ARCHS = "armv4t armv5te"
CPU_FAMILY = "at91"

PREFERRED_PROVIDER_virtual/kernel = "linux"
PREFERRED_VERSION_linux = "2.6.32"

#PREFERRED_PROVIDER_virtual/xserver = "xserver-kdrive"
#PREFERRED_PROVIDER_virtual/xserver = "xserver-kdrive-1300"
#PREFERRED_PROVIDER_virtual/xserver = "xserver-xorg"
#PREFERRED_PROVIDER_xserver = "xserver-xorg"
#PREFERRED_PROVIDER_xserver = "xserver-kdrive"
#XSERVER = "xserver-kdrive-fbdev"
# Angstrom defines:
#PREFERRED_VERSION_xserver-kdrive = "1.4.0.90"
#PREFERRED_VERSION_xserver-kdrive = "1.6.1"

PREFERRED_PROVIDER_at91bootstrap = "at91bootstrap_2.13"
PREFERRED_VERSION_at91bootstrap = "2.13"

PREFERRED_PROVIDER_u-boot = "u-boot_2009.08"
PREFERRED_VERSION_u-boot = "2009.08"

KERNEL_IMAGETYPE = "uImage"

# PREFERRED_VERSION_mplayer = "svn"

#don't try to access tty1
USE_VT = "0"

MACHINE_FEATURES = " kernel26 alsa ext2 usbgadget vfat uboot "
EXTRA_IMAGEDEPENDS += "u-boot"
EXTRA_IMAGEDEPENDS += "at91bootstrap"

MACHINE_EXTRA_RDEPENDS += " kernel-modules "
#MACHINE_EXTRA_RDEPENDS += " atmel-fixes "

# used by sysvinit_2
SERIAL_CONSOLE = "115200 ttyS0"
IMAGE_FSTYPES ?= "jffs2"
EXTRA_IMAGECMD_jffs2 = "--pad --little-endian --eraseblock=0x20000 -n"
#
# Uncomment or add kernel modules that should be autoloaded
#module_autoload_g_file_storage = ${@base_contains('MACHINE_FEATURES', 'usbgadget',  'g_file_storage', '',d)}
#module_autoload_g_ether        = ${@base_contains('MACHINE_FEATURES', 'usbgadget',  'g_ether', '',d)}
module_autoload_g_serial       = ${@base_contains('MACHINE_FEATURES', 'usbgadget',  'g_serial', '',d)}

require conf/machine/include/tune-arm926ejs.inc

