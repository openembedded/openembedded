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

SRC_URI[md5sum] = "d2690e2c6d9f477ee0d3851388c0fef9"
SRC_URI[sha256sum] = "2522ac7aaf843f23bd948b664372549362ece5973555e7565a2d0dd4bca8ce54"
