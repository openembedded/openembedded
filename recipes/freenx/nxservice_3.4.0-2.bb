LICENSE = "GPL"
DEPENDS = "nxcomp nxcompsh"

SRC_URI = "http://64.34.161.181/download/3.4.0/sources/${PN}-${PV}.tar.gz \
           "

SRC_URI[md5sum] = "c2a902ab6b8dd603f278dfb8c7d46bb4"
SRC_URI[sha256sum] = "38b4ed26d983f4d381bc80bcf3a1eccdf91a65174d7078c28425055fac8b8bc9"

S = "${WORKDIR}/${PN}"

inherit autotools

do_install () {
       install -d ${D}${bindir}/
       install -s -m 0755 nxservice ${D}${bindir}/
}
