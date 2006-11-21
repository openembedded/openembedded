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
