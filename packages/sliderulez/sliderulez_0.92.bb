DESCRIPTION = "Sliderulez is an advanced RPN pocket calculator."
HOMEPAGE = "http://www.gelhaus.net/cgi-bin/showpage.py?zaurus/+sliderulez.html"
AUTHOR = "Matthew Gelhaus"
SECTION = "opie/applications"
LICENSE = "GPL"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
PR = "r0"

APPTYPE = "binary"
APPDESKTOP = "pkg/opt/QtPalmtop/apps/Applications"

SRC_URI = "http://www.gelhaus.net/zaurus/sliderulez-${PV}.tar.gz"

inherit opie

EXTRA_QMAKEVARS_POST += "TARGET=sliderulez"

do_configure_prepend() {
	rm -rf "*.o Makefile"
}


do_install() {
	install -d ${D}${palmtopdir}/pics
	install -m 0644 pkg/opt/QtPalmtop/pics/SlideRuleZ.png ${D}${palmtopdir}/pics/
}
