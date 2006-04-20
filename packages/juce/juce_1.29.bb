DESCRIPTION = "JUCE is a cross-platform application framework"
HOMEPAGE = "http://www.rawmaterialsoftware.com/juce"
AUTHOR = "Julian Stoerer"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
DEPENDS = "alsa-lib freetype x11"
PR = "r0"

#FIXME the patches are a) HACKS and b) something's wrong with lineend conversion
SRC_URI = "http://www.rawmaterialsoftware.com/juce/downloads/juce_1_29.zip \
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

PACKAGES = "jucedemo"
FILES_jucedemo = "${bindir}"

