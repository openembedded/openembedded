require linux.inc

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_mpc8313e-rdb = "1"

PR = "r4"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.24.tar.bz2 \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-2.6.24.7.bz2;patch=1;p=1 \
           ${KERNELORG_MIRROR}/pub/linux/kernel/projects/rt/patch-2.6.24.7-rt11.bz2;patch=1;p=1 \
           http://kamikaze.waninkoko.info/patches/2.6.24/kamikaze1/broken-out/squashfs-lzma-2.6.24.patch;patch=1 \
           file://powerpc-clockres.patch;patch=1 \
           file://leds-cpu-activity.patch;patch=1 \
           file://leds-cpu-activity-powerpc.patch;patch=1 \
           file://defconfig"

#           file://sysctl_missing_include.patch;patch=1 \

S = "${WORKDIR}/linux-2.6.24"

SRC_URI_append_mpc8313e-rdb = "\
	file://mpc8313e-rdb-leds.patch;patch=1"
#	file://mpc831x-nand.patch;patch=1 \
#	file://mpc8313e-rdb-rtc.patch;patch=1 "

