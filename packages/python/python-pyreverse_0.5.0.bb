DESCRIPTION = "PyReverse is a set of tools for reverse engineering Python code. So far, it features dependency analysis \
tools, documentation generation, and XMI generation for importation in a UML modeling tool. A special module can be  \
used to generate files readable by Argo UML."
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
RDEPENDS = "python-core python-logilab python-pyxml"
SRCNAME = "pyreverse"

SRC_URI = "ftp://ftp.logilab.org/pub/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

