DESCRIPTION = "Implementation of the Service Availability Forum Application Interface Specification (AIS)"
LICENSE = "BSD"
DEPENDS = "cluster-glue corosync"

SRC_URI = " \
	ftp://ftp@openais.org/downloads/openais-${PV}/openais-${PV}.tar.gz;name=tar \
	file://fix-lcrso-linkage.patch;patch=1 \
	"
SRC_URI[tar.md5sum] = "f94ccb867358ac54ab24bc54def27335"
SRC_URI[tar.sha256sum] = "7ba87dc480a9dd224fe3a3732c966d6fdf6ec5f192bb184d586afa3703f808f2"

inherit autotools_stage

FILES_${PN}-dbg += "${libexecdir}/lcrso/.debug"