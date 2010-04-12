LICENSE = "GPL"
DESCRIPTION = "Runtime libraries for parsing and creating MIME mail"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "glib-2.0"

inherit autotools pkgconfig gnome

PR = "r1"
SRC_URI = "http://spruce.sourceforge.net/gmime/sources/v2.1/gmime-${PV}.tar.gz \
	   file://skip-iconv-detect.patch;patch=1 \
	   file://configure-ldflags-cross.patch;patch=1"

S = "${WORKDIR}/gmime-${PV}"

PACKAGES += " ${PN}-bin"
FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-bin = "${bindir}/uu*"

do_stage () {
	oe_libinstall -a -so -C gmime libgmime-2.0 ${STAGING_LIBDIR}
	gnome_stage_includes
}

SRC_URI[md5sum] = "ed99c382471294896f576e5f77694142"
SRC_URI[sha256sum] = "39ef812217a76982947a7ac3b4a97e8303466a3dd93709366d1559e0a7ec8a46"
