DESCRIPTION = "Fribidi library for bidirectional text"
SECTION = "libs"
PRIORITY = "optional"

inherit autotools pkgconfig

PR = "r0"

S = "${WORKDIR}/fribidi-${PV}"

SRC_URI = "${SOURCEFORGE_MIRROR}/fribidi/fribidi-${PV}.tar.bz2 \
           file://libtool-update.patch;patch=1"

#PACKAGES += " ${PN}-bin"
FILES_${PN} = "${libdir}/lib*.so.*"
#FILES_${PN}-bin = "${libdir}/uu*"

do_configure_prepend () {
# this version of libtool is old - we have to nobble this file to get it to litoolize
	rm ltconfig
	rm aclocal.m4
	rm acinclude.m4
}

do_stage () {
	oe_libinstall -a -so -C .libs libfribidi ${STAGING_LIBDIR}
	autotools_stage_includes
}


SRC_URI[md5sum] = "0f6e7ecca08e6e108dc06337f5b5cabf"
SRC_URI[sha256sum] = "f3ecdb9d108bd61ec9394df75f5fd68ba886a8da0863ba6258338893aec6c04f"
