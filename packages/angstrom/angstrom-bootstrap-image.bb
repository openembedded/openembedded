#Angstrom bootstrap image
LICENSE = MIT
MAINTAINER = "Koen Kooi <koen@dominion.kabel.utwente.nl>"
PR = "r2"

DEPENDS = "task-angstrom task-base"
RDEPENDS = "task-base-core-default task-base angstrom-base-depends"

export IMAGE_BASENAME = "bootstrap-image"
export IMAGE_LINGUAS = ""
export IPKG_INSTALL = "${RDEPENDS}"

inherit image_ipk

