require linux-kexecboot.inc

S = "${WORKDIR}/linux-${PV}"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_akita = "-1"
DEFAULT_PREFERENCE_c7x0 = "-1"
DEFAULT_PREFERENCE_collie = "-1"
DEFAULT_PREFERENCE_poodle = "-1"
DEFAULT_PREFERENCE_spitz = "-1"
DEFAULT_PREFERENCE_tosa = "-1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
           file://defconfig"

SRC_URI[kernel.md5sum] = "260551284ac224c3a43c4adac7df4879"
SRC_URI[kernel.sha256sum] = "5099786d80b8407d98a619df00209c2353517f22d804fdd9533b362adcb4504e"

# For Zaurus we still need old RP patches (see linux-rp.inc)
# in order to boot from nand
RPSRC = "http://www.rpsys.net/openzaurus/patches/archive"

SRC_URI += "${RPSRC}/pxa-linking-bug.patch;patch=1;status=unmergable \
           "
