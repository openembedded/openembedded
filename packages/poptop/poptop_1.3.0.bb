DESCRIPTION = "Poptop is the PPTP server solution for Linux \
Using Poptop, Linux servers can now function seamlessly in a PPTP VPN environment. \
This enables administrators to leverage the considerable benefits of both Microsoft and Linux operating systems \
The current release version supports Windows 95/98/Me/NT/2000/XP PPTP clients and Linux PPTP clients \
For more info visit http://www.poptop.org/"

MAINTAINER  = "Stelios Koroneos <skoroneos@digital-opsis.com> "
HOMEPAGE    = "http://www.poptop.org/"	
LICENSE     = "GPL"
SECTION     = "network"
PRIORITY    = "optional"
DEPENDS     = "ppp"
RDEPENDS    = "ppp"	

PR = "r0"

inherit autotools

SRC_URI = "${SOURCEFORGE_MIRROR}/poptop/pptpd-${PV}.tar.gz"
S = "${WORKDIR}/pptpd-${PV}"



do_install() {	
	install -d ${D}${sbindir}
	install -d ${D}/${sysconfdir}
	install -d ${D}/${sysconfdir}/ppp/

	install -m 0755  pptpd         ${D}${sbindir}/
	install -m 0755  pptpctrl      ${D}${sbindir}/
	install -m 0644 samples/options.pptpd ${D}/${sysconfdir}/ppp/
	install -m 0644 samples/pptpd.conf    ${D}/${sysconfdir}/


}

