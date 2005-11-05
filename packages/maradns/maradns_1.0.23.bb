SECTION = "console/network"
DESCRIPTION = "A security-aware DNS server"
HOMEPAGE = "http://www.maradns.org"
LICENSE = "PD"
MAINTAINER = "Bruno Randolf <bruno.randolf@4g-systems.biz>"
PR = "r1"

SRC_URI = "http://www.maradns.org/download/maradns-${PV}.tar.bz2 \
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

PACKAGES = "maradns-zone maradns-ask maradns maradns-doc"
FILES_maradns-zone = "${sbindir}/zoneserver ${bindir}/getzone"
FILES_maradns-ask = "${bindir}/askmara"

CONFFILES_${PN}_nylon = "/etc/maradns/mararc"
