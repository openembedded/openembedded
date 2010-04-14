DESCRIPTION = "A security-aware DNS server"
SECTION = "console/network"
HOMEPAGE = "http://www.maradns.org"
LICENSE = "PD"

SRC_URI = "http://www.maradns.org/download/1.0/maradns-${PV}.tar.bz2 \
           file://init \
           file://rng-makefile-build-cc.patch;patch=1;pnum=0"

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${sbindir}
	install -d ${D}${sysconfdir}
	install -d ${D}${sysconfdir}/mararc
	install -d ${D}${sysconfdir}/init.d
	install -d ${D}${mandir}/man1
	install -d ${D}${mandir}/man5
	install -d ${D}${mandir}/man8

	sed -i -e "s:PREFIX/man:PREFIX/share/man:" \
                -e "s:PREFIX/doc/maradns-\$VERSION:PREFIX/share/doc/${PF}:" \
                build/install.locations

	oe_runmake \
                TOPLEVEL=${S} \
                BUILDDIR=${S}/build \
                RPM_BUILD_ROOT=${D} \
                PREFIX=${D}/usr \
                MAN1=${D}${mandir}/man1 \
                MAN5=${D}${mandir}/man5 \
                MAN8=${D}${mandir}/man8 \
                install

	mv ${D}${sysconfdir}/mararc/example_mararc ${D}${sysconfdir}/maradns/mararc
	rm -r ${D}${sysconfdir}/mararc/
	install -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/maradns
}

PACKAGES =+ "maradns-zone maradns-ask"
FILES_maradns-zone = "${sbindir}/zoneserver ${bindir}/getzone"
FILES_maradns-ask = "${bindir}/askmara"

CONFFILES_${PN}_nylon = "/etc/maradns/mararc"

SRC_URI[md5sum] = "5ac39978f55ecaf6e887cd5be027b1c3"
SRC_URI[sha256sum] = "4ac5940d25a9b5a52d0ff1f8223bb85462f9cfcceb4ac547e3ca9b6690aad394"
