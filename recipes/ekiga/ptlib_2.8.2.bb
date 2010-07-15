DESCRIPTION = "Portable Tools Libary"
LICENSE = "MPL"

inherit gnome

DEPENDS += "libgsm openldap openssl expat virtual/libsdl alsa-lib"

SRC_URI = "${SOURCEFORGE_MIRROR}/opalvoip/ptlib-${PV}.tar.bz2;name=ptlib \
"
SRC_URI[ptlib.md5sum] = "3248cbea1af92439a10a4ef15824e9e3"
SRC_URI[ptlib.sha256sum] = "5e4518710e6f7daebe93581c388ef37c56fa3a1529b1ad48be86213ab3f3b8c7"

EXTRA_OECONF = "  --enable-exceptions "

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


