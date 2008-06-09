require linux.inc

PV = "2.6.24+git${SRCREV}"
PR = "r1"

COMPATIBLE_MACHINE = "htckaiser"

SRC_URI = "git://git.linuxtogo.org/home/groups/mobile-linux/kernel.git;branch=htc-msm;protocol=git"

S = "${WORKDIR}/git"

do_configure_prepend() {
	cp arch/arm/configs/htckaiser_defconfig ../defconfig
}


