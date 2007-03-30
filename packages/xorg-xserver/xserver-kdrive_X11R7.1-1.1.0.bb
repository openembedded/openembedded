require xserver-kdrive-common.inc

DEPENDS += "xcalibrateext"

PR = "r10"

PACKAGES =+ "xserver-kdrive-w100"

SRC_URI = "${XORG_MIRROR}/X11R7.1/src/xserver/xorg-server-${PV}.tar.bz2 \
	${KDRIVE_COMMON_PATCHES} \
	file://xcalibrate.patch;patch=1 \
	file://w100.patch;patch=1 \
	"

S = "${WORKDIR}/xorg-server-${PV}"

W100_OECONF = "--disable-w100"
W100_OECONF_arm = "--enable-w100"
