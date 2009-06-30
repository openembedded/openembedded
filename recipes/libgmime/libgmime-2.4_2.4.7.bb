LICENSE = "LGPL"
DESCRIPTION = "Runtime libraries for parsing and creating MIME mail"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "glib-2.0 zlib"
SRC_URI = "http://ftp.acc.umu.se/pub/GNOME/sources/gmime/2.4/gmime-${PV}.tar.bz2 \
           file://configure-cross.patch;patch=1 \
           file://iconv-detect.h"
EXTRA_OECONF += "--disable-mono"
S = "${WORKDIR}/gmime-${PV}"

inherit autotools_stage lib_package

export ac_cv_have_iconv_detect_h=yes
do_configure_append = "cp ${WORKDIR}/iconv-detect.h ${S}"
