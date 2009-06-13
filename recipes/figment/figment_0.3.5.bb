SECTION = "x11/utils"
DESCRIPTION = "gtk2 outliner written by Matthew Allum"
LICENSE = "GPLv2"
DEPENDS = "gtk+ libxml2"
PR = "r1"

# original src_uri, http://handhelds.org/~mallum/downloadables/figment/figment-${PV}.tar.gz, is now unfetchable
SRC_URI = "http://ftp.sh.cvut.cz/MIRRORS/rock/ROCK-2.0/gnome2/figment/figment-${PV}.tar.bz2 \
	file://dotdesktop-name-comment.patch;patch=1"
S = "${WORKDIR}/figment-${PV}"

inherit autotools
