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

SRC_URI[md5sum] = "e9bb4c1cd61c42db9626894845fcf3f7"
SRC_URI[sha256sum] = "797dab52e18592d340c36ef6e126368bc1c9c98bbb873bef9ba9fc70911616b9"
