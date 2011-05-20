require linux.inc

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_spitz = "1"
#DEFAULT_PREFERENCE_om-gta02 = "1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
           file://defconfig "

SRC_URI_append_om-gta02 = " \
           file://openmoko.patch \
           "

SRC_URI_append_spitz = " file://${LOGO_SIZE}/logo_linux_clut224.ppm.bz2 "

SRC_URI[kernel.md5sum] = "1aab7a741abe08d42e8eccf20de61e05"
SRC_URI[kernel.sha256sum] = "584d17f2a3ee18a9501d7ff36907639e538cfdba4529978b8550c461d45c61f6"
