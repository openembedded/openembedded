DESCRIPTION = "Tools for the Linux Standard Wireless Extension Subsystem"
HOMEPAGE = "http://www.hpl.hp.com/personal/Jean_Tourrilhes/Linux/Tools.html"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI = "file://man.patch;patch=1 \
	   file://wireless-tools.if-pre-up"

CFLAGS =+ "-I${S}"
EXTRA_OEMAKE = "-e 'BUILD_SHARED=y' \
		'INSTALL_DIR=${D}${base_sbindir}' \
		'INSTALL_LIB=${D}${libdir}' \
		'INSTALL_INC=${D}${includedir}' \
		'INSTALL_MAN=${D}${mandir}'"

do_compile() {
	oe_runmake all libiw.a
}

do_stage() {
	install -m 0644 wireless.h ${STAGING_INCDIR}/
	install -m 0644 iwlib.h ${STAGING_INCDIR}/
	oe_libinstall -a -so libiw ${STAGING_LIBDIR}/
}

PACKAGES += "libiw libiw-dev libiw-doc libiw-dbg ifrename ifrename-dbg ifrename-doc"
FILES_libiw += "${libdir}/*.so.*"
FILES_libiw-dbg += "${libdir}/.debug/*.so.*"
FILES_libiw-dev += "${libdir}/*.a ${libdir}/*.so ${includedir}"
FILES_libiw-doc += "${mandir}/man7"
FILES_ifrename += "${sbindir}/ifrename"
FILES_ifrename-dbg += "${sbindir}/.debug/ifrename"
FILES_ifrename-doc += "${mandir}/man8/ifrename.8 ${mandir}/man5/iftab.5"
FILES_${PN} += "${bindir} ${sbindir}/iw* ${base_sbindir} ${base_bindir} ${sysconfdir}/network"
FILES_${PN}-doc += "${mandir}/man8"
