DESCRIPTION = "mISDN kernel packages"
PRIORITY = "optional"
SECTION = "kernel/modules"
LICENSE = "GPL"
PR = "r0"

DEFAULT_PREFERENCE = "-1"

# hfcs_usb_endianchecks.diff does not apply cleanly anymore (cf. bug 240)
# without it the package at least compiles.  no guarantees about functionality.
SRC_URI = "cvs://anonymous:readonly@cvs.isdn4linux.de/i4ldev;module=mISDN;method=pserver \
#	   file://hfcs_usb_endianchecks.diff;patch=1 \
	   file://Makefile"

S = "${WORKDIR}/mISDN/"

inherit module

do_compile_prepend() {
	cp -f ${WORKDIR}/Makefile ${S}/
	cp ${S}/drivers/isdn/hardware/mISDN/Makefile.v2.6 ${S}/drivers/isdn/hardware/mISDN/Makefile
}

do_compile () {
        unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
        oe_runmake 'KDIR=${STAGING_KERNEL_DIR}' \
		   'CC=${KERNEL_CC}' \
                   'LD=${KERNEL_LD}' 
}

do_install() {   
        install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/isdn/hardware/mISDN/
        install -m 0644 ${S}/drivers/isdn/hardware/mISDN/*${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/isdn/hardware/mISDN
}

