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


SRC_URI[md5sum] = "020b1ffd9edc3fe7af25b0d6cca430ae"
SRC_URI[sha256sum] = "660cd2de4fbd511b767839cb5caa734ebfa9cc5935aa58604f764d7e295768d4"
