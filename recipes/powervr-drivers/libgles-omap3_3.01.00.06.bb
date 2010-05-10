BINLOCATION = "${S}/gfx_rel_es3.x"

ES2LOCATION = "${S}/gfx_rel_es2.x"
ES3LOCATION = "${S}/gfx_rel_es3.x"
ES5LOCATION = "${S}/gfx_rel_es5.x"

require libgles-omap3.inc

# download required binary distribution from:
# http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/gfxsdk/latest/index_FDS.html
# see libgles-omap3.inc for detailed installation instructions

SGXPV = "3_01_00_06"
IMGPV = "1.4.14.2616"
BINFILE := "OMAP35x_Graphics_SDK_setuplinux_${SGXPV}.bin"

SRC_URI[md5sum] = "7aa37ca72f34011d353e72cc67f8aac1"
SRC_URI[sha256sum] = "02276bc728699c36b0d2411c60f23030aa066ca6b8ed5adb7a40204563a227fb"
