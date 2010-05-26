DESCRIPTION = "Hard disk temperature monitor daemon"
SECTION = "console/network"
PR = "r0"
LICENSE = "GPL"

SRC_URI = "http://download.savannah.nongnu.org/releases/hddtemp/hddtemp-0.3-beta15.tar.bz2 \
	   file://hddtemp-no-nls-support.patch \
	   file://hddtemp.db \
		"

inherit autotools

FILES_${PN} += "/usr/share/misc/hddtemp.db"

do_install_append() {
	install -d ${D}/usr/share/misc/
	install -m 0644 ${WORKDIR}/hddtemp.db ${D}/usr/share/misc/hddtemp.db
}

SRC_URI[md5sum] = "8b829339e1ae9df701684ec239021bb8"
SRC_URI[sha256sum] = "618541584054093d53be8a2d9e81c97174f30f00af91cb8700a97e442d79ef5b"
