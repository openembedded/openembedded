DESCRIPTION = "The Open Source Clouds Web Desktop"
HOMEPAGE = "http://eyeos.org/"
LICENSE = "AGPL3"

SRC_URI = "${SOURCEFORGE_MIRROR}/eyeos/eyeOS_${PV}.zip"

S = "${WORKDIR}/eyeOS"

do_install() {
	install -d ${D}/www/pages/eyeos
	cp -r ${S}/* ${D}/www/pages/eyeos
}

PACKAGE_ARCH = "all"
FILES_${PN} += "/www/pages/eyeos"

