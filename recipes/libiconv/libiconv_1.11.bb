DESCRIPTION = "GNU libiconv - libiconv is for you if your application needs to support \
multiple character encodings, but that support lacks from your system."
HOMEPAGE = "http://www.gnu.org/software/libiconv"
SECTION = "libs"
PRIORITY = "optional"
NOTES = "Needs to be stripped down to: ascii iso8859-1 eucjp iso-2022jp gb utf8"
PROVIDES = "virtual/libiconv"
PR = "r4"
LICENSE = "LGPL"
SRC_URI = "ftp://ftp.gnu.org/pub/gnu/libiconv/libiconv-${PV}.tar.gz"

S = "${WORKDIR}/libiconv-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF += "--enable-shared --enable-static --enable-relocatable"

do_configure () {
	rm -f m4/libtool.m4 libcharset/m4/libtool.m4
	autotools_do_configure

	# As we do not really regenerate the Makefiles... and they have stale deps to this file
	touch m4/libtool.m4

	# Fix stupid libtool... handling. rpath handling can't be disabled and the Makefile's can't be regenerated..
	# (GNU sed required)
	sed -i s/^hardcode_libdir_flag_spec/#hardcode_libdir_flag_spec/ ${S}/*-libtool
}

do_stage () {
	oe_libinstall -so -a -C lib libiconv ${STAGING_LIBDIR}
	oe_libinstall -so -C lib libiconv_plug_linux ${STAGING_LIBDIR}
	oe_libinstall -so -a -C libcharset/lib libcharset ${STAGING_LIBDIR}
	autotools_stage_includes
}

SRC_URI[md5sum] = "b77a17e4a5a817100ad4b2613935055e"
SRC_URI[sha256sum] = "fbf5b9a63ea6e3abebfabc04506f0e18a2860071031e34ea4ad4f450b8c43d4b"
