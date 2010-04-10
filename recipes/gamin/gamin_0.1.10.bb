DESCRIPTION = "Gamin is a file and directory monitoring system defined to be a subset of the FAM (File Alteration Monitor) system."
LICENSE = "LGPL"
DEPENDS = "glib-2.0"

SRC_URI = "http://www.gnome.org/~veillard/gamin/sources/gamin-${PV}.tar.gz \
           file://no-abstract-sockets.patch;patch=1"

EXTRA_OECONF = " --without-python " 

inherit autotools pkgconfig

do_stage() {
        autotools_stage_all
}	

SRC_URI[md5sum] = "b4ec549e57da470c04edd5ec2876a028"
SRC_URI[sha256sum] = "28085f0ae8be10eab582ff186af4fb0be92cc6c62b5cc19cd09b295c7c2899a1"
