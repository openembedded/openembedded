require linux.inc

PR = "r4"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_sheevaplug = "1"
DEFAULT_PREFERENCE_openrd-base = "1"
DEFAULT_PREFERENCE_openrd-client = "1"
DEFAULT_PREFERENCE_qemuppc = "1"
DEFAULT_PREFERENCE_qemuarm = "1"
DEFAULT_PREFERENCE_qemux86 = "1"
DEFAULT_PREFERENCE_qemush4 = "1"
DEFAULT_PREFERENCE_qemumips = "1"
DEFAULT_PREFERENCE_qemumipsel = "1"
DEFAULT_PREFERENCE_qemumips64 = "1"
DEFAULT_PREFERENCE_visstrim_m10 = "1"
# needs more testing before making it new default
# DEFAULT_PREFERENCE_om-gta02 = "1"
# DEFAULT_PREFERENCE_om-gta01 = "1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.2.bz2;apply=yes;name=stablepatch \
           file://defconfig "

SRC_URI_append_om-gta02 = " \
           file://openmoko.patch \
           file://shr.patch \
           "
SRC_URI_append_om-gta01 = " \
           file://openmoko.patch \
           file://shr.patch \
           "

SRC_URI[kernel.md5sum] = "c8ee37b4fdccdb651e0603d35350b434"
SRC_URI[kernel.sha256sum] = "edbf091805414739cf57a3bbfeba9e87f5e74f97e38f04d12060e9e0c71e383a"
SRC_URI[stablepatch.md5sum] = "bb5798f2a2a5af13219d1a250c4dad11"
SRC_URI[stablepatch.sha256sum] = "3d65f2fb5f0018e8dafda4abe68d947d2ab5e21c386062cb0d6e011244a16aef"
