DESCRIPTION = "A text mode OSS soundmixer"
LICENSE = "GPL"
SECTION = "console/utils"
PRIORITY = "optional"
SRC_URI = "${DEBIAN_MIRROR}/main/s/setmixer/setmixer_${PV}.orig.tar.gz \
	   file://setmixer.patch;patch=1"
SRC_URI_append_mnci = " file://devfs.patch;patch=1"

S = "${WORKDIR}/${PN}-${PV}.orig"


do_install() {
	mkdir -p ${D}${sbindir}
	install -m 755 setmixer ${D}${sbindir}
}

SRC_URI[md5sum] = "b30985591b239d2913382b97817ba790"
SRC_URI[sha256sum] = "4639247cb15c306f2182eea53982fe8007a8b9080cb9c1a8a38d5d2a45e4c20f"
