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
       install -m 0755 nxproxy ${D}${bindir}/
}

SRC_URI[md5sum] = "ac31e8f2f112e3720f3c00cec67c0734"
SRC_URI[sha256sum] = "5642ce40e2f34caeed433e8c0ac010e2e7e738c2c5aa8fc59bba892a8b542d84"
