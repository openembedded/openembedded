require qte-common_${PV}.inc
PR = "r2"

EXTRA_OECONF += "-static"

do_stage() {
	rm -rf ${STAGING_DIR}/${HOST_SYS}/qt2
	install -d ${STAGING_DIR}/${HOST_SYS}/qt2/lib
	oe_libinstall -a -C lib libqte-mt ${STAGING_DIR}/${HOST_SYS}/qt2/lib
	rm -f include/qxt.h
	install -d ${STAGING_DIR}/${HOST_SYS}/qt2/include
	cp -pfLR include/* ${STAGING_DIR}/${HOST_SYS}/qt2/include
	cp -pPR lib/fonts ${STAGING_DIR}/${HOST_SYS}/qt2/lib/
}

do_install() {
	:
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
FILES_${PN} = "${palmqtdir}"
