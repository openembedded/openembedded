SECTION = "kernel"
DESCRIPTION = "JLime Linux kernel for Arm based Jornada 7xx"
LICENSE = "GPLv2"
PR = "r0"

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = "jornada7xx"

SRC_URI = "file://defconf_jlime"

S = "${WORKDIR}/linux-hpc"

inherit kernel

ARCH = "arm"

FILES_kernel-image = "/boot/${KERNEL_IMAGETYPE}*"

do_fetch () {
	cd ${WORKDIR}
	[ -d linux-hpc ] && {
		cd linux-hpc
		git pull
	} || {
		git clone git://git.kernel.org/pub/scm/linux/kernel/git/kristoffer/linux-hpc.git
		cd linux-hpc
		# written individual do_fetch function because I don't know how to do this in SRC_URI:
		git-checkout --track -b v2.6.32-hpc origin/v2.6.32-hpc
		git-checkout v2.6.32-hpc
	}
}

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconf_jlime ${S}/.config
}
