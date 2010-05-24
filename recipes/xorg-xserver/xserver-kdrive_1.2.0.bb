require xserver-kdrive-common.inc

DEPENDS += "libxkbfile libxcalibrate"

PE = "1"
PR = "r11"

SRC_URI = "${XORG_MIRROR}/individual/xserver/xorg-server-${PV}.tar.bz2 \
	${KDRIVE_COMMON_PATCHES} \
	file://enable-epson.patch;apply=yes \
	file://enable-builtin-fonts.patch;apply=yes \
	file://kdrive-evdev.patch;apply=yes  \
	file://kdrive-use-evdev.patch;apply=yes  \
	file://disable-xf86-dga-xorgcfg.patch;apply=yes \
	file://enable-xcalibrate.patch;apply=yes \
        file://w100.patch;apply=yes \
        file://w100-autofoo.patch;apply=yes \
        file://w100-fix-offscreen-bmp.patch;apply=yes \
        file://fbcompositesrc8888revnpx0565.patch;apply=yes \
        file://xcalibrate_coords.patch;apply=yes \
	file://report-correct-randr10.patch;apply=yes \
	"
       
S = "${WORKDIR}/xorg-server-${PV}"

W100_OECONF = "--disable-w100"
W100_OECONF_arm = "--enable-w100"


SRC_URI[md5sum] = "ea291c89e68832d570d9d5e007218bd6"
SRC_URI[sha256sum] = "e3e56b35ee13098f4ee79948beb20bfc9a06d1a7a35fb906405ff1531b92bb85"
