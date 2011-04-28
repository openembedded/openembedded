#NOTE: This package is currently only supported for the Angstrom
#      distribution.  Other distributions and toolchains may or
#      may not work.

DESCRIPTION = "AM Benchmarks"
HOMEPAGE = "https://gforge.ti.com/gf/project/am_benchmarks/"
LICENSE = "BSD"
SECTION = "system"
PRIORITY = "optional"

SRCREV = "61"
PR = "r2+svnr${SRCPV}"

COMPATIBLE_MACHINE = "(dm365|omapl138|omap3|ti816x|ti814x)"

ARCHITECTURE_dm365 = "arm9"
ARCHITECTURE_omapl138 = "arm9"
ARCHITECTURE_omap3 = "cortex-a8"
ARCHITECTURE_ti816x = "cortex-a8"
ARCHITECTURE_ti814x = "cortex-a8"

INSANE_SKIP_${PN} = "True"

SRC_URI = "svn://gforge.ti.com/svn/am_benchmarks/;module=trunk;proto=https;user=anonymous;pswd=''"

S = "${WORKDIR}/trunk/${ARCHITECTURE}"

do_compile() {
	# don't build debug version
	touch debug
	export CROSS_COMPILE=${TARGET_PREFIX}
	make release
}

do_install() {
	make DESTDIR=${D} install
}
