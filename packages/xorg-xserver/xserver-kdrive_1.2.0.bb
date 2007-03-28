require xserver-kdrive-common.inc

DEPENDS += "libxkbfile libxcalibrate"

PE = "1"
PR = "r1"

PACKAGES =+ "xserver-kdrive-imageon"

SRC_URI = "${XORG_MIRROR}/individual/xserver/xorg-server-${PV}.tar.bz2 \
	${KDRIVE_COMMON_PATCHES} \
	file://disable-xf86-dga-xorgcfg-1.2.patch;patch=1 \
	file://xcalibrate-1.2.patch;patch=1 \
	file://enable-epson-1.2.patch;patch=1 \
        file://kdrive-vidmemarea.patch;patch=1 \
        file://kdrive-imageon.patch;patch=1 \
	"

S = "${WORKDIR}/xorg-server-${PV}"

IMAGEON_OECONF = "--disable-imageon"
IMAGEON_OECONF_arm = "--enable-imageon"
