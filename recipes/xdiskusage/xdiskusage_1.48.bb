DESCRIPTION = "Xdiskusage shows graphically what is using up your disk space"
AUTHOR = "Bill Spitzak"
HOMEPAGE = "http://xdiskusage.sourceforge.net/"
SECTION = "x11/applications"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "fltk"

SRC_URI = "http://xdiskusage.sourceforge.net/xdiskusage-${PV}.tgz \
           file://running_from_menu.patch;patch=1 \
           file://xdiskusage.desktop \
           file://xdiskusage.png"

EXTRA_OEMAKE = "CXXFLAGS="${CXXFLAGS} `fltk-config --cxxflags`" \
                LDLIBS="`fltk-config --ldflags`""

do_install() {
    install -d ${D}/${bindir}
    install -d ${D}/${mandir}/man1
    install -d ${D}/${datadir}/applications
    install -d ${D}/${datadir}/pixmaps
    install -m 0755 ${S}/xdiskusage ${D}/${bindir}/
    install -m 0644 ${S}/xdiskusage.1 ${D}/${mandir}/man1/
    install -m 0644 ${WORKDIR}/xdiskusage.desktop ${D}/${datadir}/applications/
    install -m 0644 ${WORKDIR}/xdiskusage.png ${D}/${datadir}/pixmaps/
}

SRC_URI[md5sum] = "a902aa9d73761ade98256c3cd5c1f533"
SRC_URI[sha256sum] = "7842aa42510bf52c367164d44a977915ad9f070864d5175157738f8d6894274b"
