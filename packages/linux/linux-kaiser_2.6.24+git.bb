require linux.inc

PV = "2.6.24+git${SRCREV}"
PR = "r1"

COMPATIBLE_MACHINE = "htckaiser|htcpolaris"

SRC_URI = "git://git.linuxtogo.org/home/groups/mobile-linux/kernel.git;branch=htc-msm;protocol=git"

S = "${WORKDIR}/git"

do_configure_prepend() {
	cp arch/arm/configs/${MACHINE}_defconfig ../defconfig
}

