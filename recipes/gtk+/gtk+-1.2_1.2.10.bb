LICENSE = "LGPL"
DESCRIPTION = "GTK+1.2 is a deprecated library provided for running programs not yet converted to GTK+2.0"
HOMEPAGE = "http://www.gtk.org"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "glib-1.2 jpeg libpng libxext"
PR = "r4"

SRC_URI = "ftp://ftp.gtk.org/pub/gtk/v1.2/gtk+-${PV}.tar.gz \
           file://timezone-fix.patch \
           file://gtk+1.2-reconf-fix;apply=yes \
           file://no-xwc;apply=yes"

SRC_URI_append_jlime = " file://small-filesel.patch "

S = "${WORKDIR}/gtk+-${PV}"

inherit autotools pkgconfig flow-lossage binconfig

do_configure_prepend() {
	install -d m4
	rm -f ltconfig libtool ltmain.sh aclocal.m4
	sed -i -e s:AM_LC_MESSAGES:gt_LC_MESSAGES:g acinclude.m4
}

FILES_${PN} += "${datadir}/themes"
FILES_${PN}-dev += "${datadir}/gtk-1.2/include ${libdir}/gtk-1.2/include"


EXTRA_OECONF = "--enable-debug=no --disable-glibtest --disable-xim"

do_install_append () {
	install -d ${D}${sysconfdir}/gtk-1.2
}


SRC_URI[md5sum] = "4d5cb2fc7fb7830e4af9747a36bfce20"
SRC_URI[sha256sum] = "3fb843ea671c89b909fd145fa09fd2276af3312e58cbab29ed1c93b462108c34"
