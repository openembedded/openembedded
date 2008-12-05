require linux.inc

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_progear = "1"
DEFAULT_PREFERENCE_simpad = "1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
           file://defconfig "

SRC_URI_append_progear = "file://progear-bl.patch;patch=1\
                          file://progear-ac2.patch;patch=1"

SRC_URI_append_simpad = "\
           file://linux-2.6.27-SIMpad-GPIO-MMC-mod.patch;patch=1 \
           file://linux-2.6.24-SIMpad-battery-old-way-but-also-with-sysfs.patch;patch=1 \
           file://linux-2.6.27-SIMpad-cs3-simpad.patch;patch=1 \
           file://linux-2.6.27-SIMpad-mq200.patch;patch=1 \
           file://linux-2.6.27-SIMpad-pcmcia.patch;patch=1 \
           file://linux-2.6.27-SIMpad-serial-gpio_keys-and-cs3-ro.patch.v2;patch=1 \
           file://linux-2.6.24-SIMpad-ucb1x00-switches.patch;patch=1 \
           file://linux-2.6.27-SIMpad-ucb1x00-ts-supend-and-accuracy.patch;patch=1 \
           file://linux-2.6.24-SIMpad-hostap_cs-shared-irq.patch;patch=1 \
           file://linux-2.6.24-SIMpad-orinoco_cs-shared-irq.patch;patch=1 \
           file://linux-2.6.24-SIMpad-rtc-sa1100.patch;patch=1 \
           file://connectplus-remove-ide-HACK.patch;patch=1 \
           "

# see http://bugzilla.kernel.org/show_bug.cgi?id=11143
do_stage_append() {
	if [ -f arch/${ARCH}/lib/crtsavres.o ]; then
		mkdir -p ${STAGING_KERNEL_DIR}/arch/${ARCH}/lib
		cp -a arch/${ARCH}/lib/crtsavres.o ${STAGING_KERNEL_DIR}/arch/${ARCH}/lib/
	fi
}

