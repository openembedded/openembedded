SRC_URI = "http://prdownloads.sourceforge.net/lirc/lirc-${PV}.tar.bz2"
SRC_URI[md5sum] = "fb1dcddbc8ca3d03c7f3a2d40cf28b71"                                                                
SRC_URI[sha256sum] = "e431454f266c4ddc209c3cc84fc506cac6092eb5124b4f3dcc215c8584ea7a39"                             
S = ${WORKDIR}/lirc-${PV}
EXTRA_OECONF = "--with-kerneldir=${STAGING_KERNEL_DIR} ${DRIVER}"

PARALLEL_MAKE = ""

DRIVER ?= "--with-driver=serial --with-driver=mceusb"
# fails to build at the moment, re-enable later
#DRIVER_collie = "--with-driver=sa1100"
DRIVER_h3600 = "--with-driver=sa1100"
DRIVER_simpad = "--with-driver=sa1100"
DRIVER_nslu2 = "--with-driver=nslu2"
