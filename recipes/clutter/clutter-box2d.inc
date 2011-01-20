DESCRIPTION = "Clutter Box2D physics engine integration"
HOMEPAGE = "http://www.clutter-project.org/"
LICENSE = "LGPLv2.1"

DEPENDS = "clutter"

INC_PR = "r2"

# The main clutter lib is machine specific so we need to be too
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit autotools pkgconfig gtk-doc

require clutter-common.inc

EXTRA_OECONF = "--disable-introspection"

do_configure_prepend() {
	make_all_execs_installable
}

do_install_append () {
	install -m 755 -d ${D}${datadir}/${PN}-examples
	install -m 755 ${S}/examples/redhand.png ${D}${datadir}/${PN}-examples
}

PACKAGES =+ "${PN}-examples"
FILES_${PN}-examples = "${bindir}/* ${datadir}/${PN}-examples"
