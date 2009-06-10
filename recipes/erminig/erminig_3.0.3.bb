DESCRIPTION = "Erminig is a python application that provides two-way synchronization between Google Calendar and GPE Calendar."
HOMEPAGE = "https://garage.maemo.org/projects/erminig/"
SECTION = "devel/python"
LICENSE = "GPL"
PV="3.0.3"
PR="r0"

SRC_URI = "https://garage.maemo.org/frs/download.php/4737/erminig_3.0.3-3.tar.gz"
S = "${WORKDIR}/${PN}-${PV}"

inherit distutils

RDEPENDS_${PN} = "\
  python-pygtk \
  python-pysqlite2 \

"
FILES_${PN} = "${datadir}"


