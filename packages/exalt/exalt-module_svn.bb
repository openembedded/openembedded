require exalt.inc

DEPENDS = "edbus libexalt-dbus"
RDEPENDS_${PN} = "exalt"

SRC_URI += "file://autotools-fix.patch;patch=1;minrev=78"

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"

FILES_${PN} += "${libdir}/enlightenment/modules/module_exalt/*.edj \
                ${libdir}/enlightenment/modules/module_exalt/*/*.so \
                ${libdir}/enlightenment/modules/module_exalt/*.desktop \
                ${libdir}/enlightenment/modules/module_exalt/module_exalt"
FILES_${PN}-dev += "${libdir}/enlightenment/modules/module_exalt/*/*.a \
                    ${libdir}/enlightenment/modules/module_exalt/*/*.la"
FILES_${PN}-dbg += "${libdir}/enlightenment/modules/module_exalt/*/.debug"
FILES_${PN}-locale += "${libdir}/enlightenment/modules/module_exalt/locale"

EXALT_MODULE = "module"
