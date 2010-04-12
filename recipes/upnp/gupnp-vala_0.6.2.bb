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



SRC_URI[md5sum] = "7293cab94a8595efe740ede12991ef84"
SRC_URI[sha256sum] = "27752b6d4115a3ef6299d8ad55e74624c800409fa606326343319c17e37d0ed0"
