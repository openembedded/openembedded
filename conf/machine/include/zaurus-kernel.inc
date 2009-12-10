# Zaurus common kernel settings

MACHINE_KERNEL_VERSION = "2.6"

PREFERRED_PROVIDER_virtual/kernel = "linux-rp"

# Starting with 2.6.32 linux-rp is deprecated
#PREFERRED_PROVIDER_virtual/kernel = "linux"
PREFERRED_PROVIDER_virtual/kernel_collie = "linux"
PREFERRED_PROVIDER_virtual/kernel_tosa = "linux"

KERNEL_IMAGE_MAXSIZE = "1294336"
KERNEL_IMAGE_MAXSIZE_collie = "1048576"

ZAURUS_KERNEL_IMAGETYPE ?= "zImage"
KERNEL_IMAGETYPE = "${ZAURUS_KERNEL_IMAGETYPE}"
