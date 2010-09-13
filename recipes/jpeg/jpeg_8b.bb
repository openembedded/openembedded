DESCRIPTION = "libjpeg is a library for handling the JPEG (JFIF) image format."
LICENSE = "jpeg"
SECTION = "libs"
PRIORITY = "required"
PR = "r1"

# TODO: really needed?
RPROVIDES_${PN} = "jpeg"

SRC_URI = "\
    http://www.ijg.org/files/jpegsrc.v${PV}.tar.gz \
    file://0001-configure-make-jpeg-work-with-older-autotools.patch \
    "
S = "${WORKDIR}/jpeg-${PV}"

inherit autotools

EXTRA_OECONF = "--enable-static --enable-shared"
CFLAGS_append = " -D_REENTRANT"

PACKAGES =+ "${PN}-tools "
FILES_${PN}-tools = "${bindir}/*"

BBCLASSEXTEND = "native"

SRC_URI[md5sum] = "e022acbc5b36cd2cb70785f5b575661e"
SRC_URI[sha256sum] = "36e6208edec591bae8f2fc370ea4f991447badb6377a125c211ffa7b503174a7"
