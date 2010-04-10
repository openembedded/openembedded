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

SRC_URI[md5sum] = "cafd71a5bff0c57bcd248273b2541c05"
SRC_URI[sha256sum] = "15116da28bc90e961bd5fea454adf79272bc741f86d9636ed8b9b771d74814c3"
