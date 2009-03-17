# Copyright Matthias Hentges <devel@hentges.net> (c) 2006

DESCRIPTION = "The Fluxbox WindowManager"
HOMEPAGE = "http://fluxbox.sourceforge.net"
LICENSE = "MIT"

REALPV = "1.0rc"

PV = "0.99+${REALPV}"
PR = "r1"
PE = "1" 


SRC_URI = "${SOURCEFORGE_MIRROR}/fluxbox/fluxbox-${REALPV}.tar.gz \
	   file://gpe-init.patch;patch=1 \
	   file://apps.gpe.* \
	   file://style.gpe-default \
	   file://fluxbox-gpe-session \
	   file://fluxbox-gpe.session \
	   file://keys.* \
	   file://keylaunchrc.fluxbox \
	   file://gpe-logout.fluxbox"

S = "${WORKDIR}/fluxbox-${REALPV}"

inherit autotools

EXTRA_OECONF = "--disable-xmb \
		"

do_install_append() {
	install -d ${D}${bindir}
	install -d ${D}${datadir}/fluxbox
	install -d ${D}${datadir}/fluxbox/styles
	install -d ${D}/etc

	install -m 0644 ${WORKDIR}/apps.gpe.* ${D}${datadir}/fluxbox
	install -m 0644 ${WORKDIR}/keys.* ${D}${datadir}/fluxbox
	install -m 0755 ${WORKDIR}/fluxbox-gpe.session ${D}${datadir}/fluxbox/session
	install -m 0644 ${WORKDIR}/style.gpe-default ${D}${datadir}/fluxbox/styles/gpe-default
	install -m 0755 ${WORKDIR}/fluxbox-gpe-session ${D}${bindir}
	install -m 0755 ${WORKDIR}/gpe-logout.fluxbox ${D}${bindir}
	install -m 0644 ${WORKDIR}/keylaunchrc.fluxbox ${D}/etc
}

PACKAGES = "${PN}-dbg ${PN}-gpe ${PN}-styles ${PN}-doc ${PN}"

DESCRIPTION_${PN}-styles = "The default styles for fluxbox"
DESCRIPTION_${PN}-gpe = "The Fluxbox WindowManager for use with GPE"
RDEPENDS_${PN}-gpe = "${PN}"

FILES_${PN} = "${bindir} \
	       ${datadir}/fluxbox/init \
	       ${datadir}/fluxbox/keys \
	       ${datadir}/fluxbox/menu "

FILES_${PN}-gpe = "${datadir}/fluxbox/apps.gpe* \
		   ${datadir}/fluxbox/keys.* \
		   ${bindir}/gpe-logout.fluxbox \
		   ${sysconfdir}/keylaunchrc.fluxbox \
		   ${datadir}/fluxbox/styles/gpe-default \
		   ${datadir}/fluxbox/session \
		   ${bindir}/fluxbox-gpe-session"

FILES_${PN}-styles = "${datadir}/fluxbox/styles"

FILES_${PN}-doc = "${datadir}/man"


pkg_postinst_${PN}-gpe() {
       update-alternatives --install ${bindir}/x-window-manager x-window-manager ${bindir}/fluxbox-gpe-session 15
       update-alternatives --install ${bindir}/gpe-logout gpe-logout ${bindir}/gpe-logout.fluxbox  15
       update-alternatives --install ${sysconfdir}keylaunchrc keylaunchrc ${sysconfdir}keylaunchrc.fluxbox 15
}

pkg_postrm_${PN}-gpe() {
       update-alternatives --remove x-window-manager ${bindir}/fluxbox-gpe-session
       update-alternatives --remove gpe-logout ${bindir}/gpe-logout.fluxbox
       update-alternatives --remove keylaunchrc ${sysconfdir}keylaunchrc.fluxbox
}
