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

SRC_URI[md5sum] = "1fdf51aeb20d908c29e39ddca2b3459c"
SRC_URI[sha256sum] = "6714d9c1285fc04d39f03b85ebad3723be6f8709ca8935e984b280ac42e97492"
