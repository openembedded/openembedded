DESCRIPTION = "openBmap logger and uploader of GPS/GSM data"
SECTION = "x11/utils"
DEPENDS = "python python-dbus python-pygobject python-pygtk libglade"
RDEPENDS = "python-subprocess python-netclient python-math python-core python-io"
PR = "r1"

inherit python-dir

SRC_URI = "${SOURCEFORGE_MIRROR}/myposition/openbmap-logger-${PV}.tar.gz"

FILES_${PN} += "${datadir}/openBmap/* ${PYTHON_SITEPACKAGES_DIR}/openbmap/*"

do_configure () {
    :
}

do_compile () {
    :
}

do_install () {
    install -d ${D}${bindir}
    install -m 0755 openBmapGTK ${D}${bindir}/
    install -d ${D}${PYTHON_SITEPACKAGES_DIR}/openbmap/
    install -m 0644 openbmap/__init__.py ${D}${PYTHON_SITEPACKAGES_DIR}/openbmap/
    install -m 0644 openbmap/logger.py ${D}${PYTHON_SITEPACKAGES_DIR}/openbmap/
    install -m 0644 openbmap/Upload.py ${D}${PYTHON_SITEPACKAGES_DIR}/openbmap/
    install -d ${D}${datadir}/pixmaps
    install -d ${D}${datadir}/applications
    install -d ${D}${datadir}/openBmap
    install -m 0644 openBmap.desktop ${D}${datadir}/applications/openBmap.desktop
    install -m 0644 openBmap-desktop.png ${D}${datadir}/pixmaps/openBmap-desktop.png
    install -m 0644 ExitButton.png ${D}${datadir}/openBmap/ExitButton.png
    install -m 0644 GenerateButton.png ${D}${datadir}/openBmap/GenerateButton.png
    install -m 0644 StopButton.png ${D}${datadir}/openBmap/StopButton.png
    install -m 0644 UploadButton.png ${D}${datadir}/openBmap/UploadButton.png
    install -m 0644 Main.glade ${D}${datadir}/openBmap/Main.glade
}

