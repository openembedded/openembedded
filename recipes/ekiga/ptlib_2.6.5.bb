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



SRC_URI[md5sum] = "db7fd581b66998cd76d96f8b7c3f22a1"
SRC_URI[sha256sum] = "78e290d3cf78d4dc15c7397b0edd138b4d29cf2ad0a7311bfc1c4dfb88f2a400"
