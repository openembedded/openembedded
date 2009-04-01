DESCRIPTION = "hotplug2 is a daemon which dynamically creates and removes device nodes from \
/dev/, handles hotplug events and loads drivers at boot time. It replaces \
the hotplug and udev packages and requires a kernel not older than 2.6.12."
RPROVIDES_${PN} = "hotplug"

PR = "r1"

SRC_URI = "http://isteve.bofh.cz/~isteve/hotplug2/downloads/hotplug2-1.0-beta.tar.gz \
           file://hotplug2.sh \
	   "

S = "${WORKDIR}/hotplug2-1.0-beta"

inherit update-rc.d

INITSCRIPT_PARAMS = "start 04 S ."
INITSCRIPT_NAME = "hotplug2.sh"

LDFLAGS += "-ldl"
DESTDIR="${D}"

do_install () {
        install -d ${D}/lib/hotplug2
        install -d ${D}/sbin
	install -d ${D}${sysconfdir}/init.d/
	install ${WORKDIR}/hotplug2.sh ${D}${sysconfdir}/init.d/
	sed -i 's|^DESTDIR=*|DESTDIR="${D}"|' ${S}/Makefile
	sed -i 's|^DESTDIR=*|DESTDIR="${D}"|' ${S}/workers/Makefile
	oe_runmake install
}

FILES_${PN} += "${base_libdir}/hotplug2/* \
	       /sbin/hotplug2 \
	       ${sysconfdr}/init.d/hotplug2 \
	       "
FILES_${PN}-dbg += "/lib/hotplug2/.debug \
		   /sbin/.debug \
		   ${sysconfdir}/init.d/.debug \
		   "

