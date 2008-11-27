require linux.inc

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_progear = "1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
           file://defconfig "

SRC_URI_append_progear = "file://progear-bl.patch;patch=1\
                          file://progear-ac2.patch;patch=1"

# see http://bugzilla.kernel.org/show_bug.cgi?id=11143
do_stage_append() {
	if [ -f arch/${ARCH}/lib/crtsavres.o ]; then
		mkdir -p ${STAGING_KERNEL_DIR}/arch/${ARCH}/lib
		cp -a arch/${ARCH}/lib/crtsavres.o ${STAGING_KERNEL_DIR}/arch/${ARCH}/lib/
	fi
}

