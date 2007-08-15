require linux-omap.inc

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/linux-omap2-git"
PV = "2.6.x+git${SRCDATE}"
PR = "r1"

COMPATIBLE_MACHINE = "omap2430sdp"

SRC_URI = "git://source.mvista.com/git/linux-omap-2.6.git;protocol=git \
           file://omap-2430-lcd.patch;patch=1;pnum=1 \
           file://defconfig.eabi \
           file://defconfig"

S = "${WORKDIR}/git"
