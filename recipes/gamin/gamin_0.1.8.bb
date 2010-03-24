DESCRIPTION = "Gamin is a file and directory monitoring system defined to be a subset of the FAM (File Alteration Monitor) system."
LICENSE = "LGPL"
DEPENDS = "glib-2.0"

SRC_URI = "http://www.gnome.org/~veillard/gamin/sources/gamin-${PV}.tar.gz \
           file://no-abstract-sockets.patch;patch=1 \
           file://configure_ucred.patch;patch=1 "

EXTRA_OECONF = " --without-python " 

inherit autotools pkgconfig

do_stage() {
        autotools_stage_all
}	
