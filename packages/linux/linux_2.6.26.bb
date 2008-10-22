require linux.inc

PR = "r1"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_mpc8313e-rdb = "1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.26.tar.bz2 \
           file://defconfig"

SRC_URI_append_mpc8313e-rdb = "\
	file://mpc831x-nand.patch;patch=1 \
	file://mpc8313e-rdb-leds.patch;patch=1 \
	file://mpc8313e-rdb-cardbus.patch;patch=1 \
	file://mpc8313e-rdb-eth-fixed.patch;patch=1 \
	"

# see http://bugzilla.kernel.org/show_bug.cgi?id=11143
do_stage_append() {
	if [ -f arch/${ARCH}/lib/crtsavres.o ]; then
		mkdir -p ${STAGING_KERNEL_DIR}/arch/${ARCH}/lib
		cp -a arch/${ARCH}/lib/crtsavres.o ${STAGING_KERNEL_DIR}/arch/${ARCH}/lib/
	fi
}

