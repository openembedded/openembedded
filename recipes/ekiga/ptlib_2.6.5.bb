DESCRIPTION = "Portable Tools Libary"
LICENSE = "MPL"

PR = "r1"

inherit gnome

DEPENDS += "libgsm openldap openssl expat virtual/libsdl alsa-lib"

SRC_URI = "${SOURCEFORGE_MIRROR}/opalvoip/ptlib-${PV}.tar.bz2 \
           file://rgb16.patch;patch=1 \
"

do_configure() {
    libtoolize --force
	gnu-configize
	oe_runconf
}

do_compile_append() {
        sed -i -e s:${STAGING_DIR_TARGET}::g \
               -e s:/${TARGET_SYS}::g \
                  ptlib.pc
}

do_install_append() {
	chmod +x ${D}${libdir}/*
}

FILES_${PN} += "${libdir}/ptlib-${PV}/*/*/*.so"


