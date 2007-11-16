LICENSE = "LGPL"
DESCRIPTION = "Nokia hildon mime library"

DEPENDS = "libosso gnome-vfs"

PR = "r0"

SRC_URI = "http://archive.ubuntu.com/ubuntu/pool/universe/libh/libhildonmime/libhildonmime_${PV}-1ubuntu1.tar.gz"

inherit autotools pkgconfig lib_package

S = "${WORKDIR}/${PN}"

do_configure_prepend() {
	# remove Werror from OSSO_CFLAGS
	sed -i s:-Werror::g configure.in
}

do_stage() {
        autotools_stage_all
}


