DESCRIPTION = "zd1211 wifi files for the Linux kernel"
HOMEPAGE = "http://zd1211.ath.cx/"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/zd1211/zd1211-firmware-${PV}.tar.bz2"

S = "${WORKDIR}"

do_compile() {
	:
}

do_install() {
	install -d  ${D}/lib/firmware/zd1211
	cp -rpP zd1211-firmware/* ${D}/lib/firmware/zd1211
}

FILES_${PN} += "/lib/firmware/zd1211/*"
PACKAGE_ARCH = "all"


SRC_URI[md5sum] = "19f28781d76569af8551c9d11294c870"
SRC_URI[sha256sum] = "866308f6f59f7075f075d4959dff2ede47735c751251fecd1496df1ba4d338e1"
