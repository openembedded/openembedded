SECTION = "console/network"
DESCRIPTION = "Dnsmasq is a lightweight, easy to configure DNS forwarder and DHCP server."
HOMEPAGE = "http://www.thekelleys.org.uk/dnsmasq/doc.html"
LICENSE = "GPL"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"

SRC_URI = "http://www.thekelleys.org.uk/dnsmasq/dnsmasq-${PV}.tar.gz \
           file://init \
           file://dnsmasq.conf"

S = "${WORKDIR}/dnsmasq-${PV}"

inherit update-rc.d

INITSCRIPT_NAME = "dnsmasq"
INITSCRIPT_PARAMS = "defaults"

do_install () {
        oe_runmake "PREFIX=${D}${prefix}" \
                   "BINDIR=${D}${bindir}" \
                   "MANDIR=${D}${mandir}" \
                   install
        install -d ${D}${sysconfdir}/ ${D}${sysconfdir}/init.d
        install -m 0755 ${WORKDIR}/dnsmasq.conf ${D}${sysconfdir}/
        install -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/dnsmasq
}

CONFFILES_${PN} = "${sysconfdir}/dnsmasq.conf"
