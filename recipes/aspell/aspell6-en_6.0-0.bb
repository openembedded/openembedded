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


SRC_URI[md5sum] = "16449e0a266e1ecc526b2f3cd39d4bc2"
SRC_URI[sha256sum] = "24f0688711d2b893fa06c16d14d0aa3a8000e326226b839aad32611f7ace4898"
