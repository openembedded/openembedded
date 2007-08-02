require xserver-kdrive-common.inc
DESCRIPTION = "X server for ATI Imageon 100 Cards from freedesktop.org"
COMPATIBLE_MACHINE = "c7x0"

DEPENDS += "libxkbfile libxcalibrate"

PROVIDES = "virtual/xserver"

PE = "1"
PR = "r0"

FILESPATH = "${FILE_DIRNAME}/xserver-kdrive-1.2.0:${FILE_DIRNAME}/xserver-kdrive"
SRC_URI = "${XORG_MIRROR}/individual/xserver/xorg-server-${PV}.tar.bz2 \
	${KDRIVE_COMMON_PATCHES} \
	file://enable-xcalibrate.patch;patch=1 \
        file://fbcompositesrc8888revnpx0565.patch;patch=1 \
        file://kdrive-vidmemarea.patch;patch=1 \
        file://kdrive-imageon.patch;patch=1 \
        "
       
S = "${WORKDIR}/xorg-server-${PV}"

IMAGEON_OECONF = "--disable-imageon"
IMAGEON_OECONF_arm = "--enable-imageon"

