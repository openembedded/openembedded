############## /home/jrs/cvs/oe/org.openembedded.dev/packages/linux/xanadux-un-2.6_2.6.12.bb ###############

DESCRIPTION = "Xanadux HTC-Universal kernel based on the hh 2.6.12"
LICENSE = "GPLv2"
PR ="r2"

SRC_URI = "cvs://anonymous@xanadux.cvs.sourceforge.net/cvsroot/xanadux;method=pserver;module=linux-2.6-xda;tag=K2-6-12-hh2-xda0-un0"
S = "${WORKDIR}/linux-2.6-xda"

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = "htc-universal"


inherit kernel

do_configure() {
        cp arch/arm/configs/htcuniversal_defconfig .config || die "No default configuration for ${MACHINE} available."
        yes '' | oe_runmake oldconfig
}
