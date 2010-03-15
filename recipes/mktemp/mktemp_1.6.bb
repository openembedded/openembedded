DESCRIPTION = "Allow safe temporary file creation from shell scripts."
HOMEPAGE = "http://www.mktemp.org/"
SECTION = "console/utils"
LICENSE = "GPLv2 BSD"

inherit autotools update-alternatives

EXTRA_OECONF = "--with-libc"

SRC_URI = "\
  ftp://ftp.mktemp.org/pub/mktemp/${P}.tar.gz \
  file://add_destdir.patch;patch=1 \
  file://disable-strip.patch;patch=1 \
"

do_install_append () {
	mkdir ${D}${base_bindir}
	mv ${D}${bindir}/mktemp ${D}${base_bindir}/mktemp.${PN}
}

ALTERNATIVE_NAME = "mktemp"
ALTERNATIVE_LINK = "${base_bindir}/mktemp"
ALTERNATIVE_PATH = "${base_bindir}/mktemp.${PN}"
ALTERNATIVE_PRIORITY = "100"
