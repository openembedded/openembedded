SECTION = "devel"
require binutils_${PV}.bb
inherit canadian-sdk

DEPENDS = "flex-native bison-native"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/binutils-${PV}"
# On MinGW hosts we want to prepend a drive letter, in ${SDK_REALPATH_MINGW}
# to the sysroot path.
SYSROOT = "${@['${SDK_REALPATH}/${TARGET_SYS}', '${SDK_REALPATH_MINGW}${SDK_REALPATH}/${TARGET_SYS}'][bb.data.getVar('SDK_OS', d, 1) in ['mingw32', 'mingw64']]}"
EXTRA_OECONF = "--with-sysroot=${SYSROOT} \
		--program-prefix=${TARGET_PREFIX}"
PR = "r4"

FILES_${PN}-dbg += "${prefix}/${TARGET_SYS}/bin/.debug"

do_install () {
        autotools_do_install

        # Install the libiberty header
        install -d ${D}${includedir}
        install -m 644 ${S}/include/ansidecl.h ${D}${includedir}
        install -m 644 ${S}/include/libiberty.h ${D}${includedir}
}
