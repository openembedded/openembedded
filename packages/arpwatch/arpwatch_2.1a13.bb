DESCRIPTION = "Ethernet/FDDI station activity monitor"
LICENSE = "BSD"
SECTION = "network"
HOMEPAGE = "http://www-nrg.ee.lbl.gov/"
RRECOMMENDS = "arpwatch-data"

SRC_URI = "ftp://ftp.ee.lbl.gov/arpwatch-${PV}.tar.gz \
    file://05debian_fhs.patch;patch=1 \
    file://06debian_manpages.patch;patch=1 \
    file://init.d \
    file://arpwatch.default \
    file://arpwatch.conf \
    file://ethercodes.dat \
    file://make.patch;patch=1"

inherit autotools

EXTRA_OEMAKE = "LDFLAGS=-L${STAGING_LIBDIR}"

fakeroot do_install() {
    install -d ${D}${bindir} ${D}${sbindir} ${D}${mandir}/man8 \
               ${D}${sysconfdir}/default \
               ${D}${sysconfdir}/init.d \
               ${D}${datadir}/arpwatch

    oe_runmake install DESTDIR=${D}
    oe_runmake install-man DESTDIR=${D}

    install -m 0755 ${S}/arp2ethers         ${D}${sbindir}
    install -m 0755 ${S}/arpfetch           ${D}${sbindir}
    install -m 0755 ${S}/bihourly           ${D}${sbindir}
    install -m 0755 ${S}/massagevendor      ${D}${sbindir}

    install -m 0644 ${S}/arp2ethers.8      ${D}${mandir}/man8
    install -m 0644 ${S}/arpfetch.8        ${D}${mandir}/man8
    install -m 0644 ${S}/bihourly.8        ${D}${mandir}/man8
    install -m 0644 ${S}/massagevendor.8   ${D}${mandir}/man8

    install -m 0755 ${WORKDIR}/init.d      ${D}${sysconfdir}/init.d/arpwatch
    install -m 0644 ${WORKDIR}/arpwatch.default   ${D}${sysconfdir}/default/arpwatch
    install -m 0644 ${WORKDIR}/arpwatch.conf      ${D}${sysconfdir}

    install -m 0644 ${WORKDIR}/ethercodes.dat     ${D}${datadir}/arpwatch
}

PACKAGES =+ "arpwatch-data"
FILES_arpwatch-data = "${datadir}/arpwatch/ethercodes.dat"
