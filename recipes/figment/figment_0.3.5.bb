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

SRC_URI[md5sum] = "4b317749c7a75c4f283c6ef5aaad4146"
SRC_URI[sha256sum] = "ebafecd9a34dbcb83bcbf69db3e9655e92af2eb0ede33d9f92d13ed5f2e7d8b2"
