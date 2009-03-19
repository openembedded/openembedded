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

