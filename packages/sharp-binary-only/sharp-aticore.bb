DESCRIPTION = "Driver for the Ati W100 found on the Sharp Zaurus C[87]x0"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"
PR = "r0"

SRC_URI = "http://www.mithis.com/zaurus/AtiCore.${TARGET_FPU}.tar.bz2"
S = "${WORKDIR}/AtiCore"

FILES_${PN}="${libdir}/*.so* ${bindir}/*"
	  
# And include it in the dev package
FILES_${PN}-dev += " ${includedir}"

do_make() {
	make
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 testcore ${D}${bindir}/testcore
	install -m 0755 atitest ${D}${bindir}/atitest
	
	install -d ${D}${libdir}
	install -m 0755 libaticore.so ${D}${libdir}/libaticore.so
	
	install -d ${D}${includedir}
	install -m 0644 aticore.h ${D}${includedir}/aticore.h

	cd ${D}${libdir}/
	ln -s libaticore.so libaticore.so.1
	ln -s libaticore.so libaticore.so.1.0
}

do_stage() {
	install -m 0644 aticore.h ${STAGING_INCDIR}
	oe_libinstall -so libaticore ${STAGING_LIBDIR}
}	

