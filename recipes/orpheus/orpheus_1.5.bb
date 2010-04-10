SECTION = "console/utils"
DESCRIPTION = "Orpheus is a light-weight text mode menu- and \
window-driven audio player application for CDs and files in \
MP3 and Vorbis OGG format."
DEPENDS = "ncurses"
LICENSE = "GPL"
SRC_URI = "http://thekonst.net/download/orpheus-${PV}.tar.bz2 \
	   file://m4.patch;patch=1"
S = "${WORKDIR}/orpheus-${PV}"

inherit autotools

acpaths = "-I ${S}/m4"

SRC_URI[md5sum] = "9613e6be14ba7a0ca5d42a88e6ed3516"
SRC_URI[sha256sum] = "45145ea27333be1552624065297b4d9d76feadf2a4a89fdf0ddafc830ced3a98"
