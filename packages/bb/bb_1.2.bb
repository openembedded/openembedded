DESCRIPTION = "bb, The portable aalib demo"
HOMEPAGE = "http://aa-project.sourceforge.net/bb/"
SECTION = "console/misc"
LICENSE = "GPLv2"
DEPENDS = "aalib"
PR = "r1"

SRC_URI = "http://prdownloads.sourceforge.net/aa-project/bb-1.2.tar.gz \
           file://fix-compile.patch;patch=1"

inherit autotools

do_install() {
    install -d ${D}${bindir}
    install -m 755 bb ${D}${bindir}
}
