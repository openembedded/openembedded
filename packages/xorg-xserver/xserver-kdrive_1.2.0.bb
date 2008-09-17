require xserver-kdrive-common.inc

DEPENDS += "libxkbfile libxcalibrate"

PE = "1"
PR = "r10"

SRC_URI = "${XORG_MIRROR}/individual/xserver/xorg-server-${PV}.tar.bz2 \
	${KDRIVE_COMMON_PATCHES} \
	file://enable-epson.patch;patch=1 \
	file://enable-builtin-fonts.patch;patch=1 \
	file://kdrive-evdev.patch;patch=1  \
	file://kdrive-use-evdev.patch;patch=1  \
	file://disable-xf86-dga-xorgcfg.patch;patch=1 \
	file://enable-xcalibrate.patch;patch=1 \
        file://w100.patch;patch=1 \
        file://w100-autofoo.patch;patch=1 \
        file://w100-fix-offscreen-bmp.patch;patch=1 \
        file://fbcompositesrc8888revnpx0565.patch;patch=1 \
        file://xcalibrate_coords.patch;patch=1 \
	"
       
S = "${WORKDIR}/xorg-server-${PV}"

W100_OECONF = "--disable-w100"
W100_OECONF_arm = "--enable-w100"

