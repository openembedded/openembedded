#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2006
# License: MIT (see http://www.opensource.org/licenses/mit-license.php for a copy of the license)
#
# Filename: alsa-settings_0.0.1.bb
# Date: 16-Jul-06

DESCRIPTION = "Provides alsa preferences and preferences-loading for kernel 2.6 non-clamshell devices"
MAINTAINER = "Matthias 'CoreDump' Hentges <oe@hentges.net>"
HOMEPAGE = "http://www.hentges.net/misc/openzaurus/index.shtml"
LICENSE = "GPL"

######################################################################################

PR = "r0"

######################################################################################

SRC_URI = "file://asound.state \
	   file://alsa-settings.sh"
	   
######################################################################################

FILES_${PN} += "/usr/share/alsa"

######################################################################################

do_install() {
	install -d ${D}/usr/share/alsa
	install -d ${D}/etc/init.d
	
	install -m 755 ${WORKDIR}/asound.state ${D}/usr/share/alsa/asound.state.default
	install -m 755 ${WORKDIR}/alsa-settings.sh ${D}/etc/init.d/alsa-settings
}

######################################################################################
	   
pkg_postinst_${PN}() {
	update-rc.d -s alsa-settings defaults 05
}

pkg_postrm_${PN}() {	
	update-rc.d -f alsa-settings remove
}
