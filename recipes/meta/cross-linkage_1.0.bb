DESCRIPTION = "cross-linkage sets up symlinks between cross and staging so the compiler can find things"
SECTION = "devel"
PACKAGES = ""

INHIBIT_DEFAULT_DEPS = "1"
EXCLUDE_FROM_WORLD = "1"
PR = "r0"

SRC_URI = ""

do_configure() {
	:
}

do_compile () {
	:
}

do_install() {
	:
}

do_stage () {
	install -d ${STAGING_DIR_NATIVE}${prefix_native}/${TARGET_SYS}/
	if [ -e ${STAGING_DIR_NATIVE}${prefix_native}/${TARGET_SYS}/include ]; then
		cp -pPRr ${STAGING_DIR_NATIVE}${prefix_native}/${TARGET_SYS}/include/* ${STAGING_INCDIR}
		mv ${STAGING_DIR_NATIVE}${prefix_native}/${TARGET_SYS}/include/ ${STAGING_DIR_NATIVE}${prefix_native}/${TARGET_SYS}/include-oldbackup
	fi
	ln -s  ${STAGING_INCDIR}/ ${STAGING_DIR_NATIVE}${prefix_native}/${TARGET_SYS}/include
	if [ -e ${STAGING_DIR_NATIVE}${prefix_native}/${TARGET_SYS}/lib ]; then
		cp -pPRr ${STAGING_DIR_NATIVE}${prefix_native}/${TARGET_SYS}/lib/* ${STAGING_LIBDIR}
		mv ${STAGING_DIR_NATIVE}${prefix_native}/${TARGET_SYS}/lib/ ${STAGING_DIR_NATIVE}${prefix_native}/${TARGET_SYS}/lib-oldbackup
	fi
	ln -s  ${STAGING_LIBDIR} ${STAGING_DIR_NATIVE}${prefix_native}/${TARGET_SYS}/lib 
}
