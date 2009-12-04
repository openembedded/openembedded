require ttf.inc

DESCRIPTION="TrueType Unicode fonts from the Free UCS Outline Fonts Project"
HOMEPAGE="http://savannah.nongnu.org/projects/freefont/"

PR = "r1"

SRC_URI = "http://ftp.gnu.org/gnu/freefont/freefont-ttf-${PV}.tar.gz"

S = "${WORKDIR}/freefont-${PV}"

FILES_${PN}-doc = "${datadir}/doc/ttf-freefont/README \
                   ${datadir}/doc/ttf-freefont/AUTHORS \
"

FILES_${PN} = "${datadir}"


do_install_append() {
	install -d ${D}${datadir}/doc/
	install -d ${D}${datadir}/doc/ttf-freefont
	install -m 0644 ${S}/README ${D}${datadir}/doc/ttf-freefont
	install -m 0644 ${S}/AUTHORS ${D}${datadir}/doc/ttf-freefont
}
