DESCRIPTION = "GNU libiconv - libiconv is for you if your application needs to support \
multiple character encodings, but that support lacks from your system."
HOMEPAGE = "http://www.gnu.org/software/libiconv"
SECTION = "libs"
PRIORITY = "optional"
NOTES = "Needs to be stripped down to: ascii iso8859-1 eucjp iso-2022jp gb utf8"

SRC_URI = "ftp://ftp.gnu.org/pub/gnu/libiconv/libiconv-${PV}.tar.gz \
	   file://autotools.patch;patch=1 \
	   file://preload.patch;patch=1"

S = "${WORKDIR}/libiconv-${PV}"

inherit autotools

EXTRA_OECONF += "--enable-shared --enable-static --enable-relocatable --disable-rpath"

do_configure_append () {
	        # Fix stupid libtool... handling. rpath handling can't be disabled and the Makefile's can't be regenerated..
        # (GNU sed required)
        sed -i s/^hardcode_libdir_flag_spec/#hardcode_libdir_flag_spec/ ${S}/*-libtool
}

do_stage () {
	autotools_stage_all
}
