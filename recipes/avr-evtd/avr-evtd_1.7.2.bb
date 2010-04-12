DESCRIPTION = "A simple and small user space interface daemon to the Linkstation/Kuro AVR micro-controller"
HOMEPAGE = "http://sourceforge.net/projects/ppc-evtd"
SECTION = "console/network"
PR = "r1"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/ppc-evtd/avr_evtd_${PV}.release.tar.gz \
	   file://dont-ignore-config.patch;patch=1 \
	   file://avr_evtd.conf \
	   file://EventScript \
	   file://init"
S = "${WORKDIR}/usr/src/avr_evtd"

inherit update-rc.d

COMPATIBLE_MACHINE = "(lsppchd|lsppchg|lsmipsel)"
INITSCRIPT_NAME = "avr-evtd"
INITSCRIPT_PARAMS = "defaults"

# This is a simple thing and we will only ever need this for powerpc and mipsel
# on the platforms above. Pretty important though to stop death by watchdog.

do_compile_powerpc() {
	${CC} ${CFLAGS} ${LDFLAGS} -o PPC/avr_evtd avr_evtd.c -DNO_MELCO -DUBOOT
}

do_compile_mipsel() {
	${CC} ${CFLAGS} ${LDFLAGS} -o MIPS/avr_evtd avr_evtd.c -DNO_MELCO -DUBOOT -DMIPS
}

do_install() {
	install -D -m 0644 ${WORKDIR}/avr_evtd.conf ${D}${sysconfdir}/default/avr_evtd
	install -D -m 0755 ${WORKDIR}/EventScript ${D}${sysconfdir}/avr_evtd/EventScript
	install -D -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/avr-evtd
}

do_install_append_powerpc() {
	install -D -m 0755 ${S}/PPC/avr_evtd ${D}${sbindir}/avr_evtd
}

do_install_append_mipsel() {
	install -D -m 0755 ${S}/MIPS/avr_evtd ${D}${sbindir}/avr_evtd
}

SRC_URI[md5sum] = "782600479e7967ab104309ee467b57b0"
SRC_URI[sha256sum] = "bf52cccf8d4a36f75ba364310c602210498b7642951aed5b838de2750d347d22"
