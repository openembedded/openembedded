DEPENDS = "ti-libd2cmap ti-tilermemmgr ti-syslink"

LICENSE = "TI"

inherit autotools lib_package

PV = "1.0.0"
PR = "r2"
PR_append = "+gitr${SRCREV}"

SRCREV = "6c36c6503a9befff35cbe36e67b61515f963a008"
SRC_URI = "git://github.com/robclark/libdce.git;protocol=git"

S = "${WORKDIR}/git"

do_install_append() {
	install -d ${D}${base_libdir}/firmware/omap4
	install -m 0644 firmware/* ${D}${base_libdir}/firmware/omap4/
}

FILES_${PN} += "${base_libdir}/firmware/"
