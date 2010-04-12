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



SRC_URI[md5sum] = "5806534e2bd3a68552f620e4b35dd292"
SRC_URI[sha256sum] = "6874cc3ee7daa9695cf5d24c635d98e3fb9e7291df36fbd0b0ba8f46825473a8"
