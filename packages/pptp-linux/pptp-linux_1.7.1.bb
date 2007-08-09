DESCRIPTION = "PPTP Client is a Linux, FreeBSD, NetBSD \
and OpenBSD client for the proprietary Microsoft Point-to-Point \
Tunneling Protocol, PPTP. Allows connection to a PPTP based \
Virtual Private Network (VPN) as used by employers and some \
cable and ADSL internet service providers."
HOMEPAGE = "http://pptpclient.sourceforge.net"
SECTION = "network"
LICENSE = "GPL"
RDEPENDS = "ppp"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/sourceforge/pptpclient/pptp-${PV}.tar.gz \
           file://options.pptp"

S = "${WORKDIR}/pptp-${PV}"

do_compile() {
        oe_runmake
}
do_install() {
        install -d ${D}${sbindir} ${D}${sysconfdir}/ppp ${D}${mandir}/man8
        install -m 555 pptp ${D}${sbindir}
        install -m 644 pptp.8 ${D}${mandir}/man8
        install -m 644 ${WORKDIR}/options.pptp ${D}${sysconfdir}/ppp
}
