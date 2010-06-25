require linux-kexecboot.inc

PR = "${INC_PR}.1"

S = "${WORKDIR}/linux-${PV}"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"

SRC_URI += "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
           file://ARM-Add-support-for-LZMA-compressed-kernel-images.patch;status=pending \
           file://use-noclone-attribute-for-naked.patch;status=pending \
           file://defconfig"

SRC_URI[kernel.md5sum] = "10eebcb0178fb4540e2165bfd7efc7ad"
SRC_URI[kernel.sha256sum] = "fa395fec7de633df1cb85b6248b8f35af98380ed128a8bc465fb48bc4d252633"

SRC_URI_append_c7x0 = " file://fix-corgi-card-detection.patch;status=pending "
