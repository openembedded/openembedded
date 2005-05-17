DESCRIPTION = "RUT (aRe-yoU-There) RUT gathers informations from local and remote networks"
SECTION = "console/network"
DEPENDS = "openssl libnet"
HOMEPAGE = "http://thc.org/thc-rut/"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://packetstorm.linuxsecurity.com/groups/thc/thcrut-1.2.5.tar.gz \
	   file://configure_in.patch;patch=1;pnum=0" 

S = "${WORKDIR}/thcrut-${PV}"

inherit autotools 

EXTRA_OECONF = "--with-ssl=${STAGING_LIBDIR}/.."

