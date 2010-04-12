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

SRC_URI[md5sum] = "047206e5a811b915aac4ae09bddef207"
SRC_URI[sha256sum] = "dc1b5e26c4629d35b59dcb25852bcf705c29053a20763a7339b5d890614a9e87"
