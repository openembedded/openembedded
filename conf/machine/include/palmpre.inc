# use this for overrides
MACHINE_CLASS = "palmpre"

TARGET_ARCH = "arm"

PREFERRED_PROVIDER_virtual/xserver = "xserver-xorg"
XSERVER = "xserver-xorg \
           xf86-input-evdev \
           xf86-input-mouse \
           xf86-video-omapfb \
           xf86-input-keyboard"

MACHINE_DISPLAY_WIDTH_PIXELS = "320"
MACHINE_DISPLAY_HEIGHT_PIXELS = "480"
MACHINE_DISPLAY_ORIENTATION = "0"
MACHINE_DISPLAY_PPI = "185"

require conf/machine/include/omap3.inc

# Copied from include/omap3.inc (as we do not use linux-omap recipes):
# Increase this everytime you change something in the kernel
MACHINE_KERNEL_PR = "r93"

PREFERRED_PROVIDER_virtual/kernel = "linux-palmpre"

IMAGE_FSTYPES += "tar.gz"

# Let's keep the following three from the beagleboard machine config
UBOOT_MACHINE = "omap3_beagle_config"
PREFERRED_VERSION_u-boot = "git"
XLOAD_MACHINE = "omap3530beagle_config"

MACHINE_FEATURES = "kernel26 screen apm usbgadget usbhost vfat alsa phone bluetooth touchscreen keyboard wifi"
MACHINE_EXTRA_RDEPENDS = " \
 tsmd \
 read-tokens \
 tellbootie \
 lvm2 \
 palmpre-audio-scripts \
 compat-wireless-2.6-old \
"

PREFERRED_PROVIDER_udev-compat = "udev-compat141"
