DESCRIPTION = "Patcher is a perl script for managing patches."
HOMEPAGE = "http://www.holgerschurig.de/patcher.html"
LICENSE = "Perl"
DEPENDS = ""
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Holger Schurig <hs4233@mail.mn-solutions.de>"
PACKAGES = ""
PR = "r1"

inherit native

SRC_URI = "http://www.holgerschurig.de/files/linux/patcher-${PV}.tar.bz2"
S = "${WORKDIR}/patcher"

PATCHCLEANCMD = ""
PATCHCMD = "num='%s'; name='%s'; file='%s'; patch -p "$num" -i "$file""

do_stage() {
	install -m 0755 patcher.py ${STAGING_BINDIR}/patcher
}
