SECTION = "base"
require modutils_${PV}.bb
PR = "r9"
inherit cross
S = "${WORKDIR}/modutils-${PV}"
DEPENDS = ""
PACKAGES = ""
PROVIDES += "virtual/${TARGET_PREFIX}depmod virtual/${TARGET_PREFIX}depmod-2.4"
DEFAULT_PREFERENCE = "1"

SRC_URI +=  "file://modutils-cross/module.h.diff;patch=1"

sbindir = "${prefix}/bin"

EXTRA_OECONF_append = " --program-prefix=${TARGET_PREFIX}"

CFLAGS_prepend_mipsel = "-D__MIPSEL__"
CFLAGS_prepend_mipseb = "-D__MIPSEB__"

do_stage () {
        oe_runmake install
        mv ${bindir}/${TARGET_PREFIX}depmod ${bindir}/${TARGET_PREFIX}depmod-2.4
}

do_install () {
        :
}

SRC_URI[md5sum] = "bac989c74ed10f3bf86177fc5b4b89b6"
SRC_URI[sha256sum] = "ab4c9191645f9ffb455ae7c014d8c45339c13a1d0f6914817cfbf30a0bc56bf0"
