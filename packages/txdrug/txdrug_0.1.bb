DESCRIPTION = "Tx Drug Database"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
DEPENDS = "sqlite"
PR = "r1"

SRC_URI = "http://teax.sourceforge.net/txdrug-${PV}.tar.gz \
           file://${FILESDIR}/${palmtopdir}"
S = "${WORKDIR}/txdrug-tar"

inherit palmtop

do_install() {
        install -d ${D}${palmtopdir}
	cp -dfr `ls -dp ${WORKDIR}/${palmtopdir}/*|grep -v SCCS` ${D}${palmtopdir}/
        install -D -m 755 txdrug ${D}${palmtopdir}/bin/txdrug
}
