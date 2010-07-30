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
	install -d ${TOOLCHAIN_PATH}/${TARGET_SYS}/
	if [ -e ${TOOLCHAIN_PATH}/${TARGET_SYS}/include ]; then
		cp -pPRr ${TOOLCHAIN_PATH}/${TARGET_SYS}/include/* ${STAGING_INCDIR}
		mv ${TOOLCHAIN_PATH}/${TARGET_SYS}/include/ ${TOOLCHAIN_PATH}/${TARGET_SYS}/include-oldbackup
	fi
	ln -s  ${STAGING_INCDIR}/ ${TOOLCHAIN_PATH}/${TARGET_SYS}/include
	if [ -e ${TOOLCHAIN_PATH}/${TARGET_SYS}/lib ]; then
		cp -pPRr ${TOOLCHAIN_PATH}/${TARGET_SYS}/lib/* ${STAGING_LIBDIR}
		mv ${TOOLCHAIN_PATH}/${TARGET_SYS}/lib/ ${TOOLCHAIN_PATH}/${TARGET_SYS}/lib-oldbackup
	fi
	ln -s  ${STAGING_LIBDIR} ${TOOLCHAIN_PATH}/${TARGET_SYS}/lib 
}
