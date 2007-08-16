DESCRIPTION = "PyReverse is a set of tools for reverse engineering Python code. So far, it features dependency analysis \
tools, documentation generation, and XMI generation for importation in a UML modeling tool. A special module can be  \
used to generate files readable by Argo UML."
SECTION = "devel/python"
HOMEPAGE = "http://www.logilab.org/2560"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS = "python-core python-logilab-common python-pyxml"
SRCNAME = "pyreverse"
PR = "ml0"

SRC_URI = "ftp://ftp.logilab.org/pub/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
           file://fix-future.patch;patch=1"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
