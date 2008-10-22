DESCRIPTION = "Ethernet/FDDI station activity monitor"
HOMEPAGE = "http://www-nrg.ee.lbl.gov/"
SECTION = "network"
LICENSE = "BSD"
RRECOMMENDS = "arpwatch-data"
PR = "r2"

SRC_URI = "ftp://ftp.ee.lbl.gov/arpwatch-${PV}.tar.gz \
           file://05debian_fhs.patch;patch=1 \
           file://06debian_manpages.patch;patch=1 \
           file://init.d \
           file://arpwatch.default \
           file://arpwatch.conf \
           file://ethercodes.dat \
           file://make.patch;patch=1 \
           file://volatiles.08_arpwatch"

inherit autotools update-rc.d

PACKAGES =+ "arpwatch-data"

FILES_arpwatch-data = "${datadir}/arpwatch/ethercodes.dat"

fakeroot do_install() {
        install -d ${D}${bindir} ${D}${sbindir} ${D}${mandir}/man8 \
                ${D}${sysconfdir}/default \
                ${D}${sysconfdir}/init.d \
                ${D}${datadir}/arpwatch \
                ${D}${sysconfdir}/default/volatiles
        oe_runmake install DESTDIR=${D}
        oe_runmake install-man DESTDIR=${D}
        for i in arp2ethers arpfetch massagevendor; do
          install -m 0755 ${S}/$i ${D}${sbindir}
        done
        install -m 0755 ${S}/bihourly.sh ${D}${sbindir}/bihourly
        for i in arp2ethers arpfetch bihourly massagevendor; do
          install -m 0644 ${S}/$i.8 ${D}${mandir}/man8
        done
        install -m 0755 ${WORKDIR}/init.d ${D}${sysconfdir}/init.d/arpwatch
        install -m 0644 ${WORKDIR}/arpwatch.default ${D}${sysconfdir}/default/arpwatch
        install -m 0644 ${WORKDIR}/arpwatch.conf ${D}${sysconfdir}
        install -m 0644 ${WORKDIR}/ethercodes.dat ${D}${datadir}/arpwatch

        # We need some /var directories
        for i in 08_arpwatch; do
          install -m 0644 ${WORKDIR}/volatiles.$i ${D}${sysconfdir}/default/volatiles/$i
        done
}

pkg_postinst_${PN} () {
        /etc/init.d/populate-volatile.sh update
}

CONFFILES_${PN} = "${sysconfdir}/default/arpwatch \
                   ${sysconfdir}/arpwatch.conf"

INITSCRIPT_NAME = "arpwatch"
INITSCRIPT_PARAMS = "defaults 95 05"
