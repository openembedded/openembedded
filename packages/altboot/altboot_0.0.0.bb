DESCRIPTION = "A text-based bootmanager allowing a Zaurus to boot from SD, CF, USB-Storage and NFS. \
Tested machines: Collie, Poodle, Akita, Spitz, C7x0, Tosa, Borzoi"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Matthias 'CoreDump' Hentges  <oe@hentges.net>"
LICENSE = "GPL"
IGNORE_STRIP_ERRORS = "1"

PR = "r33"


SRC_URI = "file://altboot-menu \
	   file://altboot.rc \
	   file://altboot.func \	 
	   file://init.altboot \
	   file://altboot*.cfg"

# S = "${WORKDIR}/files"
 
do_install() {
	install -d ${D}/sbin
	install -d ${D}/etc/altboot-menu
	install -d ${D}/etc/altboot-menu/Advanced
	install -d ${D}/etc/altboot.rc
	install -d ${D}/usr/share/doc/altboot
	
	install -m 0644 ${WORKDIR}/altboot*.cfg ${D}/etc
	install -m 0644 ${WORKDIR}/altboot.func ${D}/etc
#	install -m 0644 ${WORKDIR}/docs/altboot/*.txt ${D}/usr/share/doc/altboot
	install -m 0755 ${WORKDIR}/init.altboot ${D}/sbin	
	install -m 0755 ${WORKDIR}/altboot-menu/*-* ${D}/etc/altboot-menu
	install -m 0755 ${WORKDIR}/altboot-menu/Advanced/*-* ${D}/etc/altboot-menu/Advanced
	install -m 0755 ${WORKDIR}/altboot.rc/*.sh ${D}/etc/altboot.rc
	install -m 0644 ${WORKDIR}/altboot.rc/*.txt ${D}/etc/altboot.rc	
}		

do_configure() {
	cat ${WORKDIR}/init.altboot | sed "s/^VERSION=.*/VERSION=\"0.0.0 Developer Snapshot (${DATE})\"/" > ${WORKDIR}/init.altboot_
	mv ${WORKDIR}/init.altboot_ ${WORKDIR}/init.altboot
}


pkg_postinst() {
	update-alternatives --install /sbin/init init /sbin/init.altboot 55
}

pkg_postrm() {
	update-alternatives --remove init /sbin/init.altboot
}
