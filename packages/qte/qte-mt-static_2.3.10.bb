require qte-common_${PV}.inc
PR = "r8"

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
}

do_install() {
	:
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
