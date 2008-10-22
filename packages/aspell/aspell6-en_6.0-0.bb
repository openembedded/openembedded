LICENSE = "Copyright file"
SRC_URI = "ftp://ftp.gnu.org/gnu/aspell/dict/en/aspell6-en-${PV}.tar.bz2"
PR ="r1"

require aspell-lang.inc

FILES_${PN} += "${docdir}/Copyright"
FILES_${PN}-doc = ""

do_install_append() {
	install -d ${D}${docdir}
	install ${S}/Copyright ${D}${docdir}
}

