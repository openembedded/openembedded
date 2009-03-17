DESCRIPTION = "The binary which uses libxcomp from nomachine"
HOMEPAGE = "http://www.nomachine.com/"
LICENSE = "GPL"
PR = "r1"

DEPENDS = "libxcomp"

SRC_URI = "http://64.34.161.181/download/3.2.0/sources/${PN}-${PV}.tar.gz \
	   file://stdin.patch;patch=1 \
	  "
inherit autotools
          
S = "${WORKDIR}/nxproxy"

do_install () {
       install -d ${D}${bindir}/
       install -s -m 0755 nxproxy ${D}${bindir}/
}
