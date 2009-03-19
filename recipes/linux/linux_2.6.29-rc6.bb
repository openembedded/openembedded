require linux.inc

PV = "2.6.28+2.6.29-rc6"

S = "${WORKDIR}/linux-2.6.28"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_vortex86sx = "1"
DEFAULT_PREFERENCE_tosa = "1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/testing/linux-2.6.28.tar.bz2 \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/testing/patch-2.6.29-rc6.bz2;patch=1 \
           file://defconfig"

SRC_URI_append_tosa = " \
	file://0001--tosa-Set-a-bus_id-for-the-tc6393xb-so-that-the-clk.patch;patch=1 \
	"

