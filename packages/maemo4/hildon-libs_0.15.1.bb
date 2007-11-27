LICENSE = "LGPL"
DESCRIPTION = "Nokia hildon librares"

DEPENDS = "gtk-doc-native libosso libmatchbox"

PR = "r0"

SRC_URI = "http://launchpadlibrarian.net/7598381/hildon-libs_0.15.1-1ubuntu2.tar.gz"

inherit autotools pkgconfig lib_package

S = "${WORKDIR}/${PN}"

do_configure_prepend() {
	# remove Werror from OSSO_CFLAGS
	sed -i s:-Werror::g configure.ac
        touch gtk-doc.make
}

do_stage() {
        autotools_stage_all
}


FILES_${PN} += "${libdir}/hildon-widgets/*"

