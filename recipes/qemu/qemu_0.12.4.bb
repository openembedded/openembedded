LICENSE = "GPL"
DEPENDS = "zlib"

PR = "r0"

SRC_URI = "\
    http://download.savannah.gnu.org/releases/qemu/qemu-${PV}.tar.gz;name=qemu-${PV} \
    file://02_kfreebsd.patch;patch=1 \
    file://03_support_pselect_in_linux_user_arm.patch;patch=1 \
    file://05_bochs_vbe.diff;patch=1 \
    file://06_sh4.diff;patch=1 \
    file://leftover.patch;patch=1 \
    file://3f26c1227e3b08010f2a65379cecf4cb4b5933fa.patch;patch=1 \
    file://c5883be23519921254c6940873ee8db04979c20a.patch;patch=1 \
    file://91-oh-sdl-cursor.patch;patch=1 \
    file://fix_baum_c_compilation.patch;patch=1 \
    file://fix_fortify_source_compilation.patch;patch=1 \
    file://fallback.to.safe.mmap_min_addr.patch;patch=1 \
    "

SRC_URI[qemu-0.12.4.md5sum] = "93e6b134dff89b2799f57b7d9e0e0fc5"
SRC_URI[qemu-0.12.4.sha256sum] = "1a29a5b5151162d1de035c4926d1a1dbffee4a145ef61ee865d6b82aaea0602e"

BBCLASSEXTEND="native"

S = "${WORKDIR}/qemu-${PV}"

EXTRA_OECONF += " --disable-curl --disable-sdl --disable-strip \
                "

inherit autotools

do_configure_prepend_virtclass-native() {
	export QEMU_CFLAGS="-I${STAGING_INCDIR_NATIVE} ${QEMU_CFLAGS}"
}

do_configure() {
	${S}/configure --prefix=${prefix} ${EXTRA_OECONF}
}
