require linux.inc

PR = "r1"

S = "${WORKDIR}/linux-${PV}"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_db1200 = "1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
	   ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.1.bz2;patch=1 \
           http://maxim.org.za/AT91RM9200/2.6/2.6.31-at91.patch.gz;patch=1 \
           file://defconfig"

SRC_URI_append_ep93xx = " \
	file://edb9301-fix-machine-id.patch;patch=1 \
	"
