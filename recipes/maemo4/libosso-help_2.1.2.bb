LICENSE = "LGPL"
DESCRIPTION = "Nokia osso help library"

DEPENDS = "libhildonhelp libosso gtkhtml-3.8 libxml2 "

PR = "r0"

SRC_URI = "http://repository.maemo.org/pool/sardine-experimental/main.disabled/source/libo/libosso-help/libosso-help_${PV}-2.tar.gz"

inherit autotools pkgconfig lib_package

S = "${WORKDIR}/2.1.2-2"

do_configure_prepend() {
	# remove Werror from OSSO_CFLAGS
	sed -i s:-Werror::g configure.ac
        sed -i -e s:AC_CONFIG_SRCDIR:#AC_CONFIG_SRCDIR:g configure.ac
}

do_stage() {
        autotools_stage_all
}



SRC_URI[md5sum] = "fc5a1f4598670cec9ac40fb603f80570"
SRC_URI[sha256sum] = "ecbff97da422f1498eae8f9b8a17389c0ccdd7eee1ca0259f035e712c8e0a405"
