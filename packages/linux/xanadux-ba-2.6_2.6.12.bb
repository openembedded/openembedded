DESCRIPTION = "Xanadux Blueangel kernel based on the hh 2.6.12"
MAINTAINER = "Ian Jordan <immolo@lycos.co.uk>"
LICENSE = "GPL"
PR="r0"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/xanadux;method=pserver;module=linux-2.6-xda;tag=K2-6-12-hh2-xda0-ba0"
S = "${WORKDIR}/linux-2.6-xda"

COMPATIBLE_HOST = "arm.*-linux"

inherit kernel

do_configure() {
        cp arch/arm/configs/blueangel_defconfig .config || die "No default configuration for ${MACHINE} available."
        yes '' | oe_runmake oldconfig
}

