DESCRIPTION = "modplugplay is a commandline mod-like audio file player."
HOMEPAGE = "http://gnu.ethz.ch/linuks.mine.nu/modplugplay/"
LICENSE = "GPL"
SECTION = "console/multimedia"
DEPENDS = "libmodplug"
PR = "r1"

SRC_URI = "http://gnu.ethz.ch/linuks.mine.nu/modplugplay/modplugplay-${PV}.tar.gz"

do_compile() {
	${CC} -c ${CFLAGS} modplugplay.c -o modplugplay.o
	${CC} -o modplugplay modplugplay.o ${LDFLAGS} -lmodplug -lstdc++
}

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${mandir}/man1
	install -m 0755 modplugplay ${D}${bindir}/
	install -m 0644 modplugplay.1 ${D}${mandir}/man1/
}

SRC_URI[md5sum] = "ac8e98865d90dca25c85748b3916bf07"
SRC_URI[sha256sum] = "d78a39b4158901695c59d0757e8fe622e9b4cebcfb77eedfc20b937e5a0d521d"
