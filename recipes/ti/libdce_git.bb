DEPENDS = "ti-libd2cmap ti-tiler-memmgr ti-syslink"

LICENSE = "TI"

inherit autotools lib_package

PV = "1.0.0"
PR_append = "+gitr${SRCREV}"

SRCREV = "340931755707a6d5a1af"
SRC_URI = "git://github.com/robclark/libdce.git;protocol=git"

S = "${WORKDIR}/git"

do_install_append() {
	install -d ${D}${base_libdir}/firmware/omap4
	install -m 0644 firmware/* ${D}${base_libdir}/firmware/omap4/
}

FILES_${PN} += "${base_libdir}/firmware/"
