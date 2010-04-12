DESCRIPTION = "Daemon to allow scratchbox to use your device as a CPU tranparency target"
HOMEPAGE = "http://scratchbox.org"
LICENSE = "GPLv2"
DEPENDS = "fakeroot"
PR = "r1"
RRECOMMENDS = "kernel-module-nfs"

SRC_URI = "http://scratchbox.org/download/files/sbox-releases/1.0/src/${P}.tar.gz"

do_install() {
	install -d ${D}${sbindir}
	install -m 755 sbrsh sbrshd sb-exportfs ${D}${sbindir}
	install -d ${D}/${sysconfdir}
	touch ${D}/${sysconfdir}/sbrshd.conf
}

CONFFILES_${PN} = "${sysconfdir}/sbrshd.conf"

SRC_URI[md5sum] = "2ca6d18cf54af3d62bfcc01d884bd493"
SRC_URI[sha256sum] = "0e2e0524f0559daa6816e4f7ad83b29891455c35c61694bcc5869e2011e3c808"
