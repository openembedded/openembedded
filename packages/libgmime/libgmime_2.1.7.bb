LICENSE = GPL
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
