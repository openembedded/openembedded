DESCRIPTION = "CellHunter - A game to collect information about mobile phone cells"
SECTION = "x11/utils"
DEPENDS = "python"
RDEPENDS = "python-subprocess python-netclient python-math python-core python-io python-pygtk python-dbus frameworkd"
PR = "r0"

SRC_URI = "\
  http://ch.omoco.de/cellhunter/files/cellhunter-${PV}.tar.gz \
"

do_configure () {
    :
}

do_compile () {
    :
}

do_install () {
    install -d ${D}${bindir}
    install -m 0755 cellhunter.py ${D}${bindir}/
    install -m 0755 cellhunter_upload.sh ${D}${bindir}/
    install -d ${D}${datadir}/pixmaps
    install -d ${D}${datadir}/applications
    install -m 0644 cellhunter.desktop ${D}${datadir}/applications/cellhunter.desktop
    install -m 0644 cellhunter.png ${D}${datadir}/pixmaps/cellhunter.png
}

SRC_URI[md5sum] = "1ac5c56a85fb12bea0bf0a4a2ea664de"
SRC_URI[sha256sum] = "1210dab4e3b23c2a5083d12e9c1527bf099a89f06867e1210b7d9992204c24f8"
