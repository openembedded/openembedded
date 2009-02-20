require linux.inc

PV = "2.6.28+2.6.29-rc5"

S = "${WORKDIR}/linux-2.6.28"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_vortex86sx = "1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/testing/linux-2.6.28.tar.bz2 \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/testing/patch-2.6.29-rc5.bz2;patch=1 \
           file://defconfig"
