LICENSE = "GPL"

SRC_URI = "http://64.34.161.181/download/3.4.0/sources/${PN}-${PV}.tar.gz \
           "

SRC_URI[md5sum] = "15deba68e12e13b524a723b49e7ec813"
SRC_URI[sha256sum] = "8c5a67ea156afb0fb2a50adbb89b8b26b6f0860cf3f53c45eb53f59ec4deaa98"

S = "${WORKDIR}/${PN}"

inherit autotools

do_install () {
        oe_runmake "bindir=${D}${bindir}" \
                   "man1dir=${D}${mandir}" \
                   install
}
