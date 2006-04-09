DESCRIPTION = "PPTP Client is a Linux, FreeBSD, NetBSD\
and OpenBSD client for the proprietary Microsoft Point-to-Point \
Tunneling Protocol, PPTP. Allows connection to a PPTP based \
Virtual Private Network (VPN) as used by employers and some \
cable and ADSL internet service providers."
LICENSE     = "GPL"
SECTION     = "network"
PRIORITY    = "optional"
DEPENDS     = "ppp "

inherit base

SRC_URI = "${SOURCEFORGE_MIRROR}/pptpclient/pptp-linux-1.5.0.tar.gz \
	   file://makefile.patch;patch=1 \
	   file://options.pptp"


do_configure() {
}

do_compile() {
	oe_runmake
}

do_install() {	
	install -d ${D}${sbindir}
	install -d ${D}/etc/
	install -d ${D}/etc/ppp/

	install -m 0755  pptp         ${D}${sbindir}/
	install -m 0644 ${WORKDIR}/options.pptp ${D}/etc/ppp/

}
