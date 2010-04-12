DEPENDS = "readline"
SRC_URI = "http://cvs.haskell.org/Hugs/downloads/Nov2003/${PV}.tar.gz \
           file://hugs.desktop \
           file://hugs.png"
LICENSE = "BSD"
PR = "r2"

S = "${WORKDIR}/${PV}/src/unix"

inherit autotools

# disable STRIP as the generated Makefile falsely call arm-linux-strip
# on compiling which leads to abortion of the compile
# we strip manually anyway so disabling it here is 'ok'
EXTRA_OECONF = "--disable-ffi STRIP=true"

do_configure() {
    oe_runconf
}

do_compile() {
    cd ../ && oe_runmake
}

do_install() {
    cd ../ && autotools_do_install
    install -d ${D}${datadir}/applications/
    install -m 0644 ${WORKDIR}/hugs.desktop ${D}${datadir}/applications/
    install -d ${D}${datadir}/pixmaps/
    install -m 0644 ${WORKDIR}/hugs.png ${D}${datadir}/pixmaps/
}

SRC_URI[md5sum] = "e80a6739ead9a260087fe4d3fc6a8359"
SRC_URI[sha256sum] = "9f90613de73e1b8e90d9bbcb09046e83680f15a46fc630c3e26e9aa4ca0e6a1d"
