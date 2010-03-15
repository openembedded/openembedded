DESCRIPTION = "Xanadux Blueangel kernel based on the hh 2.6.12"
LICENSE = "GPLv2"
PR ="r0"

SRC_URI = "cvs://anonymous@xanadux.cvs.sourceforge.net/cvsroot/xanadux;method=pserver;module=linux-2.6-xda;tag=K2-6-12-hh2-xda0-ba0"
S = "${WORKDIR}/linux-2.6-xda"

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = "blueangel"

inherit kernel

do_configure() {
        cp arch/arm/configs/blueangel_defconfig .config || die "No default configuration for ${MACHINE} available."
        yes '' | oe_runmake oldconfig
}

