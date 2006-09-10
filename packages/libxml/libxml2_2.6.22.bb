DESCRIPTION = "GNOME XML library"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "MIT"
PR = "r3"

SRC_URI = "http://xmlsoft.org/sources/libxml2/libxml2-${PV}.tar.gz \
		   file://no-testapi.patch;patch=1"

inherit autotools pkgconfig binconfig

EXTRA_OECONF = "--without-python --without-debug --without-legacy --without-catalog --without-docbook --without-c14n"

do_stage() {
	autotools_stage_all
	install -m 0644 libxml.m4 ${STAGING_DATADIR}/aclocal/
}

python populate_packages_prepend () {
	# autonamer would call this libxml2-2, but we don't want that
	if bb.data.getVar('DEBIAN_NAMES', d, 1):
		bb.data.setVar('PKG_libxml2', 'libxml2', d)
}

PACKAGES = "${PN}-dbg ${PN}-dev ${PN}-utils ${PN} ${PN}-doc ${PN}-locale"

FILES_${PN}-dev += "${bindir}/*-config"
FILES_${PN}-utils += "${bindir}/*"
