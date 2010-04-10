require avahi.inc

PR = "r1"

DEPENDS += "avahi gtk+"

AVAHI_GTK = "--enable-gtk"

S = "${WORKDIR}/avahi-${PV}"

do_stage() {
        install -d ${STAGING_INCDIR}/avahi-ui
	cp ${S}/avahi-ui/*.h ${STAGING_INCDIR}/avahi-ui/
        oe_libinstall -C avahi-ui -a -so libavahi-ui ${STAGING_LIBDIR}
}

PACKAGES = "${PN} ${PN}-dbg"

FILES_${PN} = "${libdir}/libavahi-ui*.so.*"
FILES_${PN}-dbg += "${libdir}/.debug/libavah-ui*"

SRC_URI[md5sum] = "a83155a6e29e3988f07e5eea3287b21e"
SRC_URI[sha256sum] = "9220d974f5515b8ccfa3900cd72cedcac0fa4cc87ca3c64405f7c55346cbba59"
