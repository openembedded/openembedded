require linux.inc

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/${P}.tar.bz2;name=kernel \
           file://defconfig"

SRC_URI[kernel.md5sum] = "c3883760b18d50e8d78819c54d579b00"
SRC_URI[kernel.sha256sum] = "63e237de3b3c4c46a21833b9ce7e20574548d52dabbd1a8bf376041e4455d5c6"
