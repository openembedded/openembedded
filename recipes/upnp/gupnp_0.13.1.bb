LICENSE = "LGPL"
DEPENDS = "e2fsprogs gssdp libsoup-2.4 libxml2 gtk-doc-native libgee"

require gupnp.inc

SRC_URI += " \
           file://nodoc.patch"

inherit autotools pkgconfig

PR = "r1"

EXTRA_OECONF = "--disable-gtk-doc"

FILES_${PN} = "${libdir}/*.so.*"
FILES_${PN}-dev += "${bindir}/gupnp-binding-tool"

do_install_append () {
	install ${S}/tools/gupnp-binding-tool ${D}${STAGING_BINDIR_NATIVE}
}

SRC_URI[md5sum] = "9b5fcf8146ba9a2bd84382f61717aa0e"
SRC_URI[sha256sum] = "e97faaebf0da42617a43de4c7c1148a51148f2a2cdaa2a10855e377b968a07fd"
