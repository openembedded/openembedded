
BINLOCATION = "${S}/gfx_rel_es3.x"

ES2LOCATION = "${S}/gfx_rel_es2.x"
ES3LOCATION = "${S}/gfx_rel_es3.x"
ES5LOCATION = "${S}/gfx_rel_es5.x"


require libgles-omap3.inc

# download required binary distribution from:
# http://software-dl.ti.com/dsps/forms/export.html?prod_no=/OMAP35x_Graphics_SDK_setuplinux_3_01_00_06.bin

SGXPV = "3_01_00_06"
IMGPV = "1.4.14.2616"
BINFILE := "OMAP35x_Graphics_SDK_setuplinux_${SGXPV}.bin"






