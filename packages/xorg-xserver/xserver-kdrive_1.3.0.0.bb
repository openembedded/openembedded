require xserver-kdrive-common.inc

# it's missing the xw100 patch
DEFAULT_PREFERENCE = "-1"

DEPENDS += "libxkbfile libxcalibrate"

PE = "1"
PR = "r0"

SRC_URI = "${XORG_MIRROR}/individual/xserver/xorg-server-${PV}.tar.bz2 \
	${KDRIVE_COMMON_PATCHES} \
        file://fix_default_mode.patch;patch=1 \
	file://enable-xcalibrate.patch;patch=1 \
	file://hide-cursor-and-ppm-root.patch;patch=1"

S = "${WORKDIR}/xorg-server-${PV}"
