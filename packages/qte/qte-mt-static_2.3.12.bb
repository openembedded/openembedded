require qte-common_${PV}.inc
PR = "r4"

DEFAULT_PREFERENCE = "-1"

EXTRA_OECONF += "-static -thread"

do_stage() {
	rm -rf ${STAGING_DIR_HOST}/qt2
	install -d ${STAGING_DIR_HOST}/qt2/lib
	oe_libinstall -a -C lib libqte-mt ${STAGING_DIR_HOST}/qt2/lib
	rm -f include/qxt.h
	install -d ${STAGING_DIR_HOST}/qt2/include
	cp -pfLR include/* ${STAGING_DIR_HOST}/qt2/include
	cp -pPR lib/fonts ${STAGING_DIR_HOST}/qt2/lib/
	install -m 0644 src/kernel/qsnoopdata_qws_p.h ${STAGING_DIR_HOST}/qt2/include/
}

do_install() {
	:
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
FILES_${PN} = "${palmqtdir}"
