require linux-kexecboot.inc

PR = "${INC_PR}.1"

S = "${WORKDIR}/linux-${PV}"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"

DEFAULT_PREFERENCE_akita = "1"
DEFAULT_PREFERENCE_c7x0 = "1"
DEFAULT_PREFERENCE_collie = "1"
DEFAULT_PREFERENCE_poodle = "1"
DEFAULT_PREFERENCE_spitz = "1"
DEFAULT_PREFERENCE_tosa = "1"

SRC_URI += "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.2.bz2;apply=yes;name=stablepatch \
            file://defconfig"

SRC_URI[kernel.md5sum] = "7d471477bfa67546f902da62227fa976"
SRC_URI[kernel.sha256sum] = "72f0cfaefb8dc86b219d5a742dd0375332627641ecbdf5badd3158e2127b9304"
SRC_URI[stablepatch.md5sum] = "599badab31c4920d4122133208c810d7"
SRC_URI[stablepatch.sha256sum] = "8279d5b883cb44f4d3cf28b4db9b3c37c9c6dba45bb5884e8601950ee59892c4"
