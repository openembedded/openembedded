LICENSE = "GPL"
DEPENDS = "zlib"

PR = "r2"

SRC_URI = "\
    http://download.savannah.gnu.org/releases/qemu/qemu-${PV}.tar.gz;name=qemu-${PV} \
    file://06_exit_segfault.patch;patch=1;pnum=0 \
    file://11_signal_sigaction.patch;patch=1;pnum=0 \
    file://22_net_tuntap_stall.patch;patch=1 \
    file://31_syscalls.patch;patch=1;pnum=0 \
    file://32_syscall_sysctl.patch;patch=1;pnum=0 \
    file://52_ne2000_return.patch;patch=1 \
    file://63_sparc_build.patch;patch=1;pnum=0 \
    file://64_ppc_asm_constraints.patch;patch=1 \
    file://66_tls_ld.patch;patch=1;pnum=0 \
    file://91-oh-sdl-cursor.patch;patch=1;pnum=0 \
    file://fix_segfault.patch;patch=1 \
    file://fix_baum_c_compilation.patch;patch=1 \
    file://fix_fortify_source_compilation.patch;patch=1 \
    "

SRC_URI[qemu-0.12.3.sha256sum] = "3ce26f8fb0a59418b2064a26bac4b40ea4e493acbc3df7ad5932635477fade4b"
SRC_URI[qemu-0.12.3.md5sum] = "d215e4568650e8019816397174c090e1"

BBCLASSEXTEND="native"

S = "${WORKDIR}/qemu-${PV}"

EXTRA_OECONF += " --disable-curl --disable-sdl --disable-strip"

inherit autotools

do_configure_prepend_virtclass-native() {
	export QEMU_CFLAGS="-I${STAGING_INCDIR_NATIVE} ${QEMU_CFLAGS}"
}

do_configure() {
	${S}/configure --prefix=${prefix} ${EXTRA_OECONF}
}
