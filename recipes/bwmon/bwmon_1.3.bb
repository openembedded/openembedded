DESCRIPTION = "The Linux bandwidth monitor"
LICENSE = "GPL"
DEPENDS = "ncurses"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/bwmon/${P}.tar.gz \
           file://makefile.patch;patch=1"

inherit autotools

do_install () {
        install -d ${D}${bindir}
        install ${S}/bwmon ${D}${bindir}/bwmon
}

SRC_URI[md5sum] = "53c44b73aa67d5e0282adfe928f3ba44"
SRC_URI[sha256sum] = "624381208d0faae6c123bc6198a59d6c4316cd4fffb1ba5aca206374f5a42df6"
