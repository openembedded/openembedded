SECTION = "console/utils"
DESCRIPTION = "Display all information about a file that the stat() call provides and all information a filesystem that statfs() provides."
LICENSE = "GPL"
MAINTAINER = "Holger Schurig <hs4388@mn-solutions.de>"

SRC_URI = "ftp://metalab.unc.edu/pub/Linux/utils/file/stat-3.3.tar.gz"

do_stage() {
	true
}

do_install() {
	install -d ${D}${bindir} ${D}${mandir}/man1
	install -s -m 755 stat ${D}${bindir}
	install -m 644 stat.1 ${D}${mandir}/man1
}
