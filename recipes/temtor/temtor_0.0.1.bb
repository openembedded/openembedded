DESCRIPTION = "Timetracker to track time spent on different projects"
SECTION = "opie/applications"
PRIORITY = "optional"
LICENSE = "GPL"
AUTHOR = "Martin Henne <martin.henne@web.de>"
HOMEPAGE = "http://www.martinhenne.de/temtor/"
APPNAME = "temtor"
APPTYPE = "binary"
APPDESKTOP = "${S}/ipk"

SRC_URI = "http://leapingcat.org/martinhenne.de/temtor/files/temtor-0.0.1.tar.gz"

inherit opie

EXTRA_QMAKEVARS_POST += "CONFIG-=qt-mt CONFIG+=qt DEFINES+=NO_DEBUG"
QMAKE_PROFILES = "temtor.pro"


do_install () {
	install -d ${D}/${palmtopdir}/pics/
	install -m 0644 src/temtor.png ${D}/${palmtopdir}/pics/
}


SRC_URI[md5sum] = "340bc7fa4a9cad1fe9ecc9b1df49d164"
SRC_URI[sha256sum] = "1c76d6ac7e80de0ae88cc5cbdad7a2a564eac96788549359b001366dc52fe817"
