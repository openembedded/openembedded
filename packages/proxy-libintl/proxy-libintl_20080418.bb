DESCRIPTION = "Proxy libintl"
HOMEPAGE = "http://ftp.gnome.org/pub/GNOME/binaries/win32/dependencies/"
SECTION = "libs"
LICENSE = "LGPL"

PR = "r1"
PROVIDES = "virtual/libintl"


SRC_URI = " \
    http://ftp.gnome.org/pub/GNOME/binaries/win32/dependencies/${PN}-${PV}.zip \
    file://stub-only.patch;patch=1 \
"


S = "${WORKDIR}"
FILES_${PN}-dev = "${includedir} ${libdir}"


CFLAGS_append = " -Wall -I ../../include ${@['-DSTUB_ONLY', ''][bb.data.getVar('USE_NLS', d, 1) != 'no']}"

do_compile() {
    cd ${WORKDIR}/src/proxy-libintl
    oe_runmake
}




do_install() {
    install -d ${D}/usr/include
    install -d ${D}/usr/lib
    
    install -m 0644 ${WORKDIR}/include/libintl.h ${D}/${includedir}
    install -m 0644 ${WORKDIR}/lib/libintl.a ${D}/${libdir}
}



do_stage() {
    install -m 0644 ${WORKDIR}/include/libintl.h ${STAGING_INCDIR}/
    oe_libinstall -a -C lib libintl ${STAGING_LIBDIR}/
}



