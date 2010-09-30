BINLOCATION = "${S}/gfx_rel_es3.x"

ES2LOCATION = "${S}/gfx_rel_es2.x"
ES3LOCATION = "${S}/gfx_rel_es3.x"
ES5LOCATION = "${S}/gfx_rel_es5.x"

require libgles-omap3.inc

# download required binary distribution from:
# http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/gfxsdk/latest/index_FDS.html
# see libgles-omap3.inc for detailed installation instructions

SGXPV = "4_00_00_01"
IMGPV = "1.4.14.2616"
BINFILE := "Graphics_SDK_setuplinux_${SGXPV}.bin"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/gfxsdk/${SGXPV}/exports/Graphics_SDK_setuplinux_${SGXPV}.bin \
                   file://cputype \
                   file://rc.pvr \
                   file://sample.desktop \
                   file://99-bufferclass.rules  \
"

SRC_URI[md5sum] = "a027002dcd7164df467b1a315788d5fd"
SRC_URI[sha256sum] = "62383d15e33adf9349afba063b0f2405a15aa6c4b0b5579b0abdf81db7580df7"

S = "${WORKDIR}/Graphics_SDK_${SGXPV}"

