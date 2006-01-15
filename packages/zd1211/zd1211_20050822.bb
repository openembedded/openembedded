DESCRIPTION = "Driver for zd1211 family of wireless USB Dongles"
PRIORITY = "optional"
SECTION = "kernel/modules"
MAINTAINER = "dyoung <dyoung8888@yahoo.com>"
LICENSE = "GPL"
PR = "r5"
RDEPENDS = "wireless-tools"

SRC_URI = "http://download.sourceforge.net/zd1211/sf_zd1211_${PV}_src.tar.gz \
	file://makefile.patch;patch=1 \
	file://iwconfig-rate.patch;patch=1 \
	file://access_ok.patch;patch=1 \
	file://urb-async.patch;patch=1" 

S = "${WORKDIR}/zd1211"

inherit module

#do_compile_prepend() {
#	cp -f ${WORKDIR}/Makefile ${S}/
#}

do_compile () {
        unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS CC LD CPP
        oe_runmake 'KSRC=${STAGING_KERNEL_DIR}' \
        	   'KDIR=${STAGING_KERNEL_DIR}' \
		   'KERNRELEASE=${KERNEL_VERSION}' \
                   'CC="${KERNEL_CC}"' \
                   'LD="${KERNEL_LD}"' 
}

do_install() {   
        install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net
        install -m 0644 ${S}/src/modules-${KERNEL_VERSION}/*${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net
}

