require gcc-cross_${PV}.bb
require gcc-cross-initial.inc

S = "${WORKDIR}/gcc-4.2"

# Hack till we fix *libc properly
do_install_append() {
	install -d ${TOOLCHAIN_PATH}/lib/gcc/${TARGET_SYS}/${BINV}/include/
	ln -sf ${TOOLCHAIN_PATH}/lib/gcc/${TARGET_SYS}/${BINV}/include-fixed/* ${TOOLCHAIN_PATH}/lib/gcc/${TARGET_SYS}/${BINV}/include/
}
