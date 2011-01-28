require git.inc

SRC_URI += "file://git-less-hardlinks.diff"

EXTRA_OECONF += "ac_cv_snprintf_returns_bogus=no ac_cv_c_c99_format=yes"


DEPENDS = "openssl curl zlib expat tcl-native"
RDEPENDS_${PN} = "findutils sed"

# Dropbear ssh needs a wrapper script, so install openssh-ssh to make it work out of the box
RRECOMMENDS_${PN} = "openssh-ssh"
SRC_URI[src.md5sum] = "8a8cd93b8a4dff0a03c0fdc77253af3e"
SRC_URI[src.sha256sum] = "41682e4c13b43591b61a96b6f7a549b24863f62dfc4a917b6147c8e708e288a6"
PR = "r1"

do_install_append() {
	# Fix broken hardlinks
	for gitprog in git-receive-pack git-upload-archive ; do
		rm ${D}${bindir}/$gitprog
		ln -sf ${bindir}/git ${D}${bindir}/$gitprog
	done
	for gitprog in git-cvsserver git-shell git-upload-pack ; do
		rm ${D}${libexecdir}/git-core/$gitprog
		ln -sf ${bindir}/$gitprog ${D}${libexecdir}/git-core/$gitprog
	done
	rm ${D}${libexecdir}/git-core/git && ln -sf ${bindir}/git ${D}${libexecdir}/git-core/git
}

FILES_${PN}-dbg += "${libexecdir}/git-core/.debug"

PACKAGES =+ "${PN}-perltools"
FILES_${PN}-perltools += " \
	${libexecdir}/git-core/git-add--interactive \
	${libexecdir}/git-core/git-archimport \
	${libexecdir}/git-core/git-cvsexportcommit \
	${libexecdir}/git-core/git-cvsimport \
	${libexecdir}/git-core/git-cvsserver \
	${bindir}/git-cvsserver \
	${libexecdir}/git-core/git-difftool \
	${libexecdir}/git-core/git-relink \
	${libexecdir}/git-core/git-send-email \
	${libexecdir}/git-core/git-svn \
	${datadir}/perl \
"
RDEPENDS_${PN}-perltools = "${PN} perl perl-module-file-path findutils"

PACKAGES =+ "${PN}-large"
FILES_${PN}-large += " \
	${libexecdir}/git-core/git-http-backend \
	${libexecdir}/git-core/git-daemon \
	${libexecdir}/git-core/git-http-push \
	${libexecdir}/git-core/git-quiltimport \
	${libexecdir}/git-core/git-request-pull \
	${libexecdir}/git-core/git-shell \
	${bindir}/git-shell \
	${libexecdir}/git-core/git-instaweb \
	${libexecdir}/git-core/git-fast-import \
	${libexecdir}/git-core/git-imap-send \
"
# those might be useful in a less-than-large package ?
FILES_${PN}-large += " \
	${libexecdir}/git-core/git-http-fetch \
	${libexecdir}/git-core/git-upload-pack \
	${bindir}/git-upload-pack \
"
# same here, but adding it causes git to depend on git-large(!)
# see http://bugs.openembedded.net/show_bug.cgi?id=5465
#FILES_${PN}-large += " \
#	${libexecdir}/git-core/git-remote-http \
#"
RDEPENDS_${PN}-large = "${PN}"

# git-tk package with gitk and git-gui
PACKAGES =+ "${PN}-tk"
RDEPENDS_${PN}-tk = "${PN} tk tcl"
EXTRA_OEMAKE = "TCL_PATH=${STAGING_BINDIR_CROSS}/tclsh"
FILES_${PN}-tk = " \
	${bindir}/gitk \
	${datadir}/gitk \
"
# git gui does not start at all at this time
#FILES_${PN}-tk += " \
#	${libexecdir}/git-core/git-gui \
#	${libexecdir}/git-core/git-gui--askpass \
#	${datadir}/git-gui \
#"
#PACKAGES += "${PN}-tk-locale"
#PACKAGES_DYNAMIC = "${PN}-tk-locale-*"
#FILES_${PN}-tk-locale = "${datadir}/git-gui/lib/msgs"
