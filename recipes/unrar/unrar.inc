SRC_URI = "http://www.rarlab.com/rar/unrarsrc-${PV}.tar.gz"
S = "${WORKDIR}/unrar"

do_compile() {
    oe_runmake -f makefile.unix
}

