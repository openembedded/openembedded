DESCRIPTION = "urlgrabber is a pure python package that drastically simplifies the fetching of files."
HOMEPAGE = "http://linux.duke.edu/projects/urlgrabber/"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://linux.duke.edu/projects/urlgrabber/download/urlgrabber-${PV}.tar.gz"
S = "${WORKDIR}/urlgrabber-${PV}"

inherit distutils

SRC_URI[md5sum] = "2a92d8ce0d89c5e772a98e9b8dcd5b73"
SRC_URI[sha256sum] = "34d48f4f4390ed06c0fc8fac580f6fe4cd2bfb3557ff0f11254a7bea25d353ca"
