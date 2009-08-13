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
