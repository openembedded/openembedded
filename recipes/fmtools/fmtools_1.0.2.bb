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


SRC_URI[md5sum] = "4bae0e5feeb8cbf4cfcb950301e9509d"
SRC_URI[sha256sum] = "60a55ba4a57b5ed430c62662283e9cb6de685c8497173f1f2065f684b2aceabd"
