DESCRIPTION = "Command line tool for GPE backlight control"
MAINTAINER = "Simon Pickering <S.G.Pickering@bath.ac.uk>"
SECTION = "base"
LICENSE = "GPL"
DEPENDS = "glib-2.0"

SRC_URI = "http://people.bath.ac.uk/enpsgp/Zaurus/bl/${PN}-${PV}.tar.gz \
	   file://zaurus-hinge.bl-on \
	   file://zaurus-hinge.bl-off"

inherit pkgconfig

FILES_${PN} = "${bindir} /etc"

do_configure (){
}

do_compile (){
	oe_runmake bl CC="${CROSS_DIR}/bin/${TARGET_SYS}-gcc -I{STAGING_INCDIR} -L${STAGING_LIBDIR} -lglib-2.0" AS=${CROSS_DIR}/bin/${TARGET_SYS}-as LD=${CROSS_DIR}/bin/${TARGET_SYS}-ld
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
	
	

