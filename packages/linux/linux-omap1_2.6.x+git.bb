require linux-omap.inc

DEFAULT_PREFERENCE = "-1"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/linux-omap1-git/${MACHINE}"
PV = "2.6.x+git${SRCDATE}"
PR = "r1"

COMPATIBLE_MACHINE = "omap5912osk|omap1710h3"

SRC_URI = "git://source.mvista.com/git/linux-omap-2.6.git;protocol=git \
           file://defconfig"

S = "${WORKDIR}/git"
