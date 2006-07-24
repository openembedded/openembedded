DESCRIPTION = "Native bdftopdf utility"
SECTION = "x11/fonts"
LICENSE = "MIT-X"

S="${WORKDIR}/bdftopcf-${PV}"

DEPENDS = "libxfont-native"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/app/bdftopcf-X11R7.0-1.0.0.tar.gz"

inherit native autotools pkgconfig

