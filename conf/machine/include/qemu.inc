PCMCIA_MANAGER = "pcmciautils"
PREFERRED_PROVIDER_virtual/xserver = "xserver-xorg"
XSERVER = "xserver-xorg \
           xf86-input-evdev \
           xf86-input-tslib \
           xf86-input-mouse \
           xf86-video-fbdev \
           xf86-input-keyboard"
GUI_MACHINE_CLASS = "bigscreen"

MACHINE_FEATURES = "kernel26 apm alsa pcmcia bluetooth irda usbgadget screen keyboard touchscreen"

IMAGE_FSTYPES ?= "tar.bz2 ext2"

ROOT_FLASH_SIZE = "230"
IMAGE_ROOTFS_SIZE_ext2 ?= "230000"

# Don't include kernels in standard images
RDEPENDS_kernel-base = ""

EXTRA_IMAGEDEPENDS += "qemu-native"
