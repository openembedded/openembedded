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
