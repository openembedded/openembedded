DESCRIPTION = "Perl5 access to Berkeley DB version 1.x"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS = "virtual/db"
RDEPENDS_${PN} += "perl-module-extutils-makemaker"
PR = "r0"

BBCLASSEXTEND = "native"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/P/PM/PMQS/DB_File-${PV}.tar.gz;name=db-file-perl-${PV}"
SRC_URI[db-file-perl-1.820.md5sum] = "28979bee29d8075b0dffab02fe29df6e"
SRC_URI[db-file-perl-1.820.sha256sum] = "eae8d2d2144504118773f3e1787321d2c757e7c5abf0a60591c73495352ddf4a"

S = "${WORKDIR}/DB_File-${PV}"

do_configure_prepend() {
	export DB_FILE_LIB=${STAGING_LIBDIR}
}

inherit cpan
