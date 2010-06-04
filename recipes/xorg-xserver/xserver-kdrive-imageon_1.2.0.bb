require xserver-kdrive-common.inc
DESCRIPTION = "X server for ATI Imageon 100 Cards from freedesktop.org"
COMPATIBLE_MACHINE = "c7x0"

DEPENDS += "libxkbfile libxcalibrate"

PROVIDES = "virtual/xserver"

PE = "1"
PR = "r8"

FILESPATHPKG =. "xserver-kdrive-${PV}:xserver-kdrive:"
SRC_URI = "${XORG_MIRROR}/individual/xserver/xorg-server-${PV}.tar.bz2 \
	${KDRIVE_COMMON_PATCHES} \
	file://kdrive-evdev.patch  \
	file://kdrive-use-evdev.patch  \
	file://disable-xf86-dga-xorgcfg.patch \
	file://enable-xcalibrate.patch \
        file://fbcompositesrc8888revnpx0565.patch \
        file://kdrive-vidmemarea.patch \
        file://kdrive-imageon.patch \
        file://xcalibrate_coords.patch \
        file://enable-builtin-fonts.patch \
	file://fix-picturestr-include-order.patch \
	file://split_multiple_AC_SUBST.patch \
	file://report-correct-randr10.patch \
	"
       
S = "${WORKDIR}/xorg-server-${PV}"

EXTRA_OECONF += "--enable-imageon"


SRC_URI[md5sum] = "ea291c89e68832d570d9d5e007218bd6"
SRC_URI[sha256sum] = "e3e56b35ee13098f4ee79948beb20bfc9a06d1a7a35fb906405ff1531b92bb85"
