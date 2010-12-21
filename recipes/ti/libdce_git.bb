DEPENDS = "ti-libd2cmap ti-tilermemmgr ti-syslink"

LICENSE = "TI"

inherit autotools lib_package

PV = "1.0.0"
PR = "r3"
PR_append = "+gitr${SRCREV}"

SRCREV = "086d0bed544ecb92afde57db32c16b5e97c6f2d2"
SRC_URI = "git://github.com/robclark/libdce.git;protocol=git"

S = "${WORKDIR}/git"

do_install_append() {
	install -d ${D}${base_libdir}/firmware/omap4
	install -m 0644 firmware/* ${D}${base_libdir}/firmware/omap4/
}

FILES_${PN} += "${base_libdir}/firmware/"
