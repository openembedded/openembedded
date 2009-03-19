DESCRIPTION = "Plone, a user friendly and powerful Content Management System based on the Zope Web Application Server"
SECTION = "network/cms"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "ml0"

SRC_URI = "http://launchpadlibrarian.net/19393495/Plone-${PV}.tar.gz"
S = "${WORKDIR}/Plone-${PV}"

do_install() {
	install -d ${D}${libdir}/python/Products/
	cp -pPR ${S}/* ${D}${libdir}/python/Products/
}

RDEPENDS = "zope"
FILES_${PN} = "${libdir}/python/Products/"
