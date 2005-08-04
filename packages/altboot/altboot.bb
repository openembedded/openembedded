DESCRIPTION = "A text-based bootmanager allowing a Zaurus to boot from SD or CF. \
Tested machines: Collie, Poodle, Akita, Spitz"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Matthias 'CoreDump' Hentges  <oe@hentges.net>"
LICENSE = "GPL"
 

PV = "0.0.1+cvs-${CVSDATE}"
PR = "r3"


SRC_URI = "file://altboot-menu \
	   file://altboot.rc \
	   file://altboot.func \	 
	   file://init.altboot \
	   file://altboot.cfg"

# S = "${WORKDIR}/files"
 
do_install() {
	install -d ${D}/sbin
	install -d ${D}/etc/altboot-menu
	install -d ${D}/etc/altboot-menu/Advanced
	install -d ${D}/etc/altboot.rc
	install -d ${D}/usr/share/doc/altboot
	
	install -m 0644 ${WORKDIR}/altboot.cfg ${D}/etc
	install -m 0644 ${WORKDIR}/altboot.func ${D}/etc
#	install -m 0644 ${WORKDIR}/docs/altboot/*.txt ${D}/usr/share/doc/altboot
	install -m 0755 ${WORKDIR}/init.altboot ${D}/sbin	
	install -m 0755 ${WORKDIR}/altboot-menu/*-* ${D}/etc/altboot-menu
	install -m 0755 ${WORKDIR}/altboot-menu/Advanced/*-* ${D}/etc/altboot-menu/Advanced
}		



pkg_postinst() {
	update-alternatives --install /sbin/init init /sbin/init.altboot 55
}

pkg_postinst_spitz() {
	
	# Note: Spitz support is a royal pain in the ass.
	#       Since Spitz pivot_roots by default, there is no real way
	#	a user can install an altboot.ipk into the flash FS.
	#	So we need to do that manually (*SIGH*)
	
	# /l/m only exists on the HDD on spitz
	if test -d /lib/modules
	then
		# FIXME: Do be written
		a=a # do nothing
	fi					
}

pkg_postrm() {
	update-alternatives --remove init /sbin/init.altboot
}

pkg_postrm_spitz() {
	# FIXME: To be written
	a=a # do nothing
}
