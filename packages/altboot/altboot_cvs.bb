DESCRIPTION = "A text-based bootmanager allowing a Zaurus to boot from SD or CF. \
Tested machines: Collie"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Matthias 'CoreDump' Hentges  <oe@hentges.net>"
LICENSE = "GPL"
 
PV = "0.0.1+cvs-${CVSDATE}"
PR = "r2"


SRC_URI = "cvs://anonymous@hentges.net/hentgescvs;module=hentgescvs/hentges-utils/files;method=pserver \
	   file://altboot.cfg"
S = "${WORKDIR}/files"
 
do_install() {
	install -d ${D}/sbin
	install -d ${D}/etc/altboot-menu
	install -d ${D}/usr/share/doc/altboot
	
	install -m 0644 ${WORKDIR}/altboot.cfg ${D}/etc
	install -m 0644 docs/altboot/*.txt ${D}/usr/share/doc/altboot
	install -m 0755 init.altboot ${D}/sbin	
	install -m 0755 altboot-menu/*-* ${D}/etc/altboot-menu
}		



pkg_postinst() {
	update-alternatives --install /sbin/init init /sbin/init.altboot 55
}

pkg_postrm() {
	update-alternatives --remove init /sbin/init.altboot
}
