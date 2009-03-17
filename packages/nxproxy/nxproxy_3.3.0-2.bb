DESCRIPTION = "The binary which uses libxcomp from nomachine"
HOMEPAGE = "http://www.nomachine.com/"
LICENSE = "GPL"
PR = "r0"

DEPENDS = "libxcomp"

SRC_URI = "http://64.34.161.181/download/3.3.0/sources/${PN}-${PV}.tar.gz \
	  "
inherit autotools
          
S = "${WORKDIR}/nxproxy"

do_install () {
       install -d ${D}${bindir}/
       install -m 0755 nxproxy ${D}${bindir}/
}
