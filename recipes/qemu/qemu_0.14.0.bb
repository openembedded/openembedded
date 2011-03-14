LICENSE = "GPL"
DEPENDS = "zlib ncurses gnutls"
PR = "r0"
SRC_URI = "\
    http://download.savannah.gnu.org/releases/qemu/qemu-${PV}.tar.gz \
    file://leftover.patch \
    file://91-oh-sdl-cursor.patch \
    file://fix_baum_c_compilation.patch \
    file://fallback.to.safe.mmap_min_addr.patch \
    file://parallel-build.patch \
    "
SRC_URI[md5sum] = "f9d145d5c09de9f0984ffe9bd1229970"
SRC_URI[sha256sum] = "ba21e84d7853217830e167dae9999cdbff481189c6a0bb600ac7fb7201453108"

BBCLASSEXTEND="native"

S = "${WORKDIR}/qemu-${PV}"

EXTRA_OECONF += " --disable-curl --disable-sdl --disable-strip \
                "

EXTRA_OECONF_append_virtclass-native = " --extra-cflags="-I${STAGING_INCDIR_NATIVE}""

inherit autotools

do_configure() {
	${S}/configure --prefix=${prefix} ${EXTRA_OECONF}
}
