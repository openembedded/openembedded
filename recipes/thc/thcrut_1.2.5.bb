DESCRIPTION = "RUT (aRe-yoU-There) RUT gathers informations from local and remote networks"
SECTION = "console/network"
DEPENDS = "libpcre openssl libnet libpcap"
HOMEPAGE = "http://thc.org/thc-rut/"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://packetstorm.linuxsecurity.com/groups/thc/thcrut-1.2.5.tar.gz \
	   file://configure_in.patch;patch=1;pnum=0"

S = "${WORKDIR}/thcrut-${PV}"

inherit autotools

EXTRA_OECONF = "--with-ssl=${STAGING_LIBDIR}/.."


SRC_URI[md5sum] = "190f08ce6839aecb0fa0ce8d5ddd09ee"
SRC_URI[sha256sum] = "b32f3d71ac540248b7643baa39d8ecfb75af493228caaeb64608e49f2f092473"
