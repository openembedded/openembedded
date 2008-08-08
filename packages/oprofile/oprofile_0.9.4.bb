SECTION = "devel"
DESCRIPTION = "OProfile is a system-wide profiler for Linux systems, capable \
of profiling all running code at low overhead."
LICENSE = "GPL"
DEPENDS = "popt binutils"
RDEPENDS = "binutils-symlinks"
RRECOMMENDS = "kernel-vmlinux"
PR = "r0"

SRC_URI = "\
	${SOURCEFORGE_MIRROR}/oprofile/oprofile-${PV}.tar.gz \
	file://opjitconv-execvp-fix.diff;patch=1 \
	file://0.9.4-armv7a.diff;patch=1 \
	file://acinclude.m4 \
	"

inherit autotools

EXTRA_OECONF = " \
	--with-kernel-support \
	--without-x \
	"

do_configure () {
	cp ${WORKDIR}/acinclude.m4 ${S}/
	autotools_do_configure
}

do_stage () {
	# As of 0.9.4 there is a libopagent library to compile and link against.
	autotools_stage_all
}

PACKAGES = "${PN}-dev ${PN}-doc ${PN}-dbg ${PN}"

FILES_${PN}-dev += "\
	${libdir}/oprofile/lib*.so \
	${libdir}/oprofile/lib*.a \
	${libdir}/oprofile/lib*.la \
"
