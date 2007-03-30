DEFAULT_PREFERENCE = "-2"

require xserver-kdrive-common.inc

DEPENDS += "libxkbfile libxcalibrate"

PE = "1"
PV = "1.2.0+git${SRCDATE}"
PR = "r8"

SRC_URI = "git://anongit.freedesktop.org/xorg/xserver;protocol=git \
	${KDRIVE_COMMON_PATCHES} \
	file://disable-xf86-dga-xorgcfg-1.2.patch;patch=1 \
	file://enable-epson.patch;patch=1 \
	file://build-fix-panoramix.patch;patch=1 \
	"

S = "${WORKDIR}/git"
