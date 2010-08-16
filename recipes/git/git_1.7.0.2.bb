require git.inc

SRC_URI[src.md5sum] = "76518fa774b36de81d160b85fa4f19c1"
SRC_URI[src.sha256sum] = "5601df7fc282fdd66de196b282694eb77dcfc50438f01587de144b3ead1a6b2f"

SRC_URI += "file://git-less-hardlinks.diff"

EXTRA_OECONF += "ac_cv_snprintf_returns_bogus=no ac_cv_c_c99_format=yes"


DEPENDS = "openssl curl zlib expat"
RDEPENDS_${PN} = "perl perl-module-file-path cpio findutils sed"

# Dropbear ssh needs a wrapper script, so install openssh-ssh to make it work out of the box
RRECOMMENDS_${PN} = "openssh-ssh"

PR = "r7"

do_install_append() {
	# Fix broken hardlinks
	for gitprog in git-receive-pack git-upload-archive ; do
		rm ${D}${bindir}/$gitprog 
		ln -sf ${bindir}/git ${D}${bindir}/$gitprog
	done
	rm ${D}${libexecdir}/git-core/git && ln -sf ${bindir}/git ${D}${libexecdir}/git-core/git
}

FILES_${PN}-dbg += "${libexecdir}/git-core/.debug"
