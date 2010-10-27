DESCRIPTION = "a collection of autoconf m4 macros"
HOMEPAGE = "http://cwautomacros.berlios.de/"
LICENSE = "GPLv2+"
PR = "0"

SRC_URI = "http://download.berlios.de/cwautomacros/cwautomacros-${PV}.tar.bz2"
SRC_URI[md5sum] = "352b295897ddb30c0d7d0acdd0b2313a"
SRC_URI[sha256sum] = "8f683713baa63e6b5c2ea72067f77cbacf0bee7d4efa907951c6bb5ac1ffd6b0"

do_compile () {
    :
}

do_install () {
    sed -i -e's,\$(INSTALLPREFIX)/share,${D}${datadir},g' \
           -e's,\$(INSTALLPREFIX),${D},g' \
           Makefile
    make install
    mv ${D}${datadir}/cwautomacros/m4 ${D}${datadir}/aclocal
}

NATIVE_INSTALL_WORKS = "1"
BBCLASSEXTEND += "native nativesdk"
