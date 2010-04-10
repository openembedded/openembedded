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

SRC_URI[md5sum] = "3e66f91f8a39c7dc0a67b158aeb9c2ac"
SRC_URI[sha256sum] = "a1275889c7bb6b3c353d5b9ebb983064e8ef1d29ef8688bd132cec065642d2d9"
