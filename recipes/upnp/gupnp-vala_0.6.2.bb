LICENSE = "LGPL"
DEPENDS = "gupnp vala-native"

PR = "r1"

SRC_URI = "http://gupnp.org/sources/bindings/${PN}-${PV}.tar.gz"

inherit autotools pkgconfig

do_install_append() {
	mv ${D}${STAGING_DIR_NATIVE}/* ${D}
}

FILES_${PN}-dev += "${datadir}/vala"

do_stage() {
	autotools_stage_all
	install -d ${STAGING_DATADIR}/vala/vapi	
	install -m 0644 ${S}/*.deps ${S}/*.vapi ${STAGING_DATADIR}/vala/vapi
}


