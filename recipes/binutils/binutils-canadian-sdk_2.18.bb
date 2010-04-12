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

do_stage() {
	:
}

do_install () {
        autotools_do_install

        # Install the libiberty header
        install -d ${D}${includedir}
        install -m 644 ${S}/include/ansidecl.h ${D}${includedir}
        install -m 644 ${S}/include/libiberty.h ${D}${includedir}
}

SRC_URI[md5sum] = "9d22ee4dafa3a194457caf4706f9cf01"
SRC_URI[sha256sum] = "487a33a452f0edcf1f8bb8fc23dff5c7a82edec3f3f8b65632b6c945e961ee9b"
