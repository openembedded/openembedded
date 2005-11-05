SECTION = "console/utils"
DESCRIPTION = "Orpheus is a light-weight text mode menu- and \
window-driven audio player application for CDs and files in \
MP3 and Vorbis OGG format."
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
DEPENDS = "ncurses"
LICENSE = "GPL"
SRC_URI = "http://thekonst.net/download/orpheus-${PV}.tar.bz2 \
	   file://m4.patch;patch=1"
S = "${WORKDIR}/orpheus-${PV}"

inherit autotools

acpaths = "-I ${S}/m4"
