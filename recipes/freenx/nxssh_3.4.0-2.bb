DESCRIPTION = "The nxssh fork from nomachine"
HOMEPAGE = "http://www.nomachine.com/"
LICENSE = "BSD/OPENSSH"
PR = "r0"

DEPENDS = "openssl libxcomp"

inherit gettext

SRC_URI = "http://64.34.161.181/download/3.4.0/sources/${PN}-${PV}.tar.gz \
	   file://autotools.patch \
	   file://stdarg.patch \
	   file://link.patch \
           "

SRC_URI[md5sum] = "18b81d850223ea84de244f8a9509c4b1"
SRC_URI[sha256sum] = "71f88acb6b1135ddd2ea1a172df5dbcf260d2d4c0805f857635ce2acbcf1212e"

S = "${WORKDIR}/${PN}"

inherit autotools gettext

do_install () {
       install -d ${D}${bindir}/
       install -s -m 0755 nxssh ${D}${bindir}/
}
