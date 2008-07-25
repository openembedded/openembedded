DESCRIPTION = "A compiler that translates Scheme source files to C, and an interpreter"
HOMEPAGE = "http://www.call-with-current-continuation.org/"
SECTION = "interpreters"
PRIORITY = "optional"
LICENSE = "BSD"

SRC_URI = "http://www.call-with-current-continuation.org/chicken-${PV}.tar.gz" 

inherit autotools

do_install_append() {
    install -d ${D}${docdir}/${P}
    mv ${D}/${datadir}/chicken/doc ${D}${docdir}/${P}
}

do_stage() {
    autotools_stage_all
}

