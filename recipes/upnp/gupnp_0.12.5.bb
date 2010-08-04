LICENSE = "LGPL"
DEPENDS = "e2fsprogs gssdp libsoup-2.4 libxml2"

SRC_URI = "http://gupnp.org/sources/${PN}/${PN}-${PV}.tar.gz"
PR = "r2"

inherit autotools pkgconfig

FILES_${PN} = "${libdir}/*.so.*"
FILES_${PN}-dev += "${bindir}/gupnp-binding-tool"

do_install_append () {
	install -m 755 ${S}/tools/gupnp-binding-tool ${D}${STAGING_BINDIR_NATIVE}
}
SRC_URI[md5sum] = "bfb12195c76bb6632bd917f2c2bc12d6"
SRC_URI[sha256sum] = "241e416cbe2c02f413fde82a8587bfe2fe9915fbed3a6fb20c86520b8d7543ef"
