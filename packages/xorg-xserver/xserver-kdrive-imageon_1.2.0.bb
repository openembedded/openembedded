require xserver-kdrive-common.inc
DESCRIPTION = "X server for ATI Imageon 100 Cards from freedesktop.org"
COMPATIBLE_MACHINE = "c7x0"

DEPENDS += "libxkbfile libxcalibrate"

PROVIDES = "virtual/xserver"

PE = "1"
PR = "r6"

FILESPATH = "${FILE_DIRNAME}/xserver-kdrive-${PV}:${FILE_DIRNAME}/xserver-kdrive:${FILE_DIRNAME}/files"
SRC_URI = "${XORG_MIRROR}/individual/xserver/xorg-server-${PV}.tar.bz2 \
	${KDRIVE_COMMON_PATCHES} \
	file://kdrive-evdev.patch;patch=1  \
	file://kdrive-use-evdev.patch;patch=1  \
	file://disable-xf86-dga-xorgcfg.patch;patch=1 \
	file://enable-xcalibrate.patch;patch=1 \
        file://fbcompositesrc8888revnpx0565.patch;patch=1 \
        file://kdrive-vidmemarea.patch;patch=1 \
        file://kdrive-imageon.patch;patch=1 \
        file://xcalibrate_coords.patch;patch=1 \
        file://enable-builtin-fonts.patch;patch=1 \
	file://fix-picturestr-include-order.patch;patch=1 \
        "
       
S = "${WORKDIR}/xorg-server-${PV}"

EXTRA_OECONF += "--enable-imageon"

