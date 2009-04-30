LICENSE = "GPL"
DEPENDS = "zlib"

# Need to port OE patches there
DEFAULT_PREFERENCE = "-1"

FILESPATH = "${FILE_DIRNAME}/qemu-${PV}"
FILESDIR = "${WORKDIR}"

SRC_URI = "\
    http://download.savannah.gnu.org/releases/qemu/qemu-${PV}.tar.gz \
    "

S = "${WORKDIR}/qemu-${PV}"

EXTRA_OECONF += "--disable-gfx-check"

inherit autotools

do_configure() {
	${S}/configure --prefix=${prefix} ${EXTRA_OECONF}
}
