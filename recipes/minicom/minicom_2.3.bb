SECTION = "console/network"
DEPENDS = "ncurses"
LICENSE = "GPL"
SRC_URI = "http://alioth.debian.org/frs/download.php/2332/minicom-${PV}.tar.gz \
	file://rename-conflicting-functions.patch;patch=1 \
	"

inherit autotools gettext

do_install() {
	for d in doc extras man lib src; do make -C $d DESTDIR=${D} install; done
}
