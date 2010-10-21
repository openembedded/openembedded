require linux.inc

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/${P}.tar.bz2;name=kernel \
           file://defconfig "

SRC_URI[kernel.md5sum] = "61f3739a73afb6914cb007f37fb09b62"
SRC_URI[kernel.sha256sum] = "15a076d1a435a6bf8e92834eba4b390b4ec094ce06d47f89d071ca9e5788ce04"
