DESCRIPTION = "The constraint package is a constraint \
satisfaction problem solver written in 100% pure Python, using \
constraint propagation algorithms. So far, facilities are \
provided to work with finite domains only."
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
SRCNAME = "constraint"

SRC_URI = "ftp://ftp.logilab.org/pub/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

