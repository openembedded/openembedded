SRC_URI = "ftp://ftp.gnu.org/gnu/aspell/aspell-${PV}.tar.gz"
DESCRIPTION = "GNU Aspell spell-checker"
SECTION = "console/utils"
LICENSE="LGPL"

PACKAGES += "libaspell libpspell libpspell-dev aspell-utils"

FILES_${PN}-dbg += "${libdir}/aspell-0.60/.debu*"
FILES_libaspell = "${libdir}/libaspell.so.* ${libdir}/aspell*"
FILES_aspell-utils = "${bindir}/word-list-compress ${bindir}/aspell-import ${bindir}/run-with-aspell ${bindir}/pre*"
FILES_${PN} = "${bindir}/aspell"
FILES_libpspell = "${libdir}/libpspell.so.*"
FILES_libpspell-dev = "${libdir}/libpspell* ${bindir}/pspell-config ${includedir}/pspell"

inherit autotools

do_stage() {
	autotools_stage_all
}

SRC_URI[md5sum] = "17fd8acac6293336bcef44391b71e337"
SRC_URI[sha256sum] = "ee9e81d2e3e66b01ad91da736e48568ed8acd6dfb6b664d904066ecc5ea4e84b"
