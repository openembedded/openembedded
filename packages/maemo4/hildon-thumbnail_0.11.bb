LICENSE = "LGPL"
DESCRIPTION = "Nokia hildon thumbnail library"

DEPENDS = "libhildonmime hildon-libs osso-thumbnail"

PR = "r0"

SRC_URI = "http://repository.maemo.org/pool/sardine/main/source/h/${PN}/${PN}_${PV}.tar.gz \
          "

inherit autotools pkgconfig lib_package

S = "${WORKDIR}/${PV}"

do_configure_prepend() {
	# remove Werror from OSSO_CFLAGS
	sed -i s:-Werror::g configure.ac
        touch gtk-doc.make
}

do_stage() {
        autotools_stage_all
}


