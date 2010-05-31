DESCRIPTION = "measuring and fixing Linux latency"
HOMEPAGE = "http://www.latencytop.org/"
LICENSE = "GPL"

DEPENDS = "glib-2.0 ncurses"

SRC_URI = "\
  http://www.latencytop.org/download/latencytop-${PV}.tar.gz\
  file://no-gtk.patch \
  file://cc-var.patch \
  file://ldflags.patch \
  file://ncursesw.patch \
  file://fixinstalldir.patch \
"

do_install() {
        oe_runmake DESTDIR="${D}" install
}

SRC_URI[md5sum] = "73bb3371c6ee0b0e68e25289027e865c"
SRC_URI[sha256sum] = "9e7f72fbea7bd918e71212a1eabaad8488d2c602205d2e3c95d62cd57e9203ef"

FILES_${PN} = "${sbindir} ${datadir}/${PN}/latencytop.trans"
