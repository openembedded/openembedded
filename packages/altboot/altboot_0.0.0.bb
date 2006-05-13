#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2006
# License: GPL (see http://www.gnu.org/licenses/gpl.txt for a copy of the license)
#
# Filename: altboot_0.0.0.bb
# Date: 07-May-06

DESCRIPTION = "The altboot bootmanager"
MAINTAINER = "Matthias 'CoreDump' Hentges <oe@hentges.net>"
HOMEPAGE = "http://www.hentges.net/misc/openzaurus/index.shtml"
LICENSE = "GPL"

######################################################################################

RRECOMMENDS_${PN} = "e2fsprogs-e2fsck dosfstools"
RRECOMMENDS_${PN}_append_akita = " kexec-tools"
RRECOMMENDS_${PN}_append_spitz = " kexec-tools"
RRECOMMENDS_${PN}_append_c7x0 = " kexec-tools"

RDEPENDS_${PN} = "${PN}-conf"

######################################################################################

PR = "r43"

######################################################################################

PACKAGES = "${PN}-conf ${PN}-doc ${PN}"

PACKAGE_ARCH_${PN} = all
PACKAGE_ARCH_${PN}-doc = all
PACKAGE_ARCH_${PN}-conf = "${MACHINE}"

SRC_URI = "file://altboot-menu \
	   file://altboot.rc \
	   file://altboot.func \	 
	   file://init.altboot \
	   file://altboot*.cfg \
	   file://beep.raw"

# S = "${WORKDIR}/altboot/"

######################################################################################

FILES_${PN}-conf = "/etc/altboot*.cfg"

######################################################################################

do_install() {
	install -d ${D}/sbin
	install -d ${D}/etc/altboot-menu
	install -d ${D}/etc/altboot-menu/Advanced
	install -d ${D}/etc/altboot.rc
	install -d ${D}/usr/share/doc/altboot
	install -d ${D}/usr/share/sounds		

	install -m 0644 ${WORKDIR}/beep.raw ${D}/usr/share/sounds
	install -m 0644 ${WORKDIR}/altboot*.cfg ${D}/etc
	install -m 0644 ${WORKDIR}/altboot.func ${D}/etc
	install -m 0755 ${WORKDIR}/init.altboot ${D}/sbin
	
	install -m 0755 ${WORKDIR}/altboot-menu/*-* ${D}/etc/altboot-menu

	install -m 0755 ${WORKDIR}/altboot-menu/Advanced/*-* ${D}/etc/altboot-menu/Advanced
	
	install -m 0755 ${WORKDIR}/altboot.rc/*.sh ${D}/etc/altboot.rc
	install -m 0644 ${WORKDIR}/altboot.rc/*.txt ${D}/etc/altboot.rc	
}		

######################################################################################

do_configure() {
	cat ${WORKDIR}/init.altboot | sed "s/^VERSION=.*/VERSION=\"0.0.0 Developer Snapshot (${DATE})\"/" > ${WORKDIR}/init.altboot_
	mv ${WORKDIR}/init.altboot_ ${WORKDIR}/init.altboot
}

######################################################################################

pkg_postinst_${PN}() {
	update-alternatives --install /sbin/init init /sbin/init.altboot 55
}

######################################################################################

pkg_postrm_${PN}() {
	update-alternatives --remove init /sbin/init.altboot
}

