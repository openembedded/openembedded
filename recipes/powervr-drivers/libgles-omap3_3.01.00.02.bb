BINLOCATION = "${S}/gfx_rel_es3.x"

DEFAULT_PREFERENCE = "2"

require libgles-omap3.inc

# download required binary distribution from:
# http://software-dl.ti.com/dsps/forms/export.html?prod_no=/OMAP35x_Graphics_SDK_setuplinux_3_01_00_02.bin

SGXPV = "3_01_00_02"
IMGPV = "1.4.14.2514"
BINFILE := "OMAP35x_Graphics_SDK_setuplinux_${SGXPV}.bin"

# The ES2.x and ES3.x CPUs have different SGX hardware, so we need to install 2 sets of userspace
do_install_append() {
	install -d ${D}${libdir}/ES3.0
	install -d ${D}${libdir}/ES2.0
	install -d ${D}${bindir}/ES3.0
	install -d ${D}${bindir}/ES2.0

	cp ${S}/gfx_rel_es2.x/lib* ${D}${libdir}/ES2.0/
	cp ${S}/gfx_rel_es2.x//p[dv]* ${D}${bindir}/ES2.0/

	cp ${D}${libdir}/lib*${IMGPV} ${D}${libdir}/ES3.0/
	cp ${D}${bindir}/p[dv]* ${D}${bindir}/ES3.0
}

# Quality control is really poor on these SDKs, so hack around the latest madness:
FILES_${PN} += "${libdir}/*.so "
FILES_${PN}-dev = "${includedir}"

