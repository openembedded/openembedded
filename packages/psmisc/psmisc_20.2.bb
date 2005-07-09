LICENSE = "GPL"
DESCRIPTION = "procfs tools"
SECTION = "base"
PRIORITY = "required"
MAINTAINER = "Greg Gilbert <greg@treke.net>"
DEPENDS = "ncurses"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/psmisc/psmisc-${PV}.tar.gz \
	   file://gettext.patch;patch=1"
S = "${WORKDIR}/psmisc-${PV}"

inherit autotools gettext

ALLOW_EMPTY = "1"

PACKAGES = "${PN} fuser fuser-doc \
	    killall killall-doc \
	    pstree pstree-doc"

FILES_${PN} = ""
RDEPENDS_${PN} = "fuser killall pstree"

FILES_fuser = "${bindir}/fuser"
FILES_fuser-doc = "${mandir}/man1/fuser*"

FILES_killall = "${bindir}/killall"
FILES_killall-doc = "${mandir}/man1/killall*"

FILES_pstree = "${bindir}/pstree"
FILES_pstree-doc = "${mandir}/man1/pstree*"
