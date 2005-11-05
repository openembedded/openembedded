DESCRIPTION = "Plone, a user friendly and powerful Content Management System based on the Zope Web Application Server"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
RDEPENDS = "zope"
LICENSE = "GPL"
SRC_URI = "${SOURCEFORGE_MIRROR}/plone/CMFPlone-2.0-final.tar.gz"
S = "${WORKDIR}/CMFPlone-2.0-final"

do_install() {
	install -d ${D}${libdir}/python/Products/
	cp -pPR ${S}/* ${D}${libdir}/python/Products/
}

FILES_${PN} = "${libdir}/python/Products/"
