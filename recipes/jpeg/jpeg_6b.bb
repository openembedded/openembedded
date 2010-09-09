DESCRIPTION = "libjpeg is a library for handling the JPEG (JFIF) image format."
LICENSE ="jpeg"
SECTION = "libs"
PRIORITY = "required"

DEPENDS = "libtool-cross"
RPROVIDES_${PN} = "jpeg"

PR = "r10"

#SRC_URI = "http://www.ijg.org/files/jpegsrc.v${PV}.tar.gz \
SRC_URI = "ftp://aeneas.mit.edu/pub/gnu/ghostscript/jpegsrc.v${PV}.tar.gz \
	   file://debian.patch \
	   file://ldflags.patch \
	   file://paths.patch \
	   file://libtool_tweak.patch"
S = "${WORKDIR}/jpeg-${PV}"

inherit autotools

EXTRA_OECONF="--enable-static --enable-shared"
LIBTOOL = "${HOST_SYS}-libtool"
EXTRA_OEMAKE = "'LIBTOOL=${LIBTOOL}'"

CFLAGS_append = " -D_REENTRANT"

do_configure_prepend () {
	rm -f ${S}/ltconfig
	rm -f ${S}/ltmain.sh
}

do_install() {
	install -d ${D}${bindir} ${D}${includedir} \
		   ${D}${mandir}/man1 ${D}${libdir}
	oe_runmake 'DESTDIR=${D}' install
}

PACKAGES =+ 		"jpeg-tools "
FILES_jpeg-tools = 	"${bindir}/*"

NATIVE_INSTALL_WORKS = "1"
BBCLASSEXTEND = "native"

SRC_URI[md5sum] = "dbd5f3b47ed13132f04c685d608a7547"
SRC_URI[sha256sum] = "75c3ec241e9996504fe02a9ed4d12f16b74ade713972f3db9e65ce95cd27e35d"
