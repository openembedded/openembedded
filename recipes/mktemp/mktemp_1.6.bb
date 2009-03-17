DESCRIPTION = "Allow safe temporary file creation from shell scripts."
HOMEPAGE = "http://www.mktemp.org/"
SECTION = "console/utils"
LICENSE = "GPLv2 BSD"

inherit autotools

EXTRA_OECONF = "--with-libc"

SRC_URI = "\
  ftp://ftp.mktemp.org/pub/mktemp/${P}.tar.gz \
  file://add_destdir.patch;patch=1 \
  file://disable-strip.patch;patch=1 \
"
	 	 	
# FIXME should rather use update-alternatives
RCONFLICTS_${PN} = "coreutils"
