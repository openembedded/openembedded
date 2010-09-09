BINLOCATION = "${S}/gfx_rel_es3.x"

ES2LOCATION = "${S}/gfx_rel_es2.x"
ES3LOCATION = "${S}/gfx_rel_es3.x"
ES5LOCATION = "${S}/gfx_rel_es5.x"

require libgles-omap3.inc

# download required binary distribution from:
# http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/gfxsdk/latest/index_FDS.html
# see libgles-omap3.inc for detailed installation instructions

SGXPV = "3_01_00_07"
IMGPV = "1.4.14.2616"
BINFILE := "OMAP35x_Graphics_SDK_setuplinux_${SGXPV}.bin"

SRC_URI[md5sum] = "b33a82d393ed0a6c26ad0d952542d762"
SRC_URI[sha256sum] = "6f1720c2a8c2ce84b0020e144c2d77b56106a1fff45b44f8fcfd74d0f2559d8e"

