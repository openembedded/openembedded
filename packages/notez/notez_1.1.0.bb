DESCRIPTION = "simple note-taking application"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Marcin Juszkiewicz <openembedded@hrw.one.pl>"
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

