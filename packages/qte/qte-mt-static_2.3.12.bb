require qte-common_${PV}.inc
PR = "r0"

EXTRA_OECONF += "-thread -static"
export SYSCONF_CXXFLAGS = "${CXXFLAGS} -pipe -DQWS -fexceptions -frtti -DNO_DEBUG ${EXTRA_DEFINES} -DUSE_BIDI"
#export SYSCONF_CXXFLAGS = "${CXXFLAGS} -pipe -DQWS -fexceptions -frtti -fvisibility=hidden -DGCC_SUPPORTS_VISIBILITY -DNO_DEBUG ${EXTRA_DEFINES} -DUSE_BIDI"

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
