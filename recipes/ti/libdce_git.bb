DEPENDS = "ti-libd2cmap ti-tilermemmgr ti-syslink"

LICENSE = "TI"

inherit autotools lib_package

PV = "1.0.0"
PR = "r4"
PR_append = "+gitr${SRCREV}"

SRCREV = "2115a0b6b6fccc27d6ecc274e37e57f2275f99c6"
SRC_URI = "git://github.com/robclark/libdce.git;protocol=git"

S = "${WORKDIR}/git"

do_install_append() {
	install -d ${D}${base_libdir}/firmware/omap4
	install -m 0644 firmware/* ${D}${base_libdir}/firmware/omap4/
}

FILES_${PN} += "${base_libdir}/firmware/"
