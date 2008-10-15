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


