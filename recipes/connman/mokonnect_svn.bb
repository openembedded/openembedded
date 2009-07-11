DESCRIPTION = "mokonnect is an e17 frontend to connmand"
HOMEPAGE = "http://www.assembla.com/wiki/show/shrdev"
AUTHOR = "Fate"
LICENSE = "GPLv2"
SECTION = "e/apps"
RDEPENDS = "python-elementary"

PV = "0.2+svnr${SRCREV}"
PR = "r0"

SRC_URI = "svn://subversion.assembla.com/svn/shrdev;module=Mokonnect/trunk;proto=http \
file://mokonnect.desktop"

S = "${WORKDIR}/Mokonnect/trunk"

inherit distutils-base


PY_FILES = "mkbase.py mkdev_usbnet.py mkdev_wifi.py mkmenu.py qdbus.py"

do_install() {
	install -d ${D}${libdir}
	install -d ${D}${libdir}/${PYTHON_DIR}
	install -d ${D}${libdir}/${PYTHON_DIR}/site-packages

	for f in ${PY_FILES}
	do
		install -m 0644 $f ${D}${libdir}/${PYTHON_DIR}/site-packages/
	done

	install -d ${D}${bindir}
	install -m 755 mokonnect.py ${D}${bindir}/

	install -d ${D}${datadir}/applications
	install -m 644 ${WORKDIR}/mokonnect.desktop ${D}${datadir}/applications/

	install -d ${D}${datadir}/pixmaps
	install -m 644 mokonnect.png ${D}${datadir}/pixmaps/
}

FILES_${PN} += " ${datadir}/*/*"

