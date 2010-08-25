LICENSE = "GPL"

SRC_URI = "http://64.34.161.181/download/3.4.0/sources/${PN}-${PV}.tar.gz \
           "

SRC_URI[md5sum] = "c480abff35565bde306e3878d0e43093"
SRC_URI[sha256sum] = "9325173919b98675d1f88616f2692f4ffd6cb0ae3dd61c6015fa82065693efa8"

S = "${WORKDIR}/${PN}"

inherit autotools

do_install () {
        oe_runmake "bindir=${D}${bindir}" \
                   "man1dir=${D}${mandir}" \
                   install
}
