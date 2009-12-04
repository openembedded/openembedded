DESCRIPTION = "Epydoc is a tool for generating API documentation for Python modules, based on their docstrings" 
SECTION = "devel/python" 
PRIORITY = "optional" 
LICENSE = "MIT" 
HOMEPAGE = "http://epydoc.sourceforge.net/" 
SRCNAME = "epydoc" 
DEPENDS = "python" 
 
SRC_URI = "http://downloads.sourceforge.net/project/${SRCNAME}/${SRCNAME}/${PV}/${SRCNAME}-${PV}.tar.gz" 
S = "${WORKDIR}/${SRCNAME}-${PV}" 
 
inherit distutils 
