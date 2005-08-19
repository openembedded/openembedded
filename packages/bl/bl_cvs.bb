SECTION = "base"
LICENSE= "GPL"
PV = "0.0cvs${CVSDATE}"
DESCRIPTION = "Command line tool for iPaq backlight control"
MAINTAINER = "Florian Boor <florian@kernelconcets.de>"

SRC_URI = "cvs://anoncvs:anoncvs@cvs.handhelds.org/cvs;module=apps/h3600_test \
           file://nokernelheader.patch;patch=1;pnum=0"

S = "${WORKDIR}/h3600_test"
PR = "r0"

inherit pkgconfig

FILES_${PN} = "${bindir}"

do_configure (){
}

do_compile (){
	oe_runmake bl CC="${CROSS_DIR}/bin/${TARGET_SYS}-gcc -I{STAGING_INCDIR} -L${STAGING_LIBDIR}" AS=${CROSS_DIR}/bin/${TARGET_SYS}-as LD=${CROSS_DIR}/bin/${TARGET_SYS}-ld
}

do_install () {
        install -d ${D}${bindir}
        install -m 4755 ${S}/bl ${D}${bindir}/bl
}
