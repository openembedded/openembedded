SECTION = "base"
LICENSE= "GPL"
PV = "0.0cvs${SRCDATE}"
DESCRIPTION = "Command line tool for iPaq LED control"

SRC_URI = "${HANDHELDS_CVS};module=apps/h3600_test \
           file://nokernelheader.patch;patch=1;pnum=0"
inherit module-base

S = "${WORKDIR}/h3600_test"
PR = "r0"

inherit pkgconfig

FILES_${PN} = "${bindir}"

do_configure (){
}

do_compile (){
	oe_runmake led CC="${CROSS_DIR}/bin/${TARGET_SYS}-gcc -I${STAGING_INCDIR} -I${STAGING_KERNEL_DIR}/include  -L${STAGING_LIBDIR}" AS=${CROSS_DIR}/bin/${TARGET_SYS}-as LD=${CROSS_DIR}/bin/${TARGET_SYS}-ld
}

do_install () {
        install -d ${D}${bindir}
        install -m 4755 ${S}/led ${D}${bindir}/led
}
