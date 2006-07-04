#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2006
# License: MIT (see http://www.opensource.org/licenses/mit-license.php for a copy of the license)
#
# Filename: fluxbox-gpe_1.0rc.bb
# Date: 01-Jul-06

DESCRIPTION = "The Fluxbox WindowManager"
MAINTAINER = "Matthias 'CoreDump' Hentges <oe@hentges.net>"
HOMEPAGE = "http://fluxbox.sourceforge.net"
LICENSE = "MIT"
REALPV = "1.0rc"
PR = "r1"

######################################################################################

S = "${WORKDIR}/fluxbox-${REALPV}"

######################################################################################

SRC_URI = "${SOURCEFORGE_MIRROR}/fluxbox/fluxbox-${REALPV}.tar.gz \
	   file://gpe-init.patch;patch=1 \
	   file://apps.gpe.* \
	   file://style.gpe-default \
	   file://fluxbox-gpe-session \
	   file://fluxbox-gpe.session"

######################################################################################

PACKAGES = "${PN}-gpe ${PN}-styles ${PN}-doc ${PN}"

DESCRIPTION_${PN}-styles = "The default styles for fluxbox"
DESCRIPTION_${PN}-gpe = "The Fluxbox WindowManager for use with GPE"
RDEPENDS_${PN}-gpe = "${PN}"

######################################################################################

FILES_${PN} = "/usr/bin \
	       /usr/share/fluxbox/init \
	       /usr/share/fluxbox/keys \
	       /usr/share/fluxbox/menu "

FILES_${PN}-gpe = "/usr/share/fluxbox/apps.gpe* \
		   /usr/share/fluxbox/styles/gpe-default \
		   /usr/share/fluxbox/session \
		   /usr/bin/fluxbox-gpe-session"

FILES_${PN}-styles = "/usr/share/fluxbox/styles"

FILES_${PN}-doc = "/usr/share/man"

######################################################################################

inherit autotools

######################################################################################

EXTRA_OECONF = "--disable-xmb \
		"

######################################################################################

do_install_append() {
	install -d ${D}/usr/bin
	install -d ${D}/usr/share/fluxbox
	install -d ${D}/usr/share/fluxbox/styles
	
	install -m 0644 ${WORKDIR}/apps.gpe.* ${D}/usr/share/fluxbox
	install -m 0755 ${WORKDIR}/fluxbox-gpe.session ${D}/usr/share/fluxbox/session
	install -m 0644 ${WORKDIR}/style.gpe-default ${D}/usr/share/fluxbox/styles/gpe-default
	install -m 0755 ${WORKDIR}/fluxbox-gpe-session ${D}/usr/bin
}

######################################################################################

pkg_postinst_${PN}-gpe() { 
       update-alternatives --install /usr/bin/x-window-manager x-window-manager /usr/bin/fluxbox-gpe-session 15
}

pkg_postrm_${PN}-gpe() {   
       update-alternatives --remove x-window-manager /usr/bin/fluxbox-gpe-session
}
