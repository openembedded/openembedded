DESCRIPTION = "Poptop is the PPTP server solution for Linux Using Poptop, \
Linux servers can now function seamlessly in a PPTP VPN environment. This \
enables administrators to leverage the considerable benefits of both \
Microsoft and Linux operating systems The current release version supports \
Windows 95/98/Me/NT/2000/XP PPTP clients and Linux PPTP clients"
HOMEPAGE = "http://www.poptop.org/"
SECTION = "network"
LICENSE = "GPL"
RDEPENDS_${PN} = "ppp"
RDEPENDS_${PN}-logwtmp-plugin = "${PN}"
PR = "r4"

SRC_URI = "${SOURCEFORGE_MIRROR}/poptop/pptpd-${PV}.tar.gz \
           file://fix-plugins-install.patch;patch=1 \
           file://pptpd.init"

S = "${WORKDIR}/pptpd-${PV}"

inherit autotools update-rc.d

do_install_append() {
        # Install init script
        install -m 0755 -d ${D}${sysconfdir}/init.d
        install -m 0755 ${WORKDIR}/pptpd.init ${D}${sysconfdir}/init.d/pptpd
        # Install
        install -d ${D}${sbindir} ${D}/${sysconfdir} ${D}/${sysconfdir}/ppp
        install -m 0644 samples/options.pptpd ${D}/${sysconfdir}/ppp/
        install -m 0644 samples/pptpd.conf ${D}/${sysconfdir}/

        # broken
	sed -ri "s,^[:space:]*logwtmp[:space:]*,# logwtmp," ${D}/${sysconfdir}/pptpd.conf
        rm -f ${D}${libdir}/pptpd/pptpd-logwtmp.so
	# Use mppe option in OE style
	sed -ri "s,^[[:space:]]*require-mppe-128[[:space:]]*$,mppe required,no40,no56," ${D}/${sysconfdir}/ppp/options.pptpd
	echo "# don't expose open port by default" >> ${D}/${sysconfdir}/pptpd.conf
	echo "listen  127.0.0.1" >> ${D}/${sysconfdir}/pptpd.conf
}

PACKAGES = "${PN}-dbg ${PN}-bcrelay ${PN} ${PN}-doc"

FILES_${PN}-bcrelay = "${sbindir}/bcrelay"

CONFFILES_${PN} = "${sysconfdir}/pptpd.conf \
                   ${sysconfdir}/ppp/options.pptpd"

INITSCRIPT_NAME = "pptpd"
INITSCRIPT_PARAMS = "defaults 92 8"
