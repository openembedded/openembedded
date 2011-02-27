require linux-kexecboot.inc

PR = "${INC_PR}.1"

S = "${WORKDIR}/linux-${PV}"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"

SRC_URI += "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
            file://defconfig"

SRC_URI_append_collie = " file://collie-locomo-kb.patch;status=upstream "

SRC_URI[kernel.md5sum] = "61f3739a73afb6914cb007f37fb09b62"
SRC_URI[kernel.sha256sum] = "15a076d1a435a6bf8e92834eba4b390b4ec094ce06d47f89d071ca9e5788ce04"
