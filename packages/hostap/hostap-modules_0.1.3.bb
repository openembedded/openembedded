DESCRIPTION = "A driver for wireless LAN cards based on Intersil's Prism2/2.5/3 chipset"
SECTION = "kernel/modules"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
PR = "r3"

SRC_URI = "http://hostap.epitest.fi/releases/hostap-driver-${PV}.tar.gz \
           file://hostap_cs.conf"
S = "${WORKDIR}/hostap-driver-${PV}"

inherit module

MAKE_TARGETS = "hostap pccard"

do_install() {
	install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/net \
		   ${D}${base_libdir}/modules/${KERNEL_VERSION}/pcmcia \
        	   ${D}${sysconfdir}/pcmcia
	install -m 0755 driver/modules/hostap_crypt_wep${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/net/
	install -m 0755 driver/modules/hostap${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/net/
	install -m 0755 driver/modules/hostap_cs${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/pcmcia/
        install -m 0644 driver/etc/hostap_cs.conf ${D}${sysconfdir}/pcmcia/hostap_cs.conf                
        cat ${WORKDIR}/hostap_cs.conf >>${D}${sysconfdir}/pcmcia/hostap_cs.conf

}
