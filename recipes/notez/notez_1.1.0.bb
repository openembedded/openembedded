DESCRIPTION = "simple note-taking application"
SECTION = "opie/applications"
PRIORITY = "optional"
LICENSE = "GPL"
AUTHOR = "Henning Holtschneider <hh@holtschneider.com>"
HOMEPAGE = "http://www.holtschneider.com/notez/"
APPNAME = "notez"
APPTYPE = "binary"
APPDESKTOP = "${S}"
PR = "r1"

SRC_URI = "http://www.holtschneider.com/notez/notez-${PV}.tar.gz \
file://use-homedir.patch;patch=1 \
file://fix-encoding.patch;patch=1"

inherit opie

do_install () {
	install -d ${D}${palmtopdir}/pics/
	install -m 0644 notez.png ${D}${palmtopdir}/pics/noteZ.png
}


SRC_URI[md5sum] = "c348a626fc09265fa74a12470c83c113"
SRC_URI[sha256sum] = "11ee0a660faca7993a2f525d2964391d135b9552d9e94abad6cb6c5f3983f964"
