LICENSE = "GPL"

SRC_URI = "http://64.34.161.181/download/3.4.0/sources/${PN}-${PV}.tar.gz \
           "

SRC_URI[md5sum] = "a1150d9a51e7eb7d7ae2546a5c139bf7"
SRC_URI[sha256sum] = "9e45b7c8d780e15113ce6254317da27273fecfdd4d4a07702ac8edbae8cc11f6"

S = "${WORKDIR}/${PN}"

inherit autotools

do_install () {
        oe_runmake "bindir=${D}${bindir}" \
                   "man1dir=${D}${mandir}" \
                   install
}
