DESCRIPTION = "Linux Kernel for the EFIKA dev platform"
SECTION = "kernel"
LICENSE = "GPLv2"
PR = "r0"
PV = "2.6.21+git${SRCDATE}"

DEFAULT_PREFERENCE = "-1"

COMPATIBLE_MACHINE = "efika"

SRC_URI = "file://defconfig"

S = "${WORKDIR}/linux-2.6"

inherit kernel

export ARCH="powerpc"


do_fetch () {
	cd ${WORKDIR}
	git clone git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux-2.6.git
	cd linux-2.6
	git fetch git://git.secretlab.ca/git/linux-2.6.git 52xx-dev:sl-52xx
	git checkout sl-52xx
	# todo: fix to revision f20d894bd207f8bae9b7869fa039a83e7ab2c6d8 here. It works.
	mkdir patches
	cd patches
	wget http://www.246tnt.com/mpc52xx/2.6.22/0006-powerpc-Set-efika-s-device_type-to-soc.patch
	wget http://www.246tnt.com/mpc52xx/2.6.22/0007-serial-powerpc-Don-t-shutdown-TX-on-mpc5200-serial.patch
	wget http://www.246tnt.com/mpc52xx/2.6.22/0008-powerpc-mpc52xx-suspend-to-deep-sleep.patch
}

do_patch() {
	cd ${S}
	patch -F40 -p1 -i patches/0006-powerpc-Set-efika-s-device_type-to-soc.patch
	patch -F40 -p1 -i patches/0007-serial-powerpc-Don-t-shutdown-TX-on-mpc5200-serial.patch
	patch -F40 -p1 -i patches/0008-powerpc-mpc52xx-suspend-to-deep-sleep.patch
}

do_configure() {
		install -m 644 ${WORKDIR}/defconfig ${S}/.config
		make ARCH=${ARCH} oldconfig
}

do_stage_append () {
#need ppc platforms includes + friends in order for external kernel modules to compile as headers as still split

       install -d ${STAGING_KERNEL_DIR}/arch/
       cp -pPR arch/ppc ${STAGING_KERNEL_DIR}/arch/
       cp -pPR arch/powerpc ${STAGING_KERNEL_DIR}/arch/

       install -d ${STAGING_KERNEL_DIR}/include/asm
       cp -pPR include/asm-powerpc ${STAGING_KERNEL_DIR}/include/
       cp -pPR include/asm-ppc ${STAGING_KERNEL_DIR}/include/
}
