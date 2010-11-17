DESCRIPTION = "Ampache is a free software Web-based Audio file manager / web Media Server."
HOMEPAGE = "http://www.ampache.org"
LICENSE = "GPLv2"

PR = "r0"
RDEPENDS = "lighttpd mysql5 php"

SRC_URI = "http://ampache.org/downloads/ampache-${PV}.tar.gz"
SRC_URI[md5sum] = "f07c1d9de1b5887420d698d22be2eb95"
SRC_URI[sha256sum] = "f5ee6906d2af60ea8dcbd1b3a18119ffbe6b92c21c0b0c59a1ba01e5bead5f74"

FILES_${PN} = "/www/pages"

do_configure () {
}

do_compile () {
}

do_install () {
	install -d ${D}/www/pages
	cp -r ${S}/ ${D}/www/pages/ampache/
}
