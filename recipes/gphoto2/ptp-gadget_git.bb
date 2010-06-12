DESCRIPTION = "This is a device-side implementation of the PTP (Picture Transfer Protocol)"
LICENSE = "GPLv3"

DEPENDS = "virtual/kernel"
RDEPENDS_${PN} = "imagemagick"

PV = "1.1"
PR = "r2"
PR_append = "+gitr${SRCREV}"

SRCREV = "ef7ef29b5cdcf8630c901362a66905b956242e0d"
SRC_URI = "git://git.denx.de/ptp-gadget.git;protocol=git \
           file://0001-Fix-musb_hdrc-EP_STATUS_NAME.patch"

S = "${WORKDIR}/git"

do_compile () {
	export CPPFLAGS="${CPPFLAGS} ${CFLAGS}"
	sed -i -e 's:pthread:pthread ${LDFLAGS}:' Makefile
	oe_runmake KERNEL_SRC=${STAGING_KERNEL_DIR} CROSS_COMPILE=${TARGET_PREFIX}
}

do_install () {
	sed -i -e s:local/::g Makefile
	# "/usr/bin" is hardcoded in the makefile
	install -d ${D}/usr/bin
	oe_runmake install DESTDIR="${D}"
}

#Need specific kernel headers
PACKAGE_ARCH = "${MACHINE_ARCH}"
