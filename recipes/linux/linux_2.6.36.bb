require linux.inc

PR = "r4"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_mx31ads = "1"
DEFAULT_PREFERENCE_warpcomm = "1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/${P}.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.1.bz2;apply=yes;name=stablepatch \
           file://defconfig "

SRC_URI_append_mx31ads = "file://0001-add-missing-include.patch"

SRC_URI_append_warpcomm = "http://www.warpcomm.org/downloads/tk71/20101028/linux-2.6.36-tk71.diff;apply=yes;name=warpcommpatch"

SRC_URI[kernel.md5sum] = "61f3739a73afb6914cb007f37fb09b62"
SRC_URI[kernel.sha256sum] = "15a076d1a435a6bf8e92834eba4b390b4ec094ce06d47f89d071ca9e5788ce04"
SRC_URI[stablepatch.md5sum] = "dd38a6caf08df2822f93541ee95aed7d"
SRC_URI[stablepatch.sha256sum] = "0312883792d9b6312684800c7e9c108571a0da39fbb0a4fb9beb1362b7446c98"
SRC_URI[warpcommpatch.md5sum] = "d8970406654afbeab4c1e4fd648b499c"
SRC_URI[warpcommpatch.sha256sum] = "7ec088d01b7d96b712e1477630bdb5f67b146bf298d9f80f375b1fa6aea7902d"
