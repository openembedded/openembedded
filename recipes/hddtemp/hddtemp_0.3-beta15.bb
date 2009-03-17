DESCRIPTION = "Hard disk temperature monitor daemon"
SECTION = "console/network"
PR = "r0"
LICENSE = "GPL"

SRC_URI = "http://download.savannah.nongnu.org/releases/hddtemp/hddtemp-0.3-beta15.tar.bz2 \
	   file://hddtemp-no-nls-support.patch;patch=1 \
	   file://hddtemp.db \
		"

inherit autotools

FILES_${PN} += "/usr/share/misc/hddtemp.db"

do_install_append() {
	install -d ${D}/usr/share/misc/
	install -m 0644 ${WORKDIR}/hddtemp.db ${D}/usr/share/misc/hddtemp.db
}
