SECTION = "console/utils"
DESCRIPTION = "Display all information about a file that the stat() call provides and all information a filesystem that statfs() provides."
LICENSE = "GPL"

BBCLASSEXTEND = "native"

PR = "r1"

SRC_URI = "ftp://metalab.unc.edu/pub/Linux/utils/file/stat-3.3.tar.gz"

do_install() {
	install -d ${D}${bindir} ${D}${mandir}/man1
	install -m 755 stat ${D}${bindir}
	install -m 644 stat.1 ${D}${mandir}/man1
}

#do_install_virtclass-native() {
#	install -d ${D}${bindir}
#	install -m 755 stat ${D}${bindir}
#}

NATIVE_INSTALL_WORKS = "1"

SRC_URI[md5sum] = "37e247e8e400ad9205f1b0500b728fd3"
SRC_URI[sha256sum] = "7071f0384a423a938dd542c1f08547a02824f6359acd3ef3f944b2c4c2d1ee09"
