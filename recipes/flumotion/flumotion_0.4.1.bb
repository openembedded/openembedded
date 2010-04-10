DESCRIPTION = "Fluendo Streaming Server"
LICENSE = "GPL"
DEPENDS = "gstreamer python-imaging python-gst python-twisted python-pygtk"
RDEPENDS = "python-resource python-pprint python-threading \
            python-imaging python-xml python-curses \
            python-compression python-fcntl python-pygobject \
            python-pickle python-netclient python-datetime \
            python-crypt python-twisted-core python-twisted-web \
            python-lang python-zopeinterface  python-textutils \
            python-gst python-misc"
RDEPENDS_${PN}-gui = "${PN} python-pygtk python-pycairo"
PR = "r10"

SRC_URI = "http://www.flumotion.net/src/flumotion/flumotion-${PV}.tar.bz2 \
           file://python-path.patch;patch=1 \
           file://no-check-for-python-stuff.patch;patch=1"

inherit autotools distutils-base pkgconfig

export EPYDOC = "no"

EXTRA_OECONF += "--with-python-includes=${STAGING_INCDIR}/../"

PACKAGES =+ "flumotion-gui"

FILES_${PN}-dbg += "${libdir}/flumotion/python/flumotion/extern/*/.debug/*"
FILES_${PN} = "${bindir} ${sbindir} ${libdir}/flumotion"
FILES_${PN}-dev += "${libdir}/pkgconfig"
FILES_${PN}-gui = "${bindir}/flumotion-admin ${bindir}/flumotion-tester \
                   ${libdir}/flumotion/python/flumotion/admin/gtk \
                   ${libdir}/flumotion/python/flumotion/component/*/admin_gtk* \
                   ${libdir}/flumotion/python/flumotion/component/*/*/admin_gtk* \
                   ${libdir}/flumotion/python/flumotion/extern/*.py* \
                   ${libdir}/flumotion/python/flumotion/extern/fdpass/*.py* \
                   ${libdir}/flumotion/python/flumotion/extern/fdpass/fdpass.so \
                   ${libdir}/flumotion/python/flumotion/extern/pytrayicon/*.py* \
                   ${libdir}/flumotion/python/flumotion/extern/pytrayicon/pytrayicon.so \
                   ${libdir}/flumotion/python/flumotion/manager \
                   ${libdir}/flumotion/python/flumotion/ui \
                   ${libdir}/flumotion/python/flumotion/wizard \
                   ${datadir}/pixmaps ${datadir}/flumotion ${datadir}/applications"

SRC_URI[md5sum] = "85563f1167a3265cf61c8886c318dda7"
SRC_URI[sha256sum] = "a24640d8ca9c485d7611880193f18e5ae62af07e3b9464904f3602277f1d4097"
