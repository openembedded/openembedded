DESCRIPTION = "OLE::Storage_Lite - Simple Class for OLE document interface"
SECTION = "libs"
LICENSE = "Artistic|GPL"
BBCLASSEXTEND = "native"
RDEPENDS_${PN} += "perl-module-extutils-makemaker"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/J/JM/JMCNAMARA/OLE-Storage_Lite-${PV}.tar.gz;name=ole-storage-lite-perl-${PV}"
SRC_URI[ole-storage-lite-perl-0.19.md5sum] = "1a713f5342c7d90e54ab0d9659650296"
SRC_URI[ole-storage-lite-perl-0.19.sha256sum] = "e72e055c35bd85ad7c20cf2adb6c89bdbf5725df969484fa6dc981d531ef2c9d"

S = "${WORKDIR}/OLE-Storage_Lite-${PV}"

inherit cpan

PACKAGE_ARCH = "all"
