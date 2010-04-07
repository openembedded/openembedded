DESCRIPTION = "userspace utils for aufs2"
LICENSE = "GPL"
DEPENDS = "virtual/kernel"
PR = "r1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRCREV = "f35ba2292fe40aa94aa83713e0b2719f35a25768"
SRC_URI = "git://git.c3sl.ufpr.br/pub/scm/aufs/aufs2-util.git;protocol=http"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "KDIR=${STAGING_KERNEL_DIR} DESTDIR=${D}"

do_compile () {
	# c2tmac and c2sh need to be BUILD-arch
	${BUILD_CC} -I${STAGING_KERNEL_DIR}/include c2tmac.c -o c2tmac
	${BUILD_CC} -I${STAGING_KERNEL_DIR}/include c2sh.c -o c2sh
        oe_runmake
}

do_install () {
	install -d ${D}/${base_sbindir}
	install -m 0755 mount.aufs umount.aufs auplink ${D}/${base_sbindir}
	install -d ${D}/${base_bindir}
	install -m 0755 auchk aubrsync ${D}/${base_bindir}
	install -d ${D}/${sysconfdir}/default
	install -m 0644 -T etc_default_aufs ${D}/${sysconfdir}/default/aufs
}
