DESCRIPTION = "Proxy libintl"
HOMEPAGE = "http://ftp.gnome.org/pub/GNOME/binaries/win32/dependencies/"
SECTION = "libs"
LICENSE = "LGPL"

PR = "r5"
PROVIDES = "virtual/libintl"

SRC_URI = " \
    http://ftp.gnome.org/pub/GNOME/binaries/win32/dependencies/${PN}-${PV}.zip \
    file://stub-only.patch;patch=1 \
    file://create-as-shared-lib.patch;patch=1 \
    file://soname.patch;patch=1 \
"

S = "${WORKDIR}"
FILES_${PN}-dev = "${includedir}/libintl.h ${libdir}/libintl.a"
FILES_${PN} = "${libdir}/libintl.so"

CFLAGS_append = " -Wall -I ../../include ${@['-DSTUB_ONLY', ''][bb.data.getVar('USE_NLS', d, 1) != 'no']}"
TARGET_CC_ARCH += "${LDFLAGS}"
CFLAGS_append_mips = " -fPIC"
CFLAGS_append_mipsel = " -fPIC"

do_compile() {
    cd ${WORKDIR}/src/proxy-libintl
    oe_runmake
}

do_install() {
    install -d ${D}/${includedir}
    install -m 0644 ${WORKDIR}/include/libintl.h ${D}/${includedir}

    install -d ${D}/${libdir}
    oe_libinstall -a -so -C lib libintl ${D}/${libdir}
}

