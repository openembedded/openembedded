#! /bin/sh
#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2006
# License: GPL (see http://www.gnu.org/licenses/gpl.txt for a copy of the license)
#
# Filename: altboot_1.0.5-rc2.bb
# Date: 21-Feb-06

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
RDEPENDS_${PN}-conf = "${PN}"

######################################################################################

PR = "r0"

######################################################################################

PACKAGES = "${PN}-conf ${PN}-doc ${PN}"

PACKAGE_ARCH_${PN} = all
PACKAGE_ARCH_${PN}-doc = all
PACKAGE_ARCH_${PN}-conf = "${MACHINE}"

TAG = "${@'v' + bb.data.getVar('PV',d,1).replace('.', '-')}"

SRC_URI = "cvs://anonymous@hentges.net/hentgescvs;method=pserver;tag=${TAG};module=altboot"

S = "${WORKDIR}/altboot/"

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
	
	if test -d ${WORKDIR}/altboot/${MACHINE}
	then
		install -m 0644 ${WORKDIR}/altboot/${MACHINE}/altboot*.cfg ${D}/etc
	else
		install -m 0644 ${WORKDIR}/altboot/altboot*.cfg ${D}/etc
	fi

	install -m 0644 ${WORKDIR}/altboot/beep.raw ${D}/usr/share/sounds
	install -m 0644 ${WORKDIR}/altboot/altboot.func ${D}/etc
	install -m 0755 ${WORKDIR}/altboot/init.altboot ${D}/sbin
	
	install -m 0755 ${WORKDIR}/altboot/altboot-menu/*-* ${D}/etc/altboot-menu

	install -m 0755 ${WORKDIR}/altboot/altboot-menu/Advanced/*-* ${D}/etc/altboot-menu/Advanced
	
	install -m 0755 ${WORKDIR}/altboot/altboot.rc/*.sh ${D}/etc/altboot.rc
	install -m 0644 ${WORKDIR}/altboot/altboot.rc/*.txt ${D}/etc/altboot.rc	
}		

######################################################################################

do_configure() {
	cat ${WORKDIR}/altboot/init.altboot | sed "s/^VERSION=.*/VERSION=\"${PV}\"/" > ${WORKDIR}/altboot/init.altboot_
	mv ${WORKDIR}/altboot/init.altboot_ ${WORKDIR}/altboot/init.altboot
}

######################################################################################

pkg_postinst_${PN}() {
	update-alternatives --install /sbin/init init /sbin/init.altboot 55
}

######################################################################################

pkg_postrm_${PN}() {
	update-alternatives --remove init /sbin/init.altboot
}

