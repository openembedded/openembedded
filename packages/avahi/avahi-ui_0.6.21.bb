require avahi.inc

PR = "r7"

DEPENDS += "avahi gtk+"

SRC_URI += "file://dbus-pre-1.1.1-support.patch;patch=1"
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
