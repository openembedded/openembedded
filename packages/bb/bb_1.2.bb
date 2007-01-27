DESCRIPTION = "bb, The portable aalib demo"
HOMEPAGE = "http://aa-project.sourceforge.net/bb/"
SECTION = "console/misc"
DEPENDS = "aalib"
PR = "r1"
LICENSE = "GPLv2"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"

SRC_URI = "http://prdownloads.sourceforge.net/aa-project/bb-1.2.tar.gz \
           file://fix-compile.patch;patch=1"

inherit autotools

do_install() {
    install -d ${D}${bindir}
    install -m 755 bb ${D}${bindir}
}
