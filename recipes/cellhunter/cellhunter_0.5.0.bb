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
