require xserver-kdrive-common.inc

DEPENDS += "libxkbfile libxcalibrate"

PE = "1"
PR = "r11"

SRC_URI = "${XORG_MIRROR}/individual/xserver/xorg-server-${PV}.tar.bz2 \
	${KDRIVE_COMMON_PATCHES} \
	file://enable-epson.patch \
	file://enable-builtin-fonts.patch \
	file://kdrive-evdev.patch  \
	file://kdrive-use-evdev.patch  \
	file://disable-xf86-dga-xorgcfg.patch \
	file://enable-xcalibrate.patch \
        file://w100.patch \
        file://w100-autofoo.patch \
        file://w100-fix-offscreen-bmp.patch \
        file://fbcompositesrc8888revnpx0565.patch \
        file://xcalibrate_coords.patch \
	file://report-correct-randr10.patch \
	"
       
S = "${WORKDIR}/xorg-server-${PV}"

W100_OECONF = "--disable-w100"
W100_OECONF_arm = "--enable-w100"


SRC_URI[md5sum] = "ea291c89e68832d570d9d5e007218bd6"
SRC_URI[sha256sum] = "e3e56b35ee13098f4ee79948beb20bfc9a06d1a7a35fb906405ff1531b92bb85"
