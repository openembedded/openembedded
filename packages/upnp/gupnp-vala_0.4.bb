LICENSE = "GPL"
DEPENDS = "gupnp vala-native"

SRC_URI = "http://gupnp.org/sources/bindings/${PN}-${PV}.tar.gz"

inherit autotools pkgconfig

do_install_append() {
	mv ${D}${STAGING_DIR_NATIVE}/* ${D}
}

FILES_${PN}-dev += "${datadir}/vala"

do_stage() {
	autotools_stage_all
}


