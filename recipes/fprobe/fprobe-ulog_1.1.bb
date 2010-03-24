DESCRIPTION = "NetFlow probe (libipulog version)"
SECTION = "network"
LICENSE = "GPL"

SRC_URI = " \
	${SOURCEFORGE_MIRROR}/fprobe/fprobe-ulog/1.1/fprobe-ulog-${PV}.tar.bz2;name=tar \
	file://init.d \
	file://default \
	"
SRC_URI[tar.md5sum] = "cdb2e4edc47e8a3d5479eeabfb979ebc"
SRC_URI[tar.sha256sum] = "53b9ccbca4469dfb0e9da91f9f0789dbf732f2adac9de18842e3c210b445f2ad"

inherit autotools update-rc.d

INITSCRIPT_NAME = "fprobe-ulog"

do_install_append() {
	ln -s fprobe-ulog ${D}/usr/sbin/fprobe
        install -d ${D}/${sysconfdir}/init.d
        install -m 0755 ${WORKDIR}/init.d ${D}/${sysconfdir}/init.d/fprobe-ulog
	install -d ${D}/${sysconfdir}/default
	install -m 0644 ${WORKDIR}/default ${D}/${sysconfdir}/default/fprobe-ulog
}
