DESCRIPTION = "The nxssh fork from nomachine"
HOMEPAGE = "http://www.nomachine.com/"
LICENSE = "BSD/OPENSSH"
PR = "r0"

DEPENDS = "openssl libxcomp"

SRC_URI = "http://64.34.161.181/download/3.3.0/sources/${PN}-${PV}.tar.gz \
	   file://autotools.patch;patch=1 \
	   file://stdarg.patch;patch=1 \
	   file://link.patch;patch=1 \
	  "
inherit autotools
          
S = "${WORKDIR}/nxssh"

do_install () {
       install -d ${D}${bindir}/
       install -m 0755 nxssh ${D}${bindir}/
}
