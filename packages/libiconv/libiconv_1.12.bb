<<<<<<< HEAD:packages/libiconv/libiconv_1.12.bb
DESCRIPTION = "GNU libiconv - libiconv is for you if your application needs to support \
multiple character encodings, but that support lacks from your system."
HOMEPAGE = "http://www.gnu.org/software/libiconv"
SECTION = "libs"
PRIORITY = "optional"
NOTES = "Needs to be stripped down to: ascii iso8859-1 eucjp iso-2022jp gb utf8"
PROVIDES = "virtual/libiconv"
FILE_PR = "r0"
LICENSE = "LGPL"

SRC_URI = "ftp://ftp.gnu.org/pub/gnu/libiconv/libiconv-${PV}.tar.gz \
	   file://autotools.patch;patch=1 \
	   file://preload.patch;patch=1"
=======
require libiconv.inc
>>>>>>> libinconv: split up into .inc and version file:packages/libiconv/libiconv_1.12.bb

PROVIDES = "virtual/libiconv"
PR = "r1"

#gettext.class cant be inherit here so use this hack
DEPENDS = "${@['','gettext-native'][bb.data.getVar('USE_NLS', d, 1) == 'yes']}"

EXTRA_OECONF +=  "${@['--disable-nls','--enable-nls'][bb.data.getVar('USE_NLS', d, 1) == 'yes']}"

LEAD_SONAME = "libiconv.so"
