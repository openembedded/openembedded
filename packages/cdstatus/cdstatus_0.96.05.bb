# cdstatus OE build file

PR="r2"
LICENSE="GPL"
HOMEPAGE = "http://cdstatus.sourceforge.net/"
FILES_${PN} += ${datadir}/cdstatus.cfg

SRC_URI="${SOURCEFORGE_MIRROR}/cdstatus/cdstatus-0.96.05.tar.gz \
	 file://cdstatus.patch;patch=1"

S="${WORKDIR}/cdstatus-0.96.05"

inherit autotools

do_install() {
	install -d 0755 ${D}/${bindir}
	install -d 0755 ${D}/${datadir}
	install -d 0755 ${D}/${mandir}
	install -m 0755 src/cdstatus          ${D}/${bindir}
	install -m 0644 cdstatus.cfg          ${D}/${datadir}
	install -m 0644 cdstatus.1            ${D}/${mandir}

}
