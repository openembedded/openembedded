inherit autotools

DESCRIPTION = "GNU termcap is a library of C functions that enables programs \
to send control strings to terminals in a terminal type-independent manner"
HOMEPAGE = "http://freshmeat.net/projects/termcap/"
LICENSE = "GPLv2"
DEPENDS = ""
PE = "1"
PR = "1"

SRC_URI = "${GNU_MIRROR}/termcap/termcap-${PV}.tar.gz"
SRC_URI[md5sum] = "ffe6f86e63a3a29fa53ac645faaabdfa"
SRC_URI[sha256sum] = "91a0e22e5387ca4467b5bcb18edf1c51b930262fd466d5fda396dd9d26719100"

EXTRA_OECONF += "\
    --disable-install-termcap \
    --with-termcap=${sysconfdir}/termcap \
"

EXTRA_OEMAKE += "\
    'AR=${AR}' \
    'CFLAGS=${CFLAGS}' \
"

do_install () {
    install -d ${D}${sysconfdir}
    oe_runmake install \
        'libdir=${D}${libdir}' \
        'includedir=${D}${includedir}' \
        'infodir=${D}${infodir}' \
        'termcapfile=${D}${sysconfdir}/termcap' \
        'oldincludedir='
}

NATIVE_INSTALL_WORKS = "1"
BBCLASSEXTEND += "native nativesdk"
