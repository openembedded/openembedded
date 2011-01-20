DESCRIPTION = "Clutter GTK+ integration library"
HOMEPAGE = "http://www.clutter-project.org/"
LICENSE = "LGPLv2.1"

INC_PR = "r2"

DEPENDS = "gtk+ clutter"
require clutter-common.inc

inherit autotools pkgconfig gtk-doc

EXTRA_OECONF = "--disable-introspection"

do_configure_prepend() {
	make_all_execs_installable

	# Align the examples data location
	for i in $(find ${S}/examples -name *.c) ; do
		sed -i -e 's:\"redhand.png\":\"${datadir}/${PN}-examples/redhand.png\":g' $i
	done
}

do_install_append () {
	install -m 755 -d ${D}${datadir}/${PN}-examples
	install -m 755 ${S}/examples/redhand.png ${D}${datadir}/${PN}-examples
}

PACKAGES =+ "${PN}-examples"
FILES_${PN}-examples = "${bindir}/* ${datadir}/${PN}-examples"
