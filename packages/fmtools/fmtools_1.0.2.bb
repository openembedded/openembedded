DESCRIPTION = "fmtools - programs for Video for Linux radio cards"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://www.stanford.edu/~blp/fmtools/fmtools-1.0.2.tar.gz \
           file://makefile.patch;patch=1"

inherit autotools

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/fm ${D}${bindir}/fm
    install -m 0755 ${S}/fmscan ${D}${bindir}/fmscan
}

