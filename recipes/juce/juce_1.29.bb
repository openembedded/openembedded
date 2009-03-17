DESCRIPTION = "JUCE is a cross-platform application framework"
HOMEPAGE = "http://www.rawmaterialsoftware.com/juce"
AUTHOR = "Julian Stoerer"
LICENSE = "GPL"
DEPENDS = "alsa-lib freetype virtual/libx11"
PR = "r0"

#FIXME the patches are a) HACKS and b) something's wrong with lineend conversion
SRC_URI = "http://downloads.openmoko.org/sources/juce_${@bb.data.getVar('PV',d,1).split('.')[0]}_${@bb.data.getVar('PV',d,1).split('.')[1]}.zip \
           file://remove-x86isms.patch;patch=1 \
           file://no-opengl.patch;patch=1"
S = "${WORKDIR}/juce"

LIB = "libjuce_debug"

do_compile() {
	cd ${S}/build/linux && oe_runmake
	cd ${S}/demo/build/linux && oe_runmake
}

do_stage() {
	oe_libinstall -a -C bin ${LIB} ${STAGING_LIBDIR}
	#FIXME add includes
}

do_install() {
	install -d ${D}${bindir}
	install -m 0655 demo/build/linux/build/jucedemo ${D}${bindir}
}

PACKAGES = "${PN}-dbg jucedemo ${PN}"
FILES_jucedemo = "${bindir}"

