DESCRIPTION = "Tx Image Viewer"
SECTION = "opie/applications"
PRIORITY = "optional"
LICENSE = "GPL"
HOMEPAGE = "http://community.zaurus.com/projects/tximage/"
PR = "r2"

SRC_URI = "http://www.openzaurus.org/mirror/tximage-${PV}.tar.gz \
           file://gcc3.patch;patch=1 \
           file://gcc4.patch;patch=1"

inherit palmtop

do_install() {
        install -d ${D}${palmtopdir}/apps/Applications \
        	   ${D}${palmtopdir}/pics \
        	   ${D}${palmtopdir}/bin
        install -D -m 755 tximage ${D}${palmtopdir}/bin/tximage
        install -D -m 644 imageviewer.desktop ${D}${palmtopdir}/apps/Applications/tximage.desktop
        cp -pPR tximage.png ${D}${palmtopdir}/pics/
}

SRC_URI[md5sum] = "eca63798136caeeaf7fd4b24c3e10783"
SRC_URI[sha256sum] = "88b11a3e89db847e1db51e6f2b0c69e2afa0035fb4a47f523d264765eedb2958"
