LICENSE = "GPL"
DESCRIPTION = "modplugplay is a commandline mod-like audio file player."
SECTION = "console/multimedia"
MAINTAINER = "Michael 'Mickey' Lauer"
DEPENDS = "libmodplug"
PR = "r1"

SRC_URI = "http://www.linuks.mine.nu/modplugplay/modplugplay-${PV}.tar.gz"

do_compile() {
	${CC} -c ${CFLAGS} modplugplay.c -o modplugplay.o
	${CC} -o modplugplay modplugplay.o ${LDFLAGS} -lmodplug
}

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${mandir}/man1
        install -m 0755 modplugplay ${D}${bindir}/
        install -m 0644 modplugplay.1 ${D}${mandir}/man1/
}

