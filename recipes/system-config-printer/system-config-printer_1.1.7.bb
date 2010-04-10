DESCRIPTION = "cups Python Bindings"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPLv2"
DEPENDS = "cups"
RDEPENDS_python-cupshelpers += "python-pprint python-netclient python-misc" 
PR = "r2"

SRC_URI = "http://cyberelk.net/tim/data/${PN}/1.1/${PN}-${PV}.tar.bz2"
S = "${WORKDIR}/${PN}-${PV}"

inherit distutils

do_configure_prepend() {
    # disable xmlto usage since we won't use manpages
    sed -i 's,xmlto,echo xmlto,g' ${S}/Makefile*
}

PACKAGES += "python-cupshelpers"

FILES_${PN} = "" # we're not going to support it for now
FILES_python-cupshelpers = "${libdir}"

SRC_URI[md5sum] = "a77bde5adc5ee8822b0764ff786ccc09"
SRC_URI[sha256sum] = "fdd50cb114151c66b8180c0ce90ba0e99f77a69770ac21598a87be935eec2224"
