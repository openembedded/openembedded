LICENSE = "GPL"
DEPENDS = "zlib"

PR = "r1"

FILESPATH = "${FILE_DIRNAME}/qemu-${PV}"
FILESDIR = "${WORKDIR}"

SRC_URI = "\
    http://download.savannah.gnu.org/releases/qemu/qemu-${PV}.tar.gz \
    file://06_exit_segfault.patch;patch=1;pnum=0 \
    file://11_signal_sigaction.patch;patch=1;pnum=0 \
    file://22_net_tuntap_stall.patch;patch=1 \
    file://31_syscalls.patch;patch=1;pnum=0 \
    file://32_syscall_sysctl.patch;patch=1;pnum=0 \
    file://52_ne2000_return.patch;patch=1 \
    file://61_safe_64bit_int.patch;patch=1;pnum=0 \
    file://63_sparc_build.patch;patch=1;pnum=0 \
    file://64_ppc_asm_constraints.patch;patch=1 \
    file://66_tls_ld.patch;patch=1;pnum=0 \
    file://91-oh-sdl-cursor.patch;patch=1;pnum=0 \
    file://fix_segfault.patch;patch=1 \
    file://no-strip.patch;patch=1 \
    file://fix_baum_c_compilation.patch;patch=1 \
    file://fix_fortify_source_compilation.patch;patch=1 \
    "

S = "${WORKDIR}/qemu-${PV}"

EXTRA_OECONF += "--disable-gfx-check"

inherit autotools

do_configure() {
	${S}/configure --prefix=${prefix} ${EXTRA_OECONF}
}
