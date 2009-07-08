require linux.inc

PR = "r1"

S = "${WORKDIR}/linux-${PV}"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_mpc8315e-rdb = "1"
DEFAULT_PREFERENCE_mx27ads = "1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
           http://maxim.org.za/AT91RM9200/2.6/2.6.30-at91.patch.gz;patch=1 \
           file://defconfig"

SRC_URI_append_mpc8315e-rdb = " file://mpc8315erdb-add-msi-to-dts.patch;patch=1"
