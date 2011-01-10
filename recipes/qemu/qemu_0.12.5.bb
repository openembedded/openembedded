LICENSE = "GPL"
DEPENDS = "zlib ncurses gnutls"

PR = "r2"

SRC_URI = "\
    http://download.savannah.gnu.org/releases/qemu/qemu-${PV}.tar.gz \
    file://02_kfreebsd.patch \
    file://03_support_pselect_in_linux_user_arm.patch \
    file://05_bochs_vbe.diff \
    file://06_sh4.diff \
    file://leftover.patch \
    file://3f26c1227e3b08010f2a65379cecf4cb4b5933fa.patch \
    file://c5883be23519921254c6940873ee8db04979c20a.patch \
    file://91-oh-sdl-cursor.patch \
    file://fix_baum_c_compilation.patch \
    file://fallback.to.safe.mmap_min_addr.patch \
    file://linux-user-fix-running-programs-with-iwmmxt.patch \
    file://qemu-sh4-mmapped-ITLB.patch \
    file://qemu-sh4-improve-tlb.patch \
    "

SRC_URI[md5sum] = "1d02ee0a04dfae2894340273372c1de4"
SRC_URI[sha256sum] = "a6a7b30b53591e160b5c7fd9319985673174e9ea47b182dbe63bc99357741f58"

BBCLASSEXTEND="native"

S = "${WORKDIR}/qemu-${PV}"

EXTRA_OECONF += " --disable-curl --disable-sdl --disable-strip \
                "

EXTRA_OECONF_append_virtclass-native = " --extra-cflags="-I${STAGING_INCDIR_NATIVE}""

inherit autotools

do_configure() {
	${S}/configure --prefix=${prefix} ${EXTRA_OECONF}
}
