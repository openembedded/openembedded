SECTION = "base"
LICENSE= "GPL"
PV = "0.0+cvs${SRCDATE}"
DESCRIPTION = "Command line tool for iPaq backlight control"

SRC_URI = "${HANDHELDS_CVS};module=apps/h3600_test \
           file://nokernelheader.patch;patch=1;pnum=0 \
	   file://zaurus-hinge.bl-on \
	   file://zaurus-hinge.bl-off"


S = "${WORKDIR}/h3600_test"
PR = "r1"

inherit pkgconfig

FILES_${PN} = "${bindir}"

do_configure (){
}

do_compile (){
	oe_runmake bl CC="${CROSS_DIR}/bin/${TARGET_SYS}-gcc -I{STAGING_INCDIR} -L${STAGING_LIBDIR}" AS=${CROSS_DIR}/bin/${TARGET_SYS}-as LD=${CROSS_DIR}/bin/${TARGET_SYS}-ld
}

do_install () {
        install -d ${D}${bindir}
        install -d ${D}/etc/apm/resume.d
	install -d ${D}/etc/zaurusd/hinge-close.d
	install -d ${D}/etc/zaurusd/hinge-portrait.d
	install -d ${D}/etc/zaurusd/hinge-landscape.d

        install -m 4755 ${S}/bl ${D}${bindir}/bl

	install -m 0755 "${WORKDIR}/zaurus-hinge.bl-on" "${D}/etc/apm/resume.d/00-backlight-on"
	install -m 0755 "${WORKDIR}/zaurus-hinge.bl-on" "${D}/etc/zaurusd/hinge-landscape.d/00-backlight-on"
	install -m 0755 "${WORKDIR}/zaurus-hinge.bl-on" "${D}/etc/zaurusd/hinge-portrait.d/00-backlight-on"
	install -m 0755 "${WORKDIR}/zaurus-hinge.bl-off" "${D}/etc/zaurusd/hinge-close.d/00-backlight-off"

}
