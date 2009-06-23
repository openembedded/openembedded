SECTION = "base"
require e2fsprogs.inc
inherit native

PR = "r3"

SRC_URI += "file://no-hardlinks.patch;patch=1 \
	    file://mkinstalldirs.patch;patch=1 \
            file://file-open-mode.patch;patch=1 \
            "

EXTRA_OECONF = ""

PACKAGES = ""
DEPENDS = ""

do_stage () {
        oe_runmake install
        install ${S}/lib/et/compile_et ${STAGING_BINDIR_NATIVE}
}
