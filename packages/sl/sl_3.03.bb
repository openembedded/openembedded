DESCRIPTION = "Corrects you if you type `sl' by mistake"
SECTION = "console/games"
LICENSE = "unknown"
DEPENDS = "ncurses"

SRC_URI = "http://archive.ubuntu.com/ubuntu/pool/universe/s/sl/sl_3.03.orig.tar.gz \
           http://archive.ubuntu.com/ubuntu/pool/universe/s/sl/sl_3.03-14.diff.gz;patch=1"

S = "${WORKDIR}/${P}.orig"

LDFLAGS += "-lcurses"

do_install() {
        install -d ${D}${bindir}
        install -m 755 sl ${D}${bindir}
}


