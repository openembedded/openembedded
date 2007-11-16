LICENSE = "LGPL"
DESCRIPTION = "Nokia hildon help library"

DEPENDS = "libart-lgpl libpng jpeg libxml2 gtkhtml-3.8 libosso"

PR = "r0"

SRC_URI = "http://repository.maemo.org/pool/sardine-experimental/main.disabled/source/libh/libhildonhelp/libhildonhelp_${PV}-1.tar.gz"

inherit autotools pkgconfig lib_package

S = "${WORKDIR}/${PV}-1"

do_configure_prepend() {
	# remove Werror from OSSO_CFLAGS
	sed -i s:-Werror::g configure.ac
}

do_stage() {
        autotools_stage_all
}


