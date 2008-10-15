DESCRIPTION = "Common icons for GPE"
LICENSE = "GPL"
SECTION = "gpe"

RDEPENDS = "gdk-pixbuf-loader-png"


inherit gpe

PR = "r1"

#only icons present in the package
PACKAGE_ARCH = "all"
FILES_${PN} = "${datadir}/gpe"

