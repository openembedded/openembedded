LICENSE = "GPL"
DESCRIPTION = "procfs tools"
SECTION = "base"
PRIORITY = "required"
DEPENDS = "ncurses"
PR = "r3"

SRC_URI = "${SOURCEFORGE_MIRROR}/psmisc/psmisc-${PV}.tar.gz \
	   file://gettext.patch;patch=1"
S = "${WORKDIR}/psmisc-${PV}"

inherit autotools gettext

ALLOW_EMPTY = "1"

PACKAGES = "${PN}-dbg ${PN} fuser fuser-doc \
	    killall killall-doc \
	    pstree pstree-doc"

FILES_${PN} = ""
RDEPENDS_${PN} = "fuser killall pstree"

FILES_fuser = "${bindir}/fuser"
FILES_fuser-doc = "${mandir}/man1/fuser*"

FILES_killall = "${bindir}/killall.${PN}"
FILES_killall-doc = "${mandir}/man1/killall*"

FILES_pstree = "${bindir}/pstree"
FILES_pstree-doc = "${mandir}/man1/pstree*"

do_install_append() {
	mv ${D}${bindir}/killall ${D}${bindir}/killall.${PN}
}

pkg_postinst_killall() {
	update-alternatives --install ${bindir}/killall killall killall.${PN} 90
}

pkg_postrm_killall() {
	update-alternatives --remove ${bindir}/killall killall.${PN}
}

SRC_URI[md5sum] = "f0d40e38a150ee31123362e7c50bcf9d"
SRC_URI[sha256sum] = "e2592a857ccc2b5ad6f327ce2acc7b5a0874ec10755476aa2cf6bfa054230214"
