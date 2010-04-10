SECTION = "devel"
require binutils_${PV}.bb
inherit canadian-sdk

DEPENDS="\
	virtual/${HOST_PREFIX}binutils \
	virtual/${HOST_PREFIX}gcc \
	flex-native bison-native \
"

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

SRC_URI[md5sum] = "d5bce238060d631be60a3f1f1009a7ba"
SRC_URI[sha256sum] = "6fe3c4b2d45a50582f832bc77deb4e3da74a15ea8e09dbb214b9c44e7c3378fc"
