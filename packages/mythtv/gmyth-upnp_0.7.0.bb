DESCRIPTION = "GMyth is a library to access MythTV backend services."
LICENSE = "LGPLv2""
HOMEPAGE = "http://gmyth.sourceforge.net/wiki/index.php/Main_Page"

PR = "r3"

DEPENDS = "glib-2.0 mysql gmyth libupnp"

SRC_URI = "${SOURCEFORGE_MIRROR}/gmyth/${PN}_0.7-indt1.tar.gz"
S = "${WORKDIR}/${PN}"

inherit autotools

AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_compile_append() {
        sed -i -e s:${STAGING_DIR_TARGET}::g \
	       -e s,Version:,Version:\ 0\.7\.0,g \
	       -e s:/${TARGET_SYS}::g \   
               -e s:clinkc::g \
                  gmyth-upnp.pc
}

do_install_append() {
	mv ${D}/${bindir}/test ${D}/${bindir}/gmyth-upnp-test
}

do_stage() {
        autotools_stage_all
}

