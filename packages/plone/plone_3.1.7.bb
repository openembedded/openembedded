DESCRIPTION = "Plone, a user friendly and powerful Content Management System based on the Zope Web Application Server"
SECTION = "network/cms"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI = "http://launchpad.net/plone/3.1/${PV}/+download/Plone-${PV}.tar.gz"
S = "${WORKDIR}/Plone-${PV}"

inherit distutils

do_install() {
	install -d ${D}${libdir}/python/Products/
	cp -pPR ${S}/* ${D}${libdir}/python/Products/
}

RDEPENDS = "zope"
FILES_${PN} = "${libdir}/python/Products/"
