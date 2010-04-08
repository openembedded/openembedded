DESCRIPTION = "The official elementary GTK theme designed to be smooth, attractive, fast, and usable."
LICENSE = "GPLv2"

PR = "r1"

SRC_URI = "http://launchpadlibrarian.net/37260169/eGTK.tar.gz;name=archive"

SRC_URI[archive.md5sum] = "86e26e6408ffc0cdd366d22fb5fb7618"
SRC_URI[archive.sha256sum] = "e7abc91270f56c71c68bfb4786eb69ca5b9148d01bb85c7b2103a3d7b8aac5a1"

S = "${WORKDIR}/eGTK"

do_install() {
	rm -rf ${S}/patches
	install -d ${D}${datadir}/themes/elementary
	cp -r ${S}/* ${D}${datadir}/themes/elementary/
}

PACKAGE_ARCH = "all"
FILES_${PN} = "${datadir}"
RDEPENDS_${PN} = "elementary-icon-theme gtk-engine-murrine gtk-engine-aurora"

