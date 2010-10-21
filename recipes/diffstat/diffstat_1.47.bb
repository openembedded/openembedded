DESCRIPTION = "diffstat reads the output of diff and displays a histogram of \
the insertions, deletions, and modifications per-file. It is useful for \
reviewing large, complex patch files."
HOMEPAGE = "http://invisible-island.net/diffstat/"
PRIORITY = "optional"
SECTION = "devel"

SRC_URI = "ftp://invisible-island.net/diffstat/diffstat-${PV}.tgz"
S = "${WORKDIR}/diffstat-${PV}"

inherit autotools

PR = "r1"

do_configure () {
	if [ ! -e acinclude.m4 ]; then
		mv aclocal.m4 acinclude.m4
	fi
	autotools_do_configure
}

SRC_URI[md5sum] = "c6d221ff4a032e1bbf227f5936a7841a"
SRC_URI[sha256sum] = "0c398b749574b6bd54f5c5ac1d71118400cd54791e2f47a96a1ad07915d22832"
