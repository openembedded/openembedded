DESCRIPTION = "A text mode OSS soundmixer"
LICENSE = "GPL"
SECTION = "console/utils"
PRIORITY = "optional"
MAINTAINER = "Holger Schurig <no@spam.de>"
SRC_URI = "${DEBIAN_MIRROR}/main/s/setmixer/setmixer_${PV}.orig.tar.gz \
	   file://setmixer.patch;patch=1"
SRC_URI_append_mnci = " file://devfs.patch;patch=1"

S = "${WORKDIR}/${PN}-${PV}.orig"


do_install() {
	mkdir -p ${D}${sbindir}
	install -m 755 setmixer ${D}${sbindir}
}
