DESCRIPTION = "Fush is a shell replacement for security conscious admins."
HOMEPAGE = "http://sourceforge.net/projects/foosh/"
LICENSE = "GPL"
DEPENDS = "readline"
PRIORITY = "optional"
SECTION = "base/shell"
PR = "r3"

RV = "${@bb.data.getVar('PV', d, 1).replace('.', '-')}"
SRC_URI = "${SOURCEFORGE_MIRROR}/foosh/fush-${RV}.tar.gz \
	   file://openpty.patch;patch=1 \
	   file://install.patch;patch=1 \
	   file://paths.patch;patch=1"
S = "${WORKDIR}/fush-${RV}"

inherit autotools
