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

SRC_URI[md5sum] = "8a1bd1a9be272f4ddf4de99e5c1ad0dc"
SRC_URI[sha256sum] = "5540bc1a01f11ca66c3d7c31a43af670fd0f0044b8e38d142614872956548006"
