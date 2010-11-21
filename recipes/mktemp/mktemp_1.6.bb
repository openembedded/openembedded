DESCRIPTION = "Allow safe temporary file creation from shell scripts."
HOMEPAGE = "http://www.mktemp.org/"
SECTION = "console/utils"
LICENSE = "GPLv2 BSD"
PR = "r2"

inherit autotools update-alternatives

EXTRA_OECONF = "--with-libc"

SRC_URI = "\
    ftp://ftp.mktemp.org/pub/mktemp/${BP}.tar.gz \
    file://add_destdir.patch \
    file://disable-strip.patch \
"

bindir = "${base_bindir}"

do_install_append_pn-mktemp () {
    mv ${D}${base_bindir}/mktemp ${D}${base_bindir}/mktemp.${PN}
}

ALTERNATIVE_NAME = "mktemp"
ALTERNATIVE_LINK = "${base_bindir}/mktemp"
ALTERNATIVE_PATH = "${base_bindir}/mktemp.${PN}"
ALTERNATIVE_PRIORITY = "100"

SRC_URI[md5sum] = "3e66f91f8a39c7dc0a67b158aeb9c2ac"
SRC_URI[sha256sum] = "a1275889c7bb6b3c353d5b9ebb983064e8ef1d29ef8688bd132cec065642d2d9"
