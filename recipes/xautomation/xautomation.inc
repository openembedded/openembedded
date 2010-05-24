DESCRIPTION = "Control X from the command line"
HOMEPAGE = "http://www.hoopajoo.net/projects/xautomation.html"
SECTION = "console"
LICENSE = "GPL"

SRC_URI = "http://www.hoopajoo.net/static/projects/${PN}-${PV}.tar.gz \
           file://remove-man.patch"

inherit autotools pkgconfig
