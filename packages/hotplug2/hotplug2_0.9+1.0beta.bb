DESCRIPTION = "hotplug2 is a daemon which dynamically creates and removes device nodes from \
/dev/, handles hotplug events and loads drivers at boot time. It replaces \
the hotplug and udev packages and requires a kernel not older than 2.6.12."
RPROVIDES_${PN} = "hotplug"
RREPLACES_${PN} = "udev"

SRC_URI = "http://isteve.bofh.cz/~isteve/hotplug2/downloads/hotplug2-1.0-beta.tar.gz \
           "

S = "${WORKDIR}/hotplug2-1.0-beta"

inherit update-rc.d

INITSCRIPT_PARAMS = "start 03 S ."
INITSCRIPT_NAME = "hotplug2"

LDFLAGS += "-ldl"
DESTDIR="${D}"

do_install_prepend () {
        install -d ${D}/lib/hotplug2
        install -d ${D}/sbin
}

FILES_${PN} += "${base_libdir}/hotplug2/*"
FILES_${PN}-dbg += "${base_libdir}/hotplug2/.debug"
