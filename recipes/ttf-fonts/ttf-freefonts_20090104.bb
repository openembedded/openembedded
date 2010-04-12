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

SRC_URI[md5sum] = "1128bb17763cde6990eacd5996f7def7"
SRC_URI[sha256sum] = "2b8e7164b0c362d5c5e90275b25772514d76d5fda3d54c026445611e467d638e"
