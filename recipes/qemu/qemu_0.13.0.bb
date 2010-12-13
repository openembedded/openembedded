LICENSE = "GPL"
DEPENDS = "zlib ncurses gnutls"
PR = "r2"
DEFAULT_PREFERENCE = "-1"
SRC_URI = "\
    http://download.savannah.gnu.org/releases/qemu/qemu-${PV}.tar.gz \
    file://leftover.patch \
    file://91-oh-sdl-cursor.patch \
    file://fix_baum_c_compilation.patch \
    file://fallback.to.safe.mmap_min_addr.patch \
    file://parallel-build.patch \
    "
SRC_URI[md5sum] = "397a0d665da8ba9d3b9583629f3d6421"
SRC_URI[sha256sum] = "1e6f5851b05cea6e377c835f4668408d4124cfb845f9948d922808743c5fd877"
BBCLASSEXTEND="native"

S = "${WORKDIR}/qemu-${PV}"

EXTRA_OECONF += " --disable-curl --disable-sdl --disable-strip \
                "

EXTRA_OECONF_append_virtclass-native = " --extra-cflags="-I${STAGING_INCDIR_NATIVE}""

inherit autotools

PARALLEL_MAKE = ""

do_configure() {
	${S}/configure --prefix=${prefix} ${EXTRA_OECONF}
}
