PCMCIA_MANAGER = "pcmciautils"
PREFERRED_PROVIDER_xserver = "xserver-kdrive"
GUI_MACHINE_CLASS = "bigscreen"

MACHINE_FEATURES = "kernel26 apm alsa pcmcia bluetooth irda usbgadget screen keyboard touchscreen"

IMAGE_FSTYPES ?= "tar.bz2 ext2"

ROOT_FLASH_SIZE = "230"
IMAGE_ROOTFS_SIZE_ext2 ?= "230000"

# Don't include kernels in standard images
RDEPENDS_kernel-base = ""
