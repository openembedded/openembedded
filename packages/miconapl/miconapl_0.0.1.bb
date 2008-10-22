DESCRIPTION = "miconapl daemon for ARM Linkstations"
SECTION = "console/network"
DEPENDS = ""
PR = "r2"
LICENSE = "GPL"
COMPATIBLE_MACHINE = "lsarm"

SRC_URI = "http://downloads.linkstationwiki.net/Users/timtimred/lsarm/miconapl.tar.gz"

inherit autotools gettext update-rc.d

S = ${WORKDIR}/miconapl

FILES_${PN} += "/usr/lib/libbuffalo_bin.so"

INITSCRIPT_NAME = "miconapl"
INITSCRIPT_PARAMS = "defaults 95"

do_configure() {
}

do_compile() {
}

do_install() {
	mkdir -p ${D}/usr/lib
	install -D -m 0755 ${S}/usr/lib/libbuffalo_bin.so ${D}/usr/lib/
	install -D -m 0755 ${S}/usr/local/sbin/miconapl ${D}${sbindir}/miconapl
	install -D -m 0755 ${S}/etc/init.d/miconapl ${D}${sysconfdir}/init.d/miconapl
	install -D -m 0755 ${S}/etc/init.d/logtag ${D}${sysconfdir}/init.d/logtag
}
