SRC_URI = "${SOURCEFORGE_MIRROR}/atmelwlandriver/atmelwlandriver-${PV}.tar.bz2 \
	file://dotconfig \
	file://pcmf502rd.conf \
	file://makefile.patch;patch=1 \
	file://add-compaq-usb-ids.patch;patch=1 \
	file://power-on-and-leds.patch;patch=1 \
	file://fix-kernel-version-test-for-hh.patch;patch=1"
S = "${WORKDIR}/atmelwlandriver"
LICENSE = "GPL"
PR = "r2"

inherit module
SECTION = "base"

PACKAGES = "atmelwlandriver-pcmcia atmelwlandriver-usb"

FILES_atmelwlandriver-pcmcia = "${base_libdir}/modules/${KERNEL_VERSION}/drivers/net/wireless/atmel/pcmf502rd.o ${sysconfdir}/pcmcia/pcmf502rd.conf"
FILES_atmelwlandriver-usb = "${base_libdir}/modules/${KERNEL_VERSION}/drivers/net/wireless/atmel/usbvnetr.o"

do_configure() {
	install ${WORKDIR}/dotconfig .config
}

CFLAGS_pcmcia = "-DLINUX_OS -D__KERNEL__ -DMODULE -I${S}/src/includes -I${S}/src/includes/pcmcia -I${STAGING_KERNEL_DIR}/include"
CFLAGS_usb = "-DLINUX_OS -D__KERNEL__ -DMODULE -I${S}/src/includes -I${S}/src/includes/usb -I${STAGING_KERNEL_DIR}/include"

do_compile() {
	export INC="${S}/src/includes"
	export OBJDIR="${D}${base_libdir}/modules/${KERNEL_VERSION}/drivers/net/wireless/atmel/"
	export KERNEL_PATH="${STAGING_KERNEL_DIR}"
	export KERNEL_SRC="${STAGING_KERNEL_DIR}"
	export CC="${KERNEL_CC}" 
	export CCC="${KERNEL_CC}" 
	export LD="${KERNEL_LD}"
	export KERNEL_VERSION="${KERNEL_VERSION}"
	export TOPDIR="${S}"
	unset CFLAGS CCFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	install -d ${OBJDIR}
	oe_runmake -C src/Pcmcia_Pci final CFLAGS:='${CFLAGS_pcmcia} -DATMEL_WLAN -DRFMD -DINT_ROAM -DREV_D' MODULE:='pcmf502rd' LIB:=-REVD-
	oe_runmake -C src/usb final CFLAGS:='${CFLAGS_usb} -DATMEL_WLAN -DRFMD' MODULE:='usbvnetr'
}

do_install() {
	install -d ${D}${sysconfdir}/pcmcia
	install -m 0644 ${WORKDIR}/pcmf502rd.conf ${D}${sysconfdir}/pcmcia/

	# remove any maps that were installed
	rm -f ${D}${base_libdir}/modules/${KERNEL_VERSION}/drivers/net/wireless/atmel/*.map
}
