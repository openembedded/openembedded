# Zaurus common kernel settings

MACHINE_KERNEL_VERSION = "2.6"

PREFERRED_PROVIDER_virtual/kernel = "linux-rp"

# Starting with 2.6.32 linux-rp is deprecated for some models
#PREFERRED_PROVIDER_virtual/kernel = "linux"
PREFERRED_PROVIDER_virtual/kernel_collie = "linux"
PREFERRED_PROVIDER_virtual/kernel_tosa = "linux"

# Default bootloader expects "zImage", use "uImage" for u-boot
# Note: kexecboot can boot both kind of images
ZAURUS_KERNEL_IMAGETYPE ?= "zImage"
KERNEL_IMAGETYPE = "${ZAURUS_KERNEL_IMAGETYPE}"
