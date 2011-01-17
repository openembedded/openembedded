require linux.inc

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
# needs more testing before making it new default
# DEFAULT_PREFERENCE_om-gta02 = "1"
# DEFAULT_PREFERENCE_om-gta01 = "1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
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
