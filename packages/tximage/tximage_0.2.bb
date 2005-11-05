DESCRIPTION = "Tx Image Viewer"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
HOMEPAGE = "http://community.zaurus.com/projects/tximage/"
PR = "r1"

SRC_URI = "http://www.openzaurus.org/mirror/tximage-${PV}.tar.gz \
           file://gcc3.patch;patch=1"

inherit palmtop

do_install() {
        install -d ${D}${palmtopdir}/apps/Applications \
        	   ${D}${palmtopdir}/pics \
        	   ${D}${palmtopdir}/bin
        install -D -m 755 tximage ${D}${palmtopdir}/bin/tximage
        install -D -m 644 imageviewer.desktop ${D}${palmtopdir}/apps/Applications/tximage.desktop
        cp -pPR tximage.png ${D}${palmtopdir}/pics/
}
