require linux-kexecboot.inc

PR = "${INC_PR}.0"

S = "${WORKDIR}/linux-${PV}"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"

SRC_URI += "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
            file://defconfig"

SRC_URI[kernel.md5sum] = "7d471477bfa67546f902da62227fa976"
SRC_URI[kernel.sha256sum] = "72f0cfaefb8dc86b219d5a742dd0375332627641ecbdf5badd3158e2127b9304"
