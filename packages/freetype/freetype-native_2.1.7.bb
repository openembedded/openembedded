SECTION = "base"
LICENSE = "freetype"
DESCRIPTION = "Freetype font rendering library"

PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/freetype/freetype-${PV}.tar.bz2 \
	   file://configure.patch;patch=1"

inherit autotools pkgconfig native binconfig
DEPENDS = ""
FILESPATH = "${FILE_DIRNAME}/freetype-${PV}:${FILE_DIRNAME}/freetype:${FILE_DIRNAME}/files"
S = "${WORKDIR}/freetype-${PV}"
PACKAGES = ""

do_configure () {
	(cd builds/unix && gnu-configize) || die "failure running gnu-configize"
	oe_runconf
}

do_stage () {
	autotools_stage_includes
	oe_libinstall -so -a -C objs libfreetype ${STAGING_LIBDIR}
}
