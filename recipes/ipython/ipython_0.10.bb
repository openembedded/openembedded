DESCRIPTION = "Enhanced Python Shell"
HOMEPAGE = "http://ipython.scipy.org/moin/"
SECTION = "devel/python"
LICENSE = "BSD"
DEPENDS = "less"
RDEPENDS = "python-pprint python-io python-shell python-misc python-lang \
            python-stringold python-codecs python-crypt python-threading \
            python-pydoc python-debugger python-textutils python-pickle \
            python-subprocess"

SRC_URI = "http://ipython.scipy.org/dist/ipython-${PV}.tar.gz"

inherit distutils

FILES_${PN} = "/"

SRC_URI[md5sum] = "dd10cd1b622c16c1afca2239fcc0dfdf"
SRC_URI[sha256sum] = "60d602637dc5f078b083a4ca5ab64364ba816bd72439844012ed11a30f88228c"
