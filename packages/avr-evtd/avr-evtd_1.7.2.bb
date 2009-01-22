DESCRIPTION = "A simple and small user space interface daemon to the Linkstation/Kuro AVR micro-controller"
HOMEPAGE = "http://sourceforge.net/projects/ppc-evtd"
SECTION = "console/network"
PR = "r0"
LICENSE = "GPL"
SRC_URI = "${SOURCEFORGE_MIRROR}/ppc-evtd/avr_evtd_${PV}.release.tar.gz \
	   file://dont-ignore-config.patch;patch=1 \
	   file://avr_evtd.conf \
	   file://EventScript \
		"
S = "${WORKDIR}/usr/src/avr_evtd"

COMPATIBLE_MACHINE = "(lsppchd|lsppchg|lsmipsel)"

# This is a simple thing, and we will only ever need this for powerpc and mipsel
# on the platforms above. Pretty important though to stop death by watchdog.

do_compile_powerpc() {
	${CC} ${CFLAGS} ${LDFLAGS} -o PPC/avr_evtd avr_evtd.c -DNO_MELCO -DUBOOT
}

do_compile_mipsel() {
	${CC} ${CFLAGS} ${LDFLAGS} -o MIPS/avr_evtd avr_evtd.c -DNO_MELCO -DUBOOT -DMIPS
}

do_install() {
	install -d ${D}${sbindir}
	install -d ${D}${sysconfdir}/default
	install -m 644 ${WORKDIR}/avr_evtd.conf ${D}${sysconfdir}/default/avr_evtd
	install -d ${D}${sysconfdir}/avr_evtd
	install -m 755 ${WORKDIR}/EventScript ${D}${sysconfdir}/avr_evtd/EventScript
}

do_install_append_powerpc() {
	install -c -m 755 ${S}/PPC/avr_evtd ${D}${sbindir}/avr_evtd
}

do_install_append_mipsel() {
	install -c -m 755 ${S}/MIPS/avr_evtd ${D}${sbindir}/avr_evtd
}
