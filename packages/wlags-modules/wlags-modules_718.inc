DESCRIPTION = "A driver from Agera (a card manufacturer) for wireless LAN cards based on Hermes cards."
HOMEPAGE = "http://www.agere.com/mobility/wireless_lan_drivers.html"
SECTION = "kernel/modules"
PRIORITY = "optional"
MAINTAINER = "Holger Schurig"
DEPENDS = "virtual/kernel"
LICENSE = "BSD"
PR = "r1"

TARFILE = "wl_lkm_${PV}_release.tar.gz"


#
# The original wlags tar file is a bit messy:
# * it doesn't contain it's own subdirectory
# * the files are formatted for Windows/DOS (with CR/LF)
# * they assume that the pcmcia-cs source code is there
# * they don't use the kernel makefile approach
#
# Because of this, I create the IPK in a little unusual way:
# * I "flatten" the structure to be able to use the kernel makefile concept
# * the patches I have are for the flattened structure
# * then I do the usual compile/install/package dance
#

SRC_URI = "http://www.agere.com/mobility/docs/${TARFILE} \
	file://Makefile \
	file://includes.patch \
	file://kernel-pcmcia.patch \
	file://bugs.patch \
	file://fixes.patch \
	file://wlags_h${COMPILE_HERMES}.conf"
S = "${WORKDIR}/${PN}"

do_configure() {
	cp ../{hcf,firmware,include/hcf,include/wireless}/*.h .
	cp ../{hcf,firmware,wireless}/*.c .
	cp ../etc/wlags49.conf .
	perl -pi -e 'r:\r::g' *.h *.c

	patch -p1 <${WORKDIR}/includes.patch
	patch -p1 <${WORKDIR}/kernel-pcmcia.patch
	patch -p1 <${WORKDIR}/bugs.patch
	patch -p1 <${WORKDIR}/fixes.patch
	cp ${WORKDIR}/Makefile .
}


do_compile() {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	make -C ${STAGING_KERNEL_DIR} \
		modules \
		SUBDIRS="${S}" \
		CC="${KERNEL_CC}" LD="${KERNEL_LD}" \
		COMPILE_HERMES=${COMPILE_HERMES}
}


do_install() {
        install -d ${D}${sysconfdir}/pcmcia
        install -m 0644 ${WORKDIR}/wlags_h${COMPILE_HERMES}.conf ${D}${sysconfdir}/pcmcia/

        install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/net/wireless
	ls
        install -m 0644 wlags49_h${COMPILE_HERMES}_cs${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/net/wireless
}

FILES = "/lib/modules/${KERNEL_VERSION}/net/wireless/*${KERNEL_OBJECT_SUFFIX} /${sysconfdir}"        
