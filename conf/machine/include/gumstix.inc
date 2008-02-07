#@TYPE: Machine
#@Name: Gumstix pxa2xx boards
#@DESCRIPTION:  Gumstix pxa2xx boards

# Don't edit this file unless you *really* know what you are doing!

TARGET_ARCH = "arm"
PACKAGE_EXTRA_ARCHS = "armv4 armv4t armv5e armv5te "

PREFERRED_PROVIDER_virtual/kernel = "gumstix-kernel"
KERNEL_IMAGETYPE = "uImage"
RDEPENDS_kernel-base = ""
KERNEL_IMAGE_MAXSIZE = "1048577"

UBOOT_ENTRYPOINT = "a0008000"

MACHINE_FEATURES += "kernel26 "
COMBINED_FEATURES ?= ""

IMAGE_FSTYPES = "jffs2"
EXTRA_IMAGECMD_jffs2 = "--little-endian --eraseblock=0x20000 --squash-uids"

SERIAL_CONSOLE = "115200 ttyS0 vt100"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS =     " \
                                       "

MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS ?= " \
                                       "
#
# The following *should* be in a distro.conf file
# We include them here to avoid creating a new distro

PREFERRED_VERSION_gumstix-kernel = "2.6.21"
PREFERRED_VERSION_udev = "115"
PREFERRED_VERSION_gnuplot = "4.0.0"
PREFERRED_VERSION_dropbear = "0.47"
PREFERRED_VERSION_wpa-supplicant = "0.5.8"
PREFERRED_VERSION_bluez-utils = "3.24"
PREFERRED_VERSION_bluez-utils-alsa = "3.24"
PREFERRED_VERSION_bluez-libs = "3.24"
PREFERRED_VERSION_bluez-gstreamer-plugin = "3.24"
PREFERRED_VERSION_bluez-hcidump = "1.40"

