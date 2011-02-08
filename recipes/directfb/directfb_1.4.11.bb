require directfb.inc

RV = "1.4-5"
PR = "${INC_PR}.0"

DEPENDS += "sysfsutils"

SRC_URI = " \
    http://directfb.org/downloads/Core/DirectFB-1.4/DirectFB-${PV}.tar.gz \
    file://fix-pkgconfig-cflags.patch \
    file://mkdfiff.patch \
    file://dont-use-linux-config.patch \
   "

LEAD_SONAME = "libdirectfb-1.4.so.5"

SRC_URI[md5sum] = "94735ccec21120794adcce93a61445d2"
SRC_URI[sha256sum] = "85e27aa6ab9e784689a803961724eb5674cb9f5153770e63f02bf3f75a573a02"

