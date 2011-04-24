require linux-kexecboot.inc

PR = "${INC_PR}.3"

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
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.4.bz2;apply=yes;name=stablepatch \
            file://defconfig"

SRC_URI[kernel.md5sum] = "7d471477bfa67546f902da62227fa976"
SRC_URI[kernel.sha256sum] = "72f0cfaefb8dc86b219d5a742dd0375332627641ecbdf5badd3158e2127b9304"
SRC_URI[stablepatch.md5sum] = "6ef1279c7bd0078fc0fd50aa83e86203"
SRC_URI[stablepatch.sha256sum] = "64abfd999ac9416db143293528f73a0b88ac287bf4d075556dc7859017d97687"
