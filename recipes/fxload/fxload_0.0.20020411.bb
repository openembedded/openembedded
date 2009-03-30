DESCRIPTION = "fxload loads firmware into the ezusb chips"
AUTHOR = "Stephen Williams, David Brownell"
HOMEPAGE = "http://linux-hotplug.sourceforge.net/"
SECTION = "admin"
LICENSE = "GPL"
DEPENDS = "linux-libc-headers"
PR = "r1"

SRC_URI = "http://dfn.dl.sourceforge.net/sourceforge/linux-hotplug/fxload-2002_04_11.tar.gz \
           file://usbheader.patch;patch=1"

S = "${WORKDIR}/fxload-2002_04_11"

FILES_${PN} = "${base_sbindir}/fxload"

do_install() {
	mkdir -p ${D}/sbin/
	cp ${S}/fxload ${D}/sbin/fxload
}
