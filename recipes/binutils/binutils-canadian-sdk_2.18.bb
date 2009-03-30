SECTION = "devel"
require binutils_${PV}.bb
inherit canadian-sdk

DEPENDS="\
	virtual/${HOST_PREFIX}binutils \
	virtual/${HOST_PREFIX}gcc \
	flex-native bison-native \
"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/binutils-${PV}"
EXTRA_OECONF = "--with-sysroot=${prefix}/${TARGET_SYS} \
		--program-prefix=${TARGET_PREFIX}"
PR = "r3"

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
