LICENSE = "GPLv2"
SRC_URI = "ftp://ftp.gnu.org/gnu/aspell/dict/pl/aspell6-pl-6.0_20061121-0.tar.bz2"
PR ="r1"

require aspell-lang.inc

S = "${WORKDIR}/aspell6-pl-6.0_20061121-0"

FILES_${PN} += "${docdir}/Copyright"
FILES_${PN}-doc = ""

do_install_append() {
	install -d ${D}${docdir}
	install ${S}/Copyright ${D}${docdir}
}



SRC_URI[md5sum] = "3139a69a1bd9ccb1d853d30aa024fc2b"
SRC_URI[sha256sum] = "017741fcb70a885d718c534160c9de06b03cc72f352879bd106be165e024574d"
