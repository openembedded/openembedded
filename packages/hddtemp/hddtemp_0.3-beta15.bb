SECTION = "console/utils"
DESCRIPTION = "hddtemp is a small utility that gives you the temperature of your hard drive by reading S.M.A.R.T. informations"
LICENSE = "GPL"

SRC_URI = "http://www.guzu.net/files/hddtemp-${PV}.tar.bz2 \
	http://www.guzu.net/linux/hddtemp.db"

S = "${WORKDIR}/hddtemp-${PV}"

FILES_${PN} += "/usr/share/misc/hddtemp.db"

inherit autotools

do_install_append() {
	install -d ${D}/usr/share/misc
	install -m 0644 ${WORKDIR}/hddtemp.db ${D}/usr/share/misc
}
