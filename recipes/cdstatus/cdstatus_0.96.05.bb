# cdstatus OE build file

PR ="r2"
LICENSE="GPL"
HOMEPAGE = "http://cdstatus.sourceforge.net/"
FILES_${PN} += "${datadir}/cdstatus.cfg"

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

SRC_URI[md5sum] = "cd7ea4ef72a08b388523c528d81ba3ca"
SRC_URI[sha256sum] = "f33cbb551e494747b76bfbeba3954b4839fe7c849f200746fd7dc21bd665aa56"
