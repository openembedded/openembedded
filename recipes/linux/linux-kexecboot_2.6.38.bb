require linux-kexecboot.inc

PR = "${INC_PR}.2"

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
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.3.bz2;apply=yes;name=stablepatch \
            file://defconfig"

SRC_URI[kernel.md5sum] = "7d471477bfa67546f902da62227fa976"
SRC_URI[kernel.sha256sum] = "72f0cfaefb8dc86b219d5a742dd0375332627641ecbdf5badd3158e2127b9304"
SRC_URI[stablepatch.md5sum] = "b3677121c4b5efcb8128c2000788d0aa"
SRC_URI[stablepatch.sha256sum] = "cc7fe37725d940987800c73c38484e7c8388936b332fca9918aae4dca15be10b"
