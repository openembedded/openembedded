LICENSE = "GPL"
DEPENDS = "zlib"

PR = "r1"

SRC_URI = "\
    http://download.savannah.gnu.org/releases/qemu/qemu-${PV}.tar.gz;name=qemu-${PV} \
    file://02_kfreebsd.patch \
    file://03_support_pselect_in_linux_user_arm.patch \
    file://05_bochs_vbe.diff \
    file://06_sh4.diff \
    file://leftover.patch \
    file://3f26c1227e3b08010f2a65379cecf4cb4b5933fa.patch \
    file://c5883be23519921254c6940873ee8db04979c20a.patch \
    file://91-oh-sdl-cursor.patch \
    file://fix_baum_c_compilation.patch \
    file://fix_fortify_source_compilation.patch \
    file://fallback.to.safe.mmap_min_addr.patch \
    file://linux-user-fix-running-programs-with-iwmmxt.patch \
    "

SRC_URI[qemu-0.12.4.md5sum] = "93e6b134dff89b2799f57b7d9e0e0fc5"
SRC_URI[qemu-0.12.4.sha256sum] = "1a29a5b5151162d1de035c4926d1a1dbffee4a145ef61ee865d6b82aaea0602e"

BBCLASSEXTEND="native"

S = "${WORKDIR}/qemu-${PV}"

EXTRA_OECONF += " --disable-curl --disable-sdl --disable-strip \
                "

EXTRA_OECONF_append_virtclass-native += " --extra-cflags="-I${STAGING_INCDIR_NATIVE}""

inherit autotools

do_configure() {
	${S}/configure --prefix=${prefix} ${EXTRA_OECONF}
}
