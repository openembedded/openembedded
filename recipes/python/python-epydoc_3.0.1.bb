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

SRC_URI[md5sum] = "cdd6f6c76dd8bab5e653a343a0544294"
SRC_URI[sha256sum] = "d4e5c8d90937d01b05170f592c1fa9b29e9ed0498dfe7f0eb2a3af61725b6ad1"
